/**
 * 
 */
package com.example.employee;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author 91943
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
@WithMockUser
public class UserControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;
//	List<Role> roles = new ArrayList<Role>();
//	Employee employee = null;

	Role sampleRole = new Role("Admin");
	RoleDTO role = new RoleDTO("Admin");
	List<Role> mockRole = new ArrayList<Role>();

	List<RoleDTO> mockRoles = new ArrayList<RoleDTO>();
	@Test
	public void retrieveAllRoles() throws Exception {

		System.out.println("Inside Test");
		mockRoles.add(role);
		Mockito.when(
				((OngoingStubbing) userService.addRoles(mockRoles)).thenReturn(new ArrayList<Role>()));


		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/add/roles").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:1,name:Admin}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K
		// Students","steps":["Learn Maven","Import Project","First Example","Second
		// Example"]}

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
