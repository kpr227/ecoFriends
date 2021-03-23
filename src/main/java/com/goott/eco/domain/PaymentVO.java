package com.goott.eco.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentVO {

	private String imp_uid;
	private Long paid_amount;
	private String status;
	private boolean success;
	private CustomDataVO custom_data;
	
}
