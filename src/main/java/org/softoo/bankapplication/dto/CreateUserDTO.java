package org.softoo.bankapplication.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CreateUserDTO {

	@NotNull
	@Size(min = 13, max = 13, message = "cnic must be 13 digits")
	private String cnic;
	
	@NotNull(message = "firstName cannot be null")
	@Size(min = 3, max = 20, message = "firstName must be 3 to 20 characters long")
	private String firstName;
	
	
	@Size(min = 3, max = 20)
	private String middleName;
	
	@NotNull(message = "lastName cannot be null")
	@Size(min = 3, max = 20, message = "lastName must be 3 to 20 characters long")
	private String lastName;
	
	@Email(message = "email is not valid")
	@NotNull(message = "email cannot be null")
	@Size(min = 6, max = 200)
	private String email;
	
	@NotNull
	@Size(min = 6, max = 200)
	private String password;
}
