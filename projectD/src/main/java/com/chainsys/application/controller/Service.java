package com.chainsys.application.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Service {

	@RequestMapping("/getemployeeid")

	public String EmployeeID(@RequestParam(name = "id") String id) {
		int empId = Integer.parseInt(id);
		Employee emp = EmployeeDao.getEmployeeById(empId);
		return emp.getFirst_name() + "," + emp.getJob_id() + "," + emp.getEmail() + "," + emp.getLast_name() + ","
				+ emp.getPhone_number() + "," + emp.getSalary() + "," + emp.getHire_date();
	}

	@RequestMapping("/getallemployee")
	public String getAllEmployee() {
		String out = "";

		List<Employee> allEmployees = EmployeeDao.getAllEmployee();
		Iterator<Employee> empIterator = allEmployees.iterator();
		while (empIterator.hasNext()) {
			Employee emp = empIterator.next();
			out += emp.getFirst_name() + "," + emp.getJob_id() + "," + emp.getEmail() + "," + emp.getLast_name() + ","
					+ emp.getPhone_number() + "," + emp.getSalary() + "," + emp.getHire_date();

		}
		return out;
	}

	@RequestMapping(value = "/newemployee", method = RequestMethod.POST)
	public int addNewEmployee() {
		return 0;
	}

	@RequestMapping(value = "/updatemployee", method = RequestMethod.PUT)
	public int modifyNewEmployee() {
		return 1;
	}

	@RequestMapping(value = "/removeemployee", method = RequestMethod.DELETE)
	public int deleteEmployee() {
		return 2;
	}
}