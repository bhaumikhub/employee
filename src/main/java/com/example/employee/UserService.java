package com.example.employee;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

	public List<Employee> addEmployees(List<EmployeeDTO> empDtoList) throws CustomException;

	public List<Employee> getEmployees() throws CustomException;

	public List<Role> addRoles(List<RoleDTO> roles) throws CustomException;

	public List<Role> getRoles() throws CustomException;

	public List<Employee> associateRoles(List<EmployeeDTO> empDtoList) throws CustomException;

}
