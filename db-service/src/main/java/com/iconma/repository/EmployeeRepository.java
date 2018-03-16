package com.iconma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iconma.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
