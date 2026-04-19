package com.example.demo.controller;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomerInfo;
import com.example.demo.request.RequestLoginForm;
import com.example.demo.service.CustomerService;

import request.RequestCustomerForm;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*") // このコントローラーの全メソッドを全許可
//@CrossOrigin("http://localhost:3000") // https://todo-list-plus-front-hironobu0706-hironobu0706s-projects.vercel.app/
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	@GetMapping("/customer")
	public String sample() {
		System.out.println("aaaaaaaaaaaaaaaaaaaa3");
		return "connection OK";
	}

	@GetMapping("/customer2")
	public List<CustomerInfo> sample2() {
		return service.selectAll();
	}
	
	@PostMapping("/createCustomer")
    public int createCustomer(@RequestBody RequestCustomerForm request) {
        return service.createCustomer(request);
    }

	@PostMapping("/loginAuth")
	public CustomerInfo loginAuth(@RequestBody RequestLoginForm request) {
		CustomerInfo responseLogin = new CustomerInfo();
		responseLogin = service.loginAuth(request.getMailAddress(), request.getPassword());
		
		if(Objects.isNull(responseLogin)) {
			return null;
		}
		return responseLogin;
	}
}
