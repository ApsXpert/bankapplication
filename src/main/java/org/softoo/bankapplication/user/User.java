package org.softoo.bankapplication.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.softoo.bankapplication.account.Account;
import org.softoo.bankapplication.model.AccountType;

import lombok.Data;

@Data
@Table(name = "b_user")
@Entity
public class User {

	@Id
	@Column(name = "cnic")
	private long cnic;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	public User() {}
	
	public User(long cnic) {
		this.cnic = cnic;
	}
}
