package org.softoo.bankapplication.account;

import org.softoo.bankapplication.dto.CreateAccountDTO;

public interface AccountService {

	Account create(CreateAccountDTO dto);
}
