package com.serpro.Masterdata.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.serpro.Masterdata.entity.Todo;
import com.serpro.Masterdata.repository.TodoRepository;
import com.serpro.Masterdata.service.AuthenticationService;
import com.serpro.Masterdata.service.TodoService;

//import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

	
//	public TodoController(TodoRepository todorepo) {
//		super();
//		this.todorepo=todorepo;
//
//	}
	
//	@Autowired
	private TodoService todoser;

	
	@Autowired
	private TodoRepository todorepo;

 	@Autowired
	private AuthenticationService auth;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listtodos() {
		
		return "todologin";

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String listtodos1(@RequestParam String name, @RequestParam String password,Todo todo, ModelMap model) {
		List<Todo> todos = todorepo.findAll();

		if (auth.authenticate(name, password)) {
			model.put("username", getLoggedInUsername());
			model.addAttribute("todos", todos);
			return "listtodos";
		}
		model.put("errormsg", "Invalid Credentials! Please enter the credentials correctly...");
		return "todologin";
	}

	@RequestMapping(value = "listtodos")
	public String addtodo(ModelMap model) {
		List<Todo> todos = todorepo.findAll();
		System.out.println("todos in controller"+todos);
		model.put("username",getLoggedInUsername());
		model.addAttribute("todos", todos);
		return "listtodos";

	}

	@RequestMapping(value = "addtodo", method = RequestMethod.GET)
	public String addtodo1(ModelMap model) {
		String username = getLoggedInUsername();
		Todo todo = new Todo(0, username, "", LocalDate.now(), "Started", "false");
		model.put("todo", todo);

		return "addtodo";
	}

	@RequestMapping(value = "addtodo", method = RequestMethod.POST)
//	public String posttodo( ModelMap model,@Valid Todo todo, BindingResult result) {
	public String posttodo(ModelMap model, Todo todo, BindingResult result) {

		if (result.hasErrors()) {

			return "addtodo";
		} else {
			String username = getLoggedInUsername();
			todorepo.save(todo);
			//todoserv.inserttodo(username, todo.getDescription(), todo.getTargetdate(), "Not yet started", "false");

			return "redirect:listtodos";
		}
	}

	@RequestMapping(value = "deletetodo", method = RequestMethod.GET)
	public String deletetodo(@RequestParam int id) {

		todorepo.deleteById(id);
		return "redirect:listtodos";
	}

	@RequestMapping(value = "updatetodo", method = RequestMethod.GET)
	public String updatetodo(@RequestParam int id, ModelMap model) {
		String username = getLoggedInUsername();
		Optional<Todo> todo = todorepo.findById(id);
		model.addAttribute("todo", todo);
//		System.out.println("id" + model);

		return "updatetodo";
	}

	@RequestMapping(value = "updatetodo", method = RequestMethod.POST)
	public String updatetodo1(ModelMap model, Todo todo) {

//		System.out.println(todo.getId() + "" + todo.getDescription() + "" + todo.getStatus() + "" + todo.getDone());
		todorepo.update(getLoggedInUsername(), todo.getDescription(),todo.getStatus(),todo.getTargetdate(),
				todo.getDone(),todo.getId());
		
		return "redirect:listtodos";
	}

	@GetMapping("library")
	public String library() {
		return "library";
	}
	
	@GetMapping("mail")
	public void  mail() throws Exception {
		String wordTemplatePath = "C:\\Users\\rajalakshmi.raj\\Downloads\\VP Payout Letter-Template.docx";
		String modifiedWordPath = "C:\\Users\\rajalakshmi.raj\\Downloads\\modified.docx";
		String pdfPath = "C:\\Users\\rajalakshmi.raj\\Downloads\\output.pdf";

		// Step 1: Fetch data from the database
		Map<String, String> data = todoser.getDataFromDatabase();

		// Step 2: Modify the Word template
		todoser.modifyWordTemplate(wordTemplatePath, modifiedWordPath, data);

		// Step 3: Convert the Word document to PDF
		todoser.convertWordToPdf(modifiedWordPath, pdfPath);

		// Step 4: Send the email with the PDF attachment
		todoser.sendEmailWithAttachment("rajalakshmi.raj@incture.com", "Subject: PDF with data", "Please find the attached PDF.",
				pdfPath);
		String s="mail sent";
		System.out.println(s);
	}

	
	enum Color {
		RED("RED") , GREEN("Green");
		
		private String Value;
		
		Color(String Value){
			this.Value = Value;
		}

		public String getValue() {
			return Value;
		}
			}
	
	@GetMapping("enum")
	public String enumClass() {
		for(Color color: Color.values()) {
		System.out.println("Colors"+color.getValue());
		
		}
		return "Success";
	}
	
	public String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}
