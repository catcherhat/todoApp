package com.serpro.Masterdata.service;


import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serpro.Masterdata.entity.Course;
import com.serpro.Masterdata.entity.SerialEntity;
//import com.serpro.Masterdata.repository.CourseJdbcRepository;
import com.serpro.Masterdata.repository.SerialRepository;

import ch.qos.logback.classic.Logger;


@Service
//@Slf4j
public class Serial {

	public static final org.slf4j.Logger logger = LoggerFactory.getLogger(SerialRepository.class);

	//@Autowired
	private SerialRepository serrepo;
	
//	@Autowired
//	private CourseJdbcRepository courserepo;

	public List<SerialEntity> getalldata() {

		return serrepo.find();
	}

	public String postdata(SerialEntity serent) {

		try {
			serrepo.insert(serent.getProductId(), serent.getProductName(), serent.getDepartment(),
					serent.getCustomerName(), serent.getCustomerId(), serent.getRequestNo(), serent.getStatus(),
					serent.getCreatedDate());
//			System.out.println("Insert query");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Data Inserted successfully";
	}

	public String uppostingdata(SerialEntity serent) {

		String s;
		try {
			serrepo.update(serent.getProductId(), serent.getProductName(), serent.getDepartment(),
					serent.getCustomerName(), serent.getCustomerId(), serent.getRequestNo(), serent.getStatus(),
					serent.getCreatedDate());
//			logger.error("Data updated successfully");
			s = "Data updated successfully";
		} catch (Exception e) {
			e.printStackTrace();
			s = "Data was not updated due to " + e;
		}
		return s;
	}

	public String deletedata(Long id) {

		serrepo.deleteById(id);
		return "Deleted successfully";
	}

//	public String htmlviewer() {
//		StringBuffer sb = new StringBuffer();
//		Course course = new Course();
//	      course = courserepo.findbyid(1);
//		sb.append("<html>");
//		sb.append("<head>");
//		sb.append("<title>Master Data Page</title>");
//		sb.append("<style>h1{ text-align:center;"
//				+ "  background-color:skyblue;}"
//				+ "h2{ text-align:center;\r\n"
//				+ "  background-color:lightgrey;}"
//				+ ".center{   border:1px solid black ; text-align:center;"
//				+ "margin-left: auto;"
//				+ "  margin-right: auto;}"
//				+ "caption{margin-left: auto;margin-right: auto;}</style>");
//		sb.append("</head>");
//		sb.append("<body>");
//		sb.append("<h1 >Hello    "+course.getName()+"</h1>");
//		sb.append("<h2>Welcome to Master Data Project</h2>");
//		sb.append("<table class=\"center\"><caption><b>Course Details</b></caption>");
//		sb.append("<br><tr><th><b>Your ID:</th><td> </b>"+course.getId()+"</td></tr>");
//		sb.append("<tr><th><b>Course Author: </b></th><td>"+course.getAuthor()+"</td></tr>");
//		sb.append("</table></body>");
//		sb.append("</html>");
//	
//		return sb.toString();
//	}

}
