package com.springsecurityexceptionhandling.service;

import java.util.List;

import com.springsecurityexceptionhandling.customException.BusinessException;
import com.springsecurityexceptionhandling.customException.EmptyInputException;
import com.springsecurityexceptionhandling.entity.Employee;
import com.springsecurityexceptionhandling.repos.EmployeeCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements EmployeeServiceInterface{
	
	@Autowired
	private EmployeeCrudRepo crudRepo;

	@Override
	public Employee addEmployee(Employee employee) {

			if(employee.getName().isEmpty() || employee.getName().length()==0) {
				throw new EmptyInputException("601", "Please send proper name, It name blanks");
			}
			try{
			Employee savedEmployee = crudRepo.save(employee);
			return savedEmployee;
		}catch(IllegalArgumentException e){
           throw new BusinessException("602", "given employee is null" +e.getMessage());
		}catch(Exception ex){
			throw new BusinessException("603", "Something Exception Ocuur" +ex.getMessage());
		}

		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return crudRepo.findAll();
	}

	@Override
	public Employee getEmpById(Long empidL) {
		return crudRepo.findById(empidL).get();
	}

	@Override
	public void deleteEmpById(Long empidL) {
		crudRepo.deleteById(empidL);
	}

}
