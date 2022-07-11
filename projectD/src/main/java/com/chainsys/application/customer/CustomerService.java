package com.chainsys.application.customer;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerService {
	@GetMapping("/findcustomer")
	public String getCustomer() {
		return "hello customer";
	}
	@PostMapping("/addcustomer")
	public int addnewcustomer() {
		return 0;
		
	}
	@PutMapping("/update")
	public int update() {
		return 0;
		
	}
	@DeleteMapping("/delete")
	public int delete() {
		return 0;
		
	}


}
