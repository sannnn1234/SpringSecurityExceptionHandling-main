package com.springsecurityexceptionhandling.service;

import java.util.List;

import com.springsecurityexceptionhandling.entity.Employee;

public interface EmployeeServiceInterface {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmpById(Long empidL);

	public void deleteEmpById(Long empidL);

}
