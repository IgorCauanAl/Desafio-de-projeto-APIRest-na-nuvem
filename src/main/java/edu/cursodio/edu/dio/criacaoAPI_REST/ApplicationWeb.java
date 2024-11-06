package edu.cursodio.edu.dio.criacaoAPI_REST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = {@Server(url = "/" , description = "Url padrão do servidor")})
@SpringBootApplication
public class ApplicationWeb {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationWeb.class, args);
	}

}
