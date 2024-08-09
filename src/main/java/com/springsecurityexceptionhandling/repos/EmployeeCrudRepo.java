package com.springsecurityexceptionhandling.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurityexceptionhandling.entity.Employee;

public interface EmployeeCrudRepo extends JpaRepository<Employee, Long> {


    Employee findByUsername(String name);
}
