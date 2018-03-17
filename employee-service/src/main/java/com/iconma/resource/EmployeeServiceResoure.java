package com.iconma.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.iconma.constants.EmployeeServiceRestEndPoints;
import com.iconma.model.Employee;

@RestController
@RequestMapping(value = EmployeeServiceRestEndPoints.ROOT_EMPLOYEE_ENDPOINT)
public class EmployeeServiceResoure {
	private static final String SAVE_EMPLOYEE_DBSERVICE_ENDPOINT = "http://db-service/employee/saveEmployee";
	private static final String UPDATE_EMPLOYEE_DBSERVICE_ENDPOINT = "http://db-service/employee/updateEmployee";
	private static final String DELETE_EMPLOYEE_DBSERVICE_ENDPOINT = "http://db-service/employee/deleteEmployeeById";
	private static final String DETETEALL_EMPLOYEE_DBSERVICE_ENDPOINT = "http://db-service/employee/deleteAllEmployeese";
	private static final String FIND_EMPLOYEE_DBSERVICE_ENDPOINT = "http://db-service/employee/findEmployeeById";
	private static final String FINDALL_EMPLOYEES_DBSERVICE_ENDPOINT = "http://db-service/employee/findAllEmployees";
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping(value = { EmployeeServiceRestEndPoints.SAVE_EMPLOYEE_ENDPOINT })
	public Employee saveEmployee(@RequestBody Employee employee) {
		Employee employee2 = restTemplate.postForObject(SAVE_EMPLOYEE_DBSERVICE_ENDPOINT, employee, Employee.class);
		return employee2;
	}

	@PutMapping(value = { EmployeeServiceRestEndPoints.UPDATE_EMPLOYEE_ENDPOINT })
	public Employee updateEmployee(@RequestBody Employee employee) {
		return restTemplate.postForObject(UPDATE_EMPLOYEE_DBSERVICE_ENDPOINT, employee, Employee.class);
	}

	@PutMapping(value = { EmployeeServiceRestEndPoints.DELETE_EMPLOYEE_ENDPOINT })
	public void deleteEmployee(@PathVariable("employeeId") final int employeeId) {
		restTemplate.delete(DELETE_EMPLOYEE_DBSERVICE_ENDPOINT, employeeId);
	}

	@PutMapping(value = { EmployeeServiceRestEndPoints.DELETEALL_EMPLOYEES_ENDPOINT })
	public void deleteAllEmployees() {
		restTemplate.delete(DETETEALL_EMPLOYEE_DBSERVICE_ENDPOINT);
	}

	@GetMapping(value = { EmployeeServiceRestEndPoints.FINDBYID_EMPLOYEE_ENDPOINT })
	public Employee findEmployee(@PathVariable("employeeId") final int employeeId) {
		return restTemplate.getForObject(FIND_EMPLOYEE_DBSERVICE_ENDPOINT + "/" + employeeId, Employee.class);
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = { EmployeeServiceRestEndPoints.FINDALL_EMPLOYEES_ENDPOINT })
	public List<Employee> findAllEmployee() {
		return (List<Employee>) restTemplate.getForObject(FINDALL_EMPLOYEES_DBSERVICE_ENDPOINT, Employee.class);
	}
}
