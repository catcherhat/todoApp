//package com.serpro.Masterdata.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import jakarta.transaction.Transactional;
//
//public abstract class TodoRepositoryImpl implements TodoRepository{
//	@Transactional
//	@Modifying
//	@Query("Insert into Todo(id,username,description,targetdate,status,done)values(:i,:username,:description,:targetdate,:status,:done)")
//	@Override
//	public void insert(@Param(value = "i")int i,@Param(value = "username") String username,@Param(value = "description") String description,@Param(value = "targetdate") LocalDate targetdate,@Param(value = "status") String status,@Param(value = "done") String done);
//
//	@Transactional
//	@Modifying
//	@Query("Select u from Todo u")
//	@Override
//	public List<Todo> getall();
//	
//	@Transactional
//	@Modifying
//	@Query("Delete from Todo u where u.id= :id ")
//	@Override
//	void delete(@Param(value = "id") int id) {
//	}
//
//	
//	@Transactional
//	@Modifying
//	@Query("Update Todo u set u.description=:desc,u.status=:status,u.targetdate=:tdate,u.done=:done  where u.id=:id ")
//	@Override
//	abstract
//	void update(@Param(value = "desc") String description,@Param(value = "status") String status,@Param(value = "tdate") LocalDate targetdate,@Param(value = "done") String done,@Param(value = "id") long id);
//
//	
//	
//}
