package com.serpro.Masterdata.controller;

import org.springframework.web.bind.annotation.GetMapping;


public class EnumClass 
{

	@MyCustomAnnotation(value=10)
	public  void run() {
		System.out.println("RUnning...");
	}
	enum Color {
		RED("RED is red") , GREEN("Green is green");
		
		private String Value;
		
		Color(String Value){
			this.Value = Value;
		}

		public String getValue() {
			return Value;
		}
			}
	
	@GetMapping("enum")
	public static String enumClass() {
		for(Color color: Color.values()) {
		System.out.println("Colors"+color.getValue());
		
		}
		return "Success";
	}

	
	public static void main(String[] args) {
		
		EnumClass enumClass = new EnumClass();
		
		enumClass();
		System.out.println(enumClass());
		System.out.println(Color.RED.getValue());
		System.out.println(Color.GREEN);
	}
	}

