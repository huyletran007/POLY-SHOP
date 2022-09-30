package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poly.entity.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, String>{
	@Query("SELECT DISTINCT ar.account  FROM Authority ar WHERE ar.role.id IN ('ADMIN', 'STAFF')")
	List<Account> getAdministrators();
	
	@Query(value="Select a.Username, a.Fullname, a.email, a.image, "
			+ "sum(odt.price * odt.quantity) as totalPayment "
			+ "From Accounts a inner join orders o on a.Username = o.Username "
			+ "inner join OrderDetails odt on o.Id = odt.OrderId "
			+ "Group by a.Username, a.Fullname, a.email, a.image "
			+ "order by totalPayment desc",nativeQuery = true)
	List<Object[]> top10Customer();
	
	@Query("SELECT a FROM Account a WHERE a.username LIKE ?1 or a.password LIKE ?1 "
			+ "or a.fullname LIKE ?1 or a.email LIKE ?1 or a.image LIKE ?1")
	List<Account> findRequest(String string); 
}
