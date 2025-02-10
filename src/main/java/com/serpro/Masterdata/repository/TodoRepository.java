package com.serpro.Masterdata.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.serpro.Masterdata.entity.Todo;

import jakarta.transaction.Transactional;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer>{
	
	@Transactional
	@Modifying
	@Query("Insert into Todo(id,username,description,targetdate,status,done)values(:i,:username,:description,:targetdate,:status,:done)")
	void insert(@Param(value = "i")int i,@Param(value = "username") String username,@Param(value = "description") String description,@Param(value = "targetdate") LocalDate targetdate,@Param(value = "status") String status,@Param(value = "done") String done);

	@Transactional
	@Modifying
	@Query("Select u from Todo u")
	public List<Todo> getall();
	
	@Transactional
	@Modifying
	@Query("Delete from Todo u where u.id= :id ")
	void delete(@Param(value = "id") int id);

	
	@Transactional
	@Modifying
	@Query("Update Todo u set u.username=:username, u.description=:desc,u.status=:status,u.targetdate=:tdate,u.done=:done  where u.id=:id ")
	void update(@Param(value = "username") String username,@Param(value = "desc") String description,@Param(value = "status") String status,@Param(value = "tdate") LocalDate targetdate,@Param(value = "done") String done,@Param(value = "id") long id);

	


}
