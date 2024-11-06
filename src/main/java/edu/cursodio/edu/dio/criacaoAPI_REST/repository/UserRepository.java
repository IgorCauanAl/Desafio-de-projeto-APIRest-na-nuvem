package edu.cursodio.edu.dio.criacaoAPI_REST.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cursodio.edu.dio.criacaoAPI_REST.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	

}
