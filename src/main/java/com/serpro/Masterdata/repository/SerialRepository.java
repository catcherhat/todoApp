package com.serpro.Masterdata.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.serpro.Masterdata.entity.SerialEntity;

import jakarta.transaction.Transactional;

//@Repository
public interface SerialRepository extends JpaRepository<SerialEntity, Long> {

	@Query("Select u from SerialEntity u")
	List<SerialEntity> find();

	@Transactional
	@Modifying
	@Query("Insert into SerialEntity(productId,productName,department,customerName,customerId,requestNo,status,createdDate)"
			+ "values(:productId,:productName ,:department,:customerName,:customerId,:requestNo,:status,:createdDate)")
	void insert(@Param("productId") Integer productId, @Param("productName") String productName,
			@Param("department") String department, @Param("customerName") String customerName,
			@Param("customerId") Integer customerId, @Param("requestNo") Integer requestNo,
			@Param("status") String status, @Param("createdDate") Date createdDate);

	@Transactional
	@Modifying
	@Query("Update SerialEntity u set  u.productName = :productName,u.department= :department,u.customerName= :customerName,u.customerId=:customerId,u.requestNo=:requestNo,u.status=:status,u.createdDate=:createdDate where u.productId=:productId")
	void update(@Param("productId") Integer productId, @Param("productName") String productName,
			@Param("department") String department, @Param("customerName") String customerName,
			@Param("customerId") Integer customerId, @Param("requestNo") Integer requestNo,
			@Param("status") String status, @Param("createdDate") Date createdDate);

//	@Query("insert into SerialEntity(productId) values (productId)",namedQuery = true)
//	void insertpid(@Param("productId") Integer productId);
}
