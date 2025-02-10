package com.serpro.Masterdata.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//
//import com.serpro.Masterdata.entity.SerialEntity;
//import com.serpro.Masterdata.service.Serial;
//
//@Controller
public class SerialController {

	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedInUsername());
		return "welcome";
	}
	
	
	public String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	}
//
//	@Autowired
//	private Serial serv;
//	
//
//	@GetMapping(value = "/getalldata")
//	public List<SerialEntity> fetchalldata() {
//		return serv.getalldata();
//
//	}
//
//	@PostMapping("/postdata")
//	public String postdata(@RequestBody SerialEntity serent) {
//		return serv.postdata(serent);
//	}
//
//	@PostMapping("/updatedata")
//	public String updatedata(@RequestBody SerialEntity serent) {
//		return serv.uppostingdata(serent);
//	}
//	
//	@DeleteMapping("/deletedata")
//	public String deletedata(@RequestParam Long id) {
//		return serv.deletedata(id);
//		
//	}
//	
//
//}
