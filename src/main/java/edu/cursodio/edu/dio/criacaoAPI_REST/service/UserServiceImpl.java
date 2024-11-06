package edu.cursodio.edu.dio.criacaoAPI_REST.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import edu.cursodio.edu.dio.criacaoAPI_REST.model.User;
import edu.cursodio.edu.dio.criacaoAPI_REST.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findById(Long id) {

		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
			throw new IllegalArgumentException("O ID já existe");
		}
		return userRepository.save(userToCreate);
	}

}
