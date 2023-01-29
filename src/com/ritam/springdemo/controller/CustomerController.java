package com.ritam.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ritam.springdemo.entity.Customer;
import com.ritam.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get the list of customers
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add list of customers to model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAddCustomer")
	public String showFormForAddCustomer(Model theModel) {
		
		//create a new customer for data binding
		Customer theCustomer = new Customer();
		
		//add the customer to the model
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the customer
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdateCustomer")
	public String showCustomerFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		//get the customer with id
		Customer theCustomer = customerService.getCustomer(theId);
		
		//add customer to model for prepopulating the form
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//delete the customer with id theId
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
}