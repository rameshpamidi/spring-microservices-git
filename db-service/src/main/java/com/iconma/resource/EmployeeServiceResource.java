package com.iconma.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iconma.constants.EmployeeServiceRestEndPoints;
import com.iconma.entity.Employee;
import com.iconma.repository.EmployeeRepository;

@RestController
@RequestMapping(value={EmployeeServiceRestEndPoints.ROOT_EMPLOYEE_ENDPOINT})
public class EmployeeServiceResource {
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping(value = {EmployeeServiceRestEndPoints.SAVE_EMPLOYEE_ENDPOINT})
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping(value = {EmployeeServiceRestEndPoints.UPDATE_EMPLOYEE_ENDPOINT})
	public Employee updateEmployee(@RequestBody Employee employee) {
		Optional<Employee> optional = employeeRepository.findById(employee.getEmpId());
		Employee employee1 = optional.get();
		employee1.setEmpName(employee.getEmpName());
	    employee1.setEmpSalary(employee.getEmpSalary());
		return employeeRepository.save(employee1);
	}

	@PutMapping(value = {EmployeeServiceRestEndPoints.DELETE_EMPLOYEE_ENDPOINT })
	public void deleteEmployee(@PathVariable("employeeId") final int employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	@PutMapping(value = { EmployeeServiceRestEndPoints.DELETEALL_EMPLOYEES_ENDPOINT })
	public void deleteAllEmployees() {
		employeeRepository.deleteAll();
	}

	@GetMapping(value = { EmployeeServiceRestEndPoints.FINDBYID_EMPLOYEE_ENDPOINT })
	public Employee findEmployee(@PathVariable("employeeId") final int employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	@GetMapping(value = { EmployeeServiceRestEndPoints.FINDALL_EMPLOYEES_ENDPOINT })
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}
}
