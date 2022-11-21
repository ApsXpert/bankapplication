package org.softoo.bankapplication.dto;

import lombok.Data;

@Data
public class CreateAccountDTO {

	private double balance;
	private long cnic;
	private int accountType;
	
}
