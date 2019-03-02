package com.sprphnx.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sprphnx.crm.dao.CustomerDAO;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomer(Model model) {
		
		model.addAttribute("customers", customerDAO.getAllCustomer());
		
		return "customerList";
		
	}
	
}
