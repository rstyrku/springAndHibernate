package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	// need a controller method to show initial form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// new controller method to read form data
	// add data to the model
	
	@RequestMapping("/processFormTwo")
	public String letsShoutDude(HttpServletRequest req, Model model) {
		
		// read the request parameter from the HTML form
		String theName = req.getParameter("studentName");
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Yo! " + theName;
		
		//add the message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Hey My Friend from v3! " + theName;
		
		//add the message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}

}
