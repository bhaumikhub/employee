package com.example.employee;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private RoleRepository roleRepository;
	@Mock
	private EmployeeRepository employeeRepository;

	@Autowired
	@InjectMocks
	private UserServiceImpl userService;
	private RoleDTO role1;
	private RoleDTO role2;
	List<RoleDTO> roleDtoList;

	@BeforeEach
	public void setUp() {
		roleDtoList = new ArrayList<>();
		role1 = new RoleDTO("Admin");
		role2 = new RoleDTO("Default");
		roleDtoList.add(role1);
		roleDtoList.add(role1);
	}

	@AfterEach
	public void tearDown() {
		role1 = role2 = null;
		roleDtoList = null;
	}

	@Test
	void givenRoleDtoToAddShouldReturnAddedRole() throws Exception{
	     //stubbing
	     when(roleRepository.save(any())).thenReturn(role1);
	    userService.addRoles(roleDtoList);
	     verify(roleRepository,times(1)).save(any());
	}
	


}
