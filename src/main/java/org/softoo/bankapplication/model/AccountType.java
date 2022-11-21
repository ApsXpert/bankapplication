package org.softoo.bankapplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "account_type")
@Entity
public class AccountType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	
}
