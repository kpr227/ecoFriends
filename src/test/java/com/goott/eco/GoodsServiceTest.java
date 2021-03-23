package com.goott.eco;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.goott.eco.common.Criteria;
import com.goott.eco.common.PageDTO;
import com.goott.eco.config.RootConfig;
import com.goott.eco.config.ServletConfig;
import com.goott.eco.config.WebConfig;
import com.goott.eco.mapper.GoodsMapper;
import com.goott.eco.service.GoodsService;


import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@Log4j
public class GoodsServiceTest {

	@Autowired private GoodsService service;
	@Autowired private GoodsMapper dao;
	


	
	@Test
	public void goodsListTest() {
		Criteria cri = new Criteria();
		Map<String, Object> goodsData = service.goodsList(cri);
		List<Map<String,Object>> goodsList = (List)goodsData.get("goodsList");
		PageDTO page = (PageDTO)goodsData.get("page");
		
		int total = dao.totalCountGoodsList(cri);
		int amt = cri.getAmount();
		int mok = (total / amt) + 1;
		int namoji = total % amt;
		
		Criteria cri2 = new Criteria(mok, amt);
		goodsData = service.goodsList(cri2);
		goodsList = (List)goodsData.get("goodsList");
		assertThat(goodsList.size(), is(namoji));
	}

}
