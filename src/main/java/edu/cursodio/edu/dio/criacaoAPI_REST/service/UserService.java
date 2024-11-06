package edu.cursodio.edu.dio.criacaoAPI_REST.service;

import edu.cursodio.edu.dio.criacaoAPI_REST.model.User;

public interface UserService {
	User findById(Long id);
	
	User create(User userToCreate);
	
	
}
