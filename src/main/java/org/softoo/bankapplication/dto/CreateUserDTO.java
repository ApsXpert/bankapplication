package org.softoo.bankapplication.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateUserDTO {

	private long cnic;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
}
