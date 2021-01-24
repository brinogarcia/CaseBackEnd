package com.password.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.password.service.PasswordValidateService;
import com.password.service.impl.PasswordValidateServiceImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordValidateControllerTest {

	@Autowired
	public WebApplicationContext context;
	
	@InjectMocks
	private PasswordValidateController passwordValidateController;
	
	@InjectMocks
	private PasswordValidateServiceImpl passwordValidateServiceImpl;
	
	@Mock
	private PasswordValidateService passwordValidateService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(passwordValidateController).build();
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	@DisplayName("Request is Ok!")
	public void whenRequestIsOk() throws Exception {
		JSONObject jsonObject = new JSONObject(getPassword());
		this.mockMvc.perform(MockMvcRequestBuilders.post("/password/isValid")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject.toString()))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	@DisplayName("Request is BadRequest of not  implement body!")
	public void whenRequestIsBadRequest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/password/isValid"))
		.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	@DisplayName("Request is MethodNot Allowed!")
	public void whenRequestIsMethodNotAllowed() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/password/isValid"))
		.andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
	}

	@Test
	@DisplayName("Request is return Boolean!")
	public void whenRequestIsOkandTrue() throws Exception {
		JSONObject jsonObject = new JSONObject(getPassword());		
        this.mockMvc.perform(MockMvcRequestBuilders.post("/password/isValid")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject.toString()))
                .andExpect(jsonPath("$.isValid").isBoolean());
	}
	
	private String getPassword() {
		return "{\r\n" + 
				"    \"password\": \"AbTp9!fok\"\r\n" + 
				"}";
	}
}
