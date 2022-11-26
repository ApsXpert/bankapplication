package org.softoo.bankapplication.user;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.softoo.bankapplication.dto.CreateUserDTO;
import org.softoo.bankapplication.exceptions.CNICAlreadyExistedException;
import org.softoo.bankapplication.exceptions.EmailAlreadyExistedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public User create(CreateUserDTO dto) {
		
		long cnic = Long.valueOf(dto.getCnic());
		Optional<User> u = userRepository.findByIdForReference(cnic);

		if (u.isPresent()) {
			throw new CNICAlreadyExistedException("User id already exist: " + dto.getCnic());
		}

		u = userRepository.findByEmail(dto.getEmail());

		if (u.isPresent()) {
			throw new EmailAlreadyExistedException("User email already exist: " + dto.getEmail());
		}

		User user = modelMapper.map(dto, User.class);
		return userRepository.save(user);
	}

	@Override
	public User findByIdForReference(long cnic) {
		
		return userRepository.findByIdForReference(cnic)
				.orElseThrow( () -> new RuntimeException("User not found for id: " + cnic));
	}

}
