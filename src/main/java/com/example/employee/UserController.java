package com.example.employee;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RequestMapping(value = "/uc")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class.getName());

	@Autowired
	UserService userService;

	@RequestMapping(value = "/add/employees", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> addEmployee(@RequestBody List<EmployeeDTO> employeeDtoList) {
		LOGGER.info("Entry addEmployee()");
		List<Employee> empList = userService.addEmployees(employeeDtoList);
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);

	}

	@RequestMapping(value = "/all/employees", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Employee>> fetchAllEmployees() {
		LOGGER.info("Entry fetchAllEmployees()");
		List<Employee> empList = userService.getEmployees();
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);

	}

	@RequestMapping(value = "/add/roles", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> addRoles(@RequestBody List<RoleDTO> roleDtoList) {
		LOGGER.info("Entry addRoles()");
		List<Role> roleList = userService.addRoles(roleDtoList);
		return new ResponseEntity<List<Role>>(roleList, HttpStatus.OK);

	}

	@RequestMapping(value = "/all/roles", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Role>> fetchAllRoless() {
		LOGGER.info("Entry fetchAllRoless()");
		List<Role> roleList = userService.getRoles();
		return new ResponseEntity<List<Role>>(roleList, HttpStatus.OK);

	}

	@RequestMapping(value = "/modify/employee/roles", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> modifyEmployeeRoles(@RequestBody List<EmployeeDTO> employeeDtoList) {
		LOGGER.info("Entry modifyEmployeeRoles()");
		List<Employee> empList = userService.associateRoles(employeeDtoList);
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);

	}

}
