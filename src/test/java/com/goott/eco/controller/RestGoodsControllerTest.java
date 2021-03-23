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

import com.goott.eco.config.RootConfig;
import com.goott.eco.config.ServletConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@Log4j
public class RestGoodsControllerTest {
	
	@Autowired private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testTest() throws Exception {
		mockMvc.perform(get("/goods/rest/test")
				.contentType("application/json; charset=UTF-8"))
				.andExpect(status().is(200));
	}
	
	@Test
	public void goodsListTest() throws Exception {
		
		
		mockMvc.perform(get("/goods/rest")
				.contentType("application/json; charset=UTF-8"))
		.andExpect(status().is(200));
	}
	
}
