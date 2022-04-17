package com.example.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Employee> addEmployees(List<EmployeeDTO> empDtoList) throws CustomException {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<Employee>();

		List<Role> roleList = new ArrayList<Role>();

		for (EmployeeDTO empDto : empDtoList) {

			// Add role to user during save
			for (String roleName : empDto.getRoles()) {
				Role role = new Role(roleName);
				Role savedRole = null;
				if (!roleExist(roleName)) {
					savedRole = roleRepository.save(role);
				} else {
					Optional<Role> savedOpRole = roleRepository.findByName(roleName);
					savedRole = savedOpRole.get();

				}
				roleList.add(savedRole);
			}

			if (!employeeExist(empDto.getFirstName(), empDto.getLastName())) {
				Employee emp = new Employee();
				emp.setFirstName(empDto.getFirstName());
				emp.setLastName(empDto.getLastName());
				emp.setRoles(roleList);
				empList.add(employeeRepository.save(emp));
			}
		}
		return empList;
	}

	@Override
	public List<Employee> getEmployees() throws CustomException {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public List<Role> addRoles(List<RoleDTO> roles) throws CustomException {
		// TODO Auto-generated method stub

		List<Role> newRoles = new ArrayList<Role>();
		for (RoleDTO roleDto : roles) {
			if (!roleExist(roleDto.getName())) {
				Role role = new Role(roleDto.getName());
				newRoles.add(roleRepository.save(role));
			}

		}
		return newRoles;
	}

	@Override
	public List<Role> getRoles() throws CustomException {
		// TODO Auto-generated method stub
		return (List<Role>) roleRepository.findAll();
	}

	@Override
	public List<Employee> associateRoles(List<EmployeeDTO> empDtoList) throws CustomException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<Employee>();

		List<Role> roleList = new ArrayList<Role>();

		for (EmployeeDTO empDto : empDtoList) {

			// Add role to user during save
			for (String roleName : empDto.getRoles()) {
				Role role = new Role(roleName);
				Role savedRole = null;
				if (roleExist(roleName)) {
					Optional<Role> savedOpRole = roleRepository.findByName(roleName);
					savedRole = savedOpRole.get();
				} else {
					throw new CustomException(roleName + " role does not exist.");

				}
				roleList.add(savedRole);
			}

			if (employeeExist(empDto.getFirstName(), empDto.getLastName())) {
				Optional<Employee> opEmployee = employeeRepository.findByFirstNameAndLastName(empDto.getFirstName(),
						empDto.getLastName());

				Employee emp = opEmployee.get();
				if (!emp.getRoles().isEmpty())
					emp.getRoles().clear();
				emp.setRoles(roleList);
				empList.add(employeeRepository.save(emp));
			} else {
				throw new CustomException(empDto.getFirstName() + empDto.getLastName() + " employee does not exist.");
			}
		}
		return empList;
	}


	/**
	 * Method to check if employee exists by firstName, lastName
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	private boolean employeeExist(String firstName, String lastName) {
		Optional<Employee> opEmployee = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
		return opEmployee.isPresent();
	}

	private boolean roleExist(String name) {
		Optional<Role> opRole = roleRepository.findByName(name);
		return opRole.isPresent();
	}

}
