package org.softoo.bankapplication.user;

import javax.validation.Valid;

import org.softoo.bankapplication.dto.CreateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public User create(@Valid @RequestBody CreateUserDTO dto) {
		System.out.println(dto.toString());
		return userService.create(dto);
	}
}
