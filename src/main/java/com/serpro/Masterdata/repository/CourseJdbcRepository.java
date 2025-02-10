//package com.serpro.Masterdata.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.serpro.Masterdata.entity.Course;
//
////@Repository
//public class CourseJdbcRepository {
//	
//	@Autowired
//	private JdbcTemplate springjdbctemplate;
//
//	private static String INSERT_QUERY=
//			"Insert into Course(ID,NAME,AUTHOR) values (?,?,?)";
//	
//	private static String UPDATE_QUERY=
//		"Update Course set name =? ,author=? where id=?";
//	
//	private static String DELETE_QUERY=
//			"Delete from Course where id = ?";
//	private static String SELECT_QUERY=
//			" Select * from Course   where id=? ";
//	private static String SELECTALL_QUERY=
//			" Select * from Course";
//	public void insert(Course course) {
//		springjdbctemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
//	}
//	
//	public void update(Course course) {
//		springjdbctemplate.update(UPDATE_QUERY,course.getName(),course.getAuthor(),course.getId());
//	}
//	public void delete(Long id) {
//		springjdbctemplate.update(DELETE_QUERY,id);
//	}
//	public Course findbyid(long id) {
//		return springjdbctemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
//		
//	}
//
//	public Course getall() {
//		System.out.println(springjdbctemplate.queryForObject(SELECTALL_QUERY, new BeanPropertyRowMapper<>(Course.class)));
//		return springjdbctemplate.queryForObject(SELECTALL_QUERY, new BeanPropertyRowMapper<>(Course.class));
//	}
//}
