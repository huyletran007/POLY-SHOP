$(document).ready(function() {

	$('.items').slick({
		infinite: true,
		slidesToShow: 3,
		slidesToScroll: 3
	});
});

$(document).ready(function() {
	$(window).scroll(function() {
		if ($(this).scrollTop()) {
			$('nav').addClass('sticky');
		} else {
			$('nav').removeClass('sticky');
		}
	});
});
const passField = document.querySelector(".passU");
       const showBtn = document.querySelector("span i");
       showBtn.onclick = (()=>{
         if(passField.type === "password"){
           passField.type = "text";
           showBtn.classList.add("hide-btn");
         }else{
           passField.type = "password";
           showBtn.classList.remove("hide-btn");
         }
       });
const app = angular.module("myApp", []);
//var cart = new Array();
app.controller("myCtrl", function($scope, $http) {
	
});
app.controller("sanphamCtrl", function($scope, $http) {
	/*
    * QUẢN LÝ GIỎ HÀNG
    */
   $scope.cart={
       items:[],

       //Thêm sản phẩm vào giỏ hàng
       add(id){
           var item = this.items.find(item=>item.id == id);
           if(item){
               item.qty++;
               this.saveToLocalStorage();
           }else{
               $http.get(`/rest/products/${id}`).then(resp=>{
                   resp.data.qty=1;
                   this.items.push(resp.data);
                   this.saveToLocalStorage();
               })
           }
       },

       //Xoá sản phẩm khỏi giỏ hàng
       remove(id){
           var index = this.items.findIndex(item=>item.id == id);
           this.items.splice(index, 1);
           this.saveToLocalStorage();
       },

       //Xoá sạch các mặt hàng trong giỏ
       clear(){
           this.items = [];
           this.saveToLocalStorage();
       },
       
       //Tính thành tiền của một sản phẩm
       amt_of(item){},

       //Tính tổng số lượng các mặt hàng trong giỏ
       get count(){
        return this.items
            .map(item=>item.qty)
            .reduce((total,qty)=> total+=qty,0);
       },

       //Tổng thành tiền các mặt hàng trong giỏ
       get amount(){
        return this.items
            .map(item=>item.qty * item.newprice)
            .reduce((total,qty)=> total+=qty,0);
       },
       //Lưu giỏ hàng vào local storage
       saveToLocalStorage(){
           //dùng angular để copy xong đổi các mặt hàng sang json
           var json = JSON.stringify(angular.copy(this.items));
           localStorage.setItem("cart",json);
       },

       //Đọc giỏ hàng từ local storage
       loadFromLocalStorage(){
           var json = localStorage.getItem("cart");
           this.items = json?JSON.parse(json) : [];
       },
   };
   $scope.cart.loadFromLocalStorage();

   $scope.order = {
       createDate:new Date(),
       address:"",
       account:{username:$("#username").text()},
       get orderDetails(){
           return $scope.cart.items.map(item=>{
               return{
                   product:{id:item.id},
                   price:item.newprice,
                   quantity:item.qty
               }
           })
       },
       purchase(){
           var order = angular.copy(this);
           //Thực hiện đặt hàng
           $http.post("/rest/orders",order).then(resp=>{
               alert("Đặt hàng thành công!");
               $scope.cart.clear();
               location.href = "/order/detail/"+resp.data.id;
           }).catch(err=>{
				
               alert("Đặt hàng lỗi!")
               console.log(err);
           })
       }
   };
  
	
	$scope.items1 = [];
    //Sự kiện khi bắt đầu chương trình
    $scope.initialize = function() {
        //Load products
        $http.get("/rest/products").then(resp => {
            $scope.items1 = resp.data;
        });
        //load all roles
		$http.get("/rest/roles").then(resp=>{
			$scope.roles = resp.data;
		});
		
		//load accounts
		$http.get("/rest/accounts").then(resp=>{
			$scope.items = resp.data;
		})
    }
    $scope.initialize();
    $scope.searchProduct = function(info) {
        //Load products
        $http.get(`/rest/products/search/${info}`).then(resp => {
            $scope.items1 = resp.data;
        }).catch(error => {
            $scope.initialize();
        });
    }
    //Dang ky
	$scope.items2 = [];
	//Chọn roles
	$scope.toggleRole = function(role){
		var compareElement = -1;
		var idx = $scope.selection.indexOf(role);
		console.log(idx);
		//Currently Selected
		if(idx>-1){
			$scope.selection.splice(idx,1);
		}
		//Is newly added
		else{
			$scope.selection.push(role);
		}
	}
    //Thêm account
    $scope.create = function(){
		var item = angular.copy($scope.form);
		$http.post(`/rest/accounts/accountsManage`,item).then(resp=>{
			$scope.items2.push(resp.data);
			console.log(resp.data);
			//thêm phân quyền
			$scope.selection.forEach(r=>{
				var authority = {account:item,role:$scope.toggleRole('USER')};
				$http.post(`/rest/authorities`,authority).then(resp=>{
					$scope.items2.push(resp.data);
				}).catch(err=>{
					console.log("Error ",err);
				})
			})
			alert("Thêm tài khoản thành công!");
		}).catch(err=>{
			console.log("Error ",err);
			alert("Thêm tài khoản thất bại!");
		})
    }
});

