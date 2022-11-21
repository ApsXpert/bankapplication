package org.softoo.bankapplication.user;

import org.softoo.bankapplication.dto.CreateUserDTO;

public interface UserService {

	User create(CreateUserDTO dto);
	
	User findByIdForReference(long cnic);
}
