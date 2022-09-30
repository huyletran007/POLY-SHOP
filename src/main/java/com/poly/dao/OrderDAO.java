package com.poly.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.poly.entity.Order;
import com.poly.entity.Product;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer> {
	@Query("SELECT o FROM Order o WHERE o.account.username=?1")
	List<Order> findByUsername(String username);

//	@Query("UPDATE Orders o SET o.Available = ?1 WHERE o.Id=?1")
//	Boolean setOrderAvai(Boolean avai, Integer id);
	@Modifying @Transactional
	@Query(value="Update Orders set Available = 1 where Id = ?1", nativeQuery = true)
    public void acceptById(int id);
	/* Summary */
	@Query(value = "Select count(*) from Orders where CreateDate = CAST( GETDATE() AS Date)", nativeQuery = true)
	Long getTodayOrder();

	@Query(value = "Select t.last7Days as 'date', ISNULL(sum(price*quantity),0) as ' totalPayment' "
			+ "From (Select cast(Getdate()as Date) last7Days  " + "	Union all "
			+ "	Select DateAdd(day,-1,cast(getdate()as date)) " + "	Union all "
			+ "	Select DateAdd(day,-2,cast(getdate()as date)) " + "	Union all "
			+ "	Select DateAdd(day,-3,cast(getdate()as date)) " + "	Union all "
			+ "	Select DateAdd(day,-4,cast(getdate()as date)) " + "	Union all "
			+ "	Select DateAdd(day,-5,cast(getdate()as date)) " + "	Union all "
			+ "	Select DateAdd(day,-6,cast(getdate()as date)) " + "	Union all "
			+ "	Select DateAdd(day,-7,cast(getdate()as date)) "
			+ ") t Left Join Orders t1 on cast(t.last7Days as date) = Cast(t1.CreateDate as date) "
			+ "left join OrderDetails dt on  t1.Id = dt.OrderId "
			+ "Group by cast(t.last7Days as Date)", nativeQuery = true)
	List<Object[]> getRevenueLast7Days();
	
}
