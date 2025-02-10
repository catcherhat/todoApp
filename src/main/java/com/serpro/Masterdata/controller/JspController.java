package com.serpro.Masterdata.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import com.serpro.Masterdata.service.AuthenticationService;

@Controller
@RequestMapping("jsp")
public class JspController {

	private Logger logger = LoggerFactory.getLogger(getClass());

//	@Autowired
//	private AuthenticationService auth;

	@RequestMapping("/sayhello")
	public String krismel() {
		return "sayhello";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		// model.put("name", name);
		// logger.debug("Request Parameter sent is "+name);
		return "loginpage";

	}
//
//	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String submitlogin(@RequestParam String name, @RequestParam String password, @RequestParam String email,
//			@RequestParam String phone, ModelMap model) {
//
//		if (auth.authenticate(name, password)) {
//			model.put("name", name);
//			model.put("password", password);
//			model.put("email", email);
//			model.put("phone", phone);
//
//			return "sayhello";
//		}
//
//		model.put("errormsg", "Invalid Credentials! Please enter your credentials correctly");
//		return "loginpage";
//
//	}
}
