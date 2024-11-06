package edu.cursodio.edu.dio.criacaoAPI_REST.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cursodio.edu.dio.criacaoAPI_REST.model.User;
import edu.cursodio.edu.dio.criacaoAPI_REST.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/users")
public class UserRestController {

	private final UserService userService;

	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	// EndPoint na qual procurar o ID do usuário
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		var user = userService.findById(id);
		return ResponseEntity.ok(user);
	}

	//EndPoint que criar um usuário 
	@PostMapping("/{id}")
	public ResponseEntity<User> create(@RequestBody User userToCreate) {
		var userCreated = userService.create(userToCreate);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}")
			   .buildAndExpand(userCreated.getId())
			   .toUri();
		return ResponseEntity.created(location).body(userCreated);
	}

}
