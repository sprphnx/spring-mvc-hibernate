package com.sprphnx.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sprhpnx.crm.entity.Customer;
import com.sprphnx.crm.model.CustomerDTO;
import com.sprphnx.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model model) {
		
		model.addAttribute("customers", customerService.getAllCustomer());
		
		return "customerList";
		
	}

	@GetMapping("/showAddCustomerForm")
	public String showAddCustomerForm(Model model) {

		model.addAttribute("customer", new CustomerDTO());
		
		return "addCustomerForm";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customer") CustomerDTO customerDTO) {
		
		System.out.println(customerDTO.getFirstName());
		System.out.println(customerDTO.getLastName());
		System.out.println(customerDTO.getEmail());
		
		customerService.addCustomer(customerDTO);
		
		return "redirect:list";
	}

	@GetMapping("/showUpdateCustomerForm")
	public String showUpdateCustomerForm(@RequestParam("customerId") long customerId, Model model) {
		
		model.addAttribute("customer", customerService.getCustomerById(customerId));
		
		return "updateCustomerForm";
	}
	
	@RequestMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("customer") Customer customer) {
		
		customerService.updateCustomer(customer);
		
		return "redirect:list";
		
	}
	
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") long customerId) {
		
		customerService.deleteCustomer(customerId);
		
		return "redirect:list";
		
	}
}
