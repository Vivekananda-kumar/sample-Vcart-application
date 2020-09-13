package com.Vcart.VcartManagement.Storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Vcart.VcartManagement.Controller.Request.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query("SELECT t.categoryid FROM Category t where t.categoryname = ?1")
	int getCatIDByName(String name);
	
	@Query("SELECT t.categoryname FROM Category t where t.categoryid = ?1")
	String getCatNameByID(int i);

	
}
