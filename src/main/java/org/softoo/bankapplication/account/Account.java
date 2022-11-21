package org.softoo.bankapplication.account;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.softoo.bankapplication.model.AccountType;
import org.softoo.bankapplication.user.User;

import lombok.Data;

@Data
@Table(name = "account")
@Entity
public class Account {

	@Id
	@Column(name = "account_number")
	private long accountNumber;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "account_type") private AccountType accountType;
	 */

	@ManyToOne
	@JoinColumn(name = "b_user")
	private User user;

	@Column(name = "balance")
	private double balance;

	@Column(name = "status")
	private boolean status;

	@Column(name = "created_at")
	private LocalDateTime createdAt;
}
