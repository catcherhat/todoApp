//package com.serpro.Masterdata.controller;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.serpro.Masterdata.CurrencyServiceConfiguration;
//
//@RestController
//@RequestMapping(value="/currencyconfiguration")
//public class CurrencyConfigurationController {
//
//	@Autowired
//	private CurrencyServiceConfiguration configuration;
//	
//	
//	@GetMapping("/getcurrencyconfig")
//	public CurrencyServiceConfiguration currencyconfig() {
//		return configuration;
//	}
//	
//	@GetMapping("/getcurrencyvalues")
//	public List<String> currencyvalues() {
//		return Arrays.asList(configuration.getUrl(),configuration.getUsername(),configuration.getKey());
//	}
//}
