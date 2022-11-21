package org.softoo.bankapplication.account;

import org.softoo.bankapplication.dto.CreateAccountDTO;
import org.softoo.bankapplication.user.User;
import org.softoo.bankapplication.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account create(CreateAccountDTO dto) {
		User user = userService.findByIdForReference(dto.getCnic());
		
		Account account = new Account();
		account.setBalance(dto.getBalance());
		account.setUser(user);
		
		return accountRepository.save(account);
	}

}
