package com.apurvtripathi.ekea.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apurvtripathi.ekea.entity.Employee;
import com.apurvtripathi.ekea.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	//constructor injection used
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@GetMapping("/listEmployees")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees", employeeService.findAll());
		return "list-employees";

	}
	
	@GetMapping("/addForm")
	public String showAddForm(Model theModel) {
		Employee theEmployee= new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employeeAddform";
	}
	@PostMapping("/save")
	public String saveEmploye(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		return "redirect:/employee/listEmployees";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam ("employeeId")int theId, Model theModel) {
		Employee theEmployee=employeeService.findById(theId);
		theModel.addAttribute("employee", theEmployee);
		return "employeeAddForm";
		
	}
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam ("employeeId")int theId) {
		employeeService.deleteById(theId);
		return "redirect:/employee/listEmployees";
		
	}

	
	
	
	
	
	
	
	
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
