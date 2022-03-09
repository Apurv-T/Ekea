package com.apurvtripathi.ekea.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apurvtripathi.ekea.entity.Employee;
import com.apurvtripathi.ekea.service.EmployeeService;

@Controller
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	//constructor injection used
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@GetMapping("/employees")
	public String findAll(Model theModel) {
		theModel.addAttribute("employees", employeeService.findAll());
		return "employeesList";

	}
	//@GetMapping("/employees")
//	public List<Employee> findAll() {
//		System.out.println(employeeService.findAll());
//		return employeeService.findAll();
//	}
	@GetMapping("/employee/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee theEmployee= employeeService.findById(employeeId);
		if(theEmployee==null) {
			throw new RuntimeException("Employee with id "+employeeId+" not found!");
		}
		return theEmployee;
	}
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}
	@DeleteMapping("/employee/{employeeId}")
	public String deleteById(@PathVariable int employeeId) {
		Employee theEmployee= employeeService.findById(employeeId);
		if(theEmployee==null) {
			throw new RuntimeException("Employee with id "+employeeId+" not found!");
		}
		employeeService.deleteById(employeeId);
		return "Employee has been deleted with id "+employeeId;
	}
	
}
