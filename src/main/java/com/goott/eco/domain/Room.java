package com.goott.eco.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

	private String sender_id ;
	private int roomnumber;
	private String roomname;
	private String receiver_id ;
	
}
