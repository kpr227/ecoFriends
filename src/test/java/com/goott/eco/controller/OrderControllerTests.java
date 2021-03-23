package com.goott.eco.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
//	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@ContextConfiguration(classes={
		com.goott.eco.config.RootConfig.class,
		com.goott.eco.config.ServletConfig.class,
		com.goott.eco.config.WebConfig.class})
@Log4j
public class OrderControllerTests {
	
	@Setter(onMethod_= {@Autowired})//가상의 톰켓 컨테스트 환경구성
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;//가짜 MVC
	
	@Before
	public void setup() {		
		this.mockMvc=MockMvcBuilders.webAppContextSetup(ctx).build();		
	}
	
	@Test
	public void testReadListBasket() throws Exception{
		
		String cust_id = "basic";
		
		mockMvc.perform( get("/oders/list/"+cust_id)
				.contentType("application/json; charset=UTF-8"))
				//.dataType("application.json; charset=UTF-8")
		.andExpect(status().is(200));
		
	}

}
