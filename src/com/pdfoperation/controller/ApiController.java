package com.pdfoperation.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdfoperation.model.User;

@RestController
public class ApiController {
	
	@PostMapping(value="/apiget")
	public User api1(User u1) {
		System.out.print("Aa gya yha");
		User u = new User();
		u.setEmailID(u1.getEmailID());
		u.setName(u1.getName());
		return u;
	}
	
	@PostMapping(value="/apiget1")
	public User api11(User u1) {
		System.out.print("Aa gya yha 1");
		User u = new User();
		u.setEmailID(u1.getEmailID());
		u.setName(u1.getName());
		return u;
	}
	
	
}

