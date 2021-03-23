package com.goott.eco;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.goott.eco.config.RootConfig;
import com.goott.eco.config.ServletConfig;
import com.goott.eco.service.AdminService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@Log4j
public class AdminServiceTest {
	
	@Autowired private AdminService adminService;
	
	@Test
	public void getSampleDataTest() throws Exception {
//		adminService.getSampleData();
	}
}
