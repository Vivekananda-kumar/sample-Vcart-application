package com.Vcart.VcartManagement.Storage;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Vcart.VcartManagement.Controller.Request.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT t.quantity FROM Product t where t.productname = ?1")
	int getQuantityByName(String name);

	/*@Query("SELECT t.productid FROM Product t where t.productname = ?1 and t.subcatid = ?2")
	int getIdByName(String name, int id);*/

	@Query("SELECT t.productid FROM Product t where t.productname = ?1")
	int getIdByName(String name);

	@Query("SELECT t FROM Product t where t.productname = ?1")
	Product getProductByName(String name);

	@Query("SELECT t.subcatid FROM Product t where t.productname = ?1")
	int getSubCatIdByName(String name);

	@Transactional
	@Modifying
	@Query("DELETE from Product t where t.productname = ?1")
	void deleteProductByName(String name);

}
