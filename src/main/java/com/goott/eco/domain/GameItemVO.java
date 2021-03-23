package com.goott.eco.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameItemVO {

	private Long item_seq;
	private String item_name;
	private Long item_price;
	private String item_memo;
	
}
