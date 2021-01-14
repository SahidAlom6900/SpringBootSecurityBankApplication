package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springsecurity.dto.CustomerRegistrationDto;
import com.springsecurity.service.CustomerService;

@Controller
@RequestMapping("/")
public class MainController {

	private CustomerService customerServise;

	@Autowired
	public MainController(CustomerService customerServise) {
		this.customerServise = customerServise;
	}

	@GetMapping("registration")
	public String showForm() {
		return "registration";
	}

	@ModelAttribute("customer")
	public CustomerRegistrationDto getDto() {
		return new CustomerRegistrationDto();
	}

	@PostMapping("registration")
	public String saveCustomer(@ModelAttribute("customer") CustomerRegistrationDto customerRegistrationDto) {
		customerServise.saveCustomer(customerRegistrationDto);
		return "redirect:login?success";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
}
