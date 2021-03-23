package com.goott.eco.mapper;

import java.util.HashMap;
import java.util.List;

public interface ChartMapper {
	
	public List<HashMap<String,Object>> getMonthSale(int searchRange);

}
