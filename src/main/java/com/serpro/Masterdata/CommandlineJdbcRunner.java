//package com.serpro.Masterdata;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.serpro.Masterdata.entity.Course;
//import com.serpro.Masterdata.repository.CourseJdbcRepository;
//
//@Component
//public class CommandlineJdbcRunner implements CommandLineRunner {
//
//	@Autowired
//	private CourseJdbcRepository repo;
//	
//	
//	
//	public void run(String... args) throws Exception {
//		
//		
////	repo.insert(new Course(1,"Renuka","Himanshu"));
////	repo.insert(new Course(2,"Ibiza","Robert Pattinson"));
////	repo.insert(new Course(3,"Renesmee","Edward Cullen"));
//
//		repo.update(new Course(1,"Reguka","parthik"));
//		repo.update(new Course(3,"Anuradha","grameen"));
//		//repo.delete(2l);
//		
//		System.out.println(repo.findbyid(1l));
//		System.out.println(repo.findbyid(2l));
//		System.out.println(repo.findbyid(3l));
//
//	}
//
//}
