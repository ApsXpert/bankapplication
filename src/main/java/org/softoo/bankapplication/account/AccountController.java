package org.softoo.bankapplication.account;

import org.softoo.bankapplication.dto.CreateAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public ResponseEntity<Account> create(@RequestBody CreateAccountDTO dto){
		Account account = accountService.create(dto);
		return new ResponseEntity<Account>(account, HttpStatus.CREATED);
	}
	
}
