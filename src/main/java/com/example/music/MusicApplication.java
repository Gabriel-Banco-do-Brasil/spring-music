package com.example.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}

}

// http://localhost:8080/console/ to open H2 console

// Crie um novo projeto Spring Boot que faça a gestão de um catálogo de músicas
// por gênero, que permite registrar pessoas, com suporte a gestão de playlists
// e likes relacionando músicas e pessoas.

// Utilizando base de dados, validação e documentação da API.


// TODO:

// [X] CRUD Musica
// [X] Database com DB2
// [X] Class Generos (instanciada por config e Atributo de Musica)
// [X] CRUD Pessoa
// [X] Class playlist (Atributo de Pessoa)
// [ ] Make DTO for model
// 		[ ] Make DTO for point operations: tick like_count, tick dislike_count, add playlist to customer, remove playlist from customer, etc etc
// [ ] OpenAPI documentation
// [ ] Validation
