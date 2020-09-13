package com.Vcart.VcartManagement.Storage;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Vcart.VcartManagement.Controller.Request.Items;

@Repository
public interface SubCatRespository extends JpaRepository<Items, Integer> {

	@Query("SELECT t.quantity FROM Items t where t.subcatid = ?1")
	int getQuantitySubCat(int i);

	@Query("SELECT t.subcatid FROM Items t where t.subcatname = ?1")
	int getSubCatIdByName(String name);
	
	@Query("SELECT t.subcatname FROM Items t where t.subcatid = ?1")
	String getSubCatNameById(int id);

	@Transactional
	@Modifying
	@Query("UPDATE Items SET quantity=?1 WHERE subcatid = ?2")
	void setQuantitySubCat(int i, int subcatid);

}
