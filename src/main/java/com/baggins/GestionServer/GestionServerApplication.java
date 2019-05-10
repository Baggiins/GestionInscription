package com.baggins.GestionServer;

import com.baggins.GestionServer.dao.TypeDiplomeRepository;
import com.baggins.GestionServer.modele.TypeDiplomeEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale
 * @author baggins
 */
@SpringBootApplication
public class GestionServerApplication {

	private static TypeDiplomeRepository typeRepo;
	public static void main(String[] args) {
		//TypeDiplomeEntity typeDiplomeEntity = new TypeDiplomeEntity(1, "Science");
		//typeRepo.save(typeDiplomeEntity);
		SpringApplication.run(GestionServerApplication.class, args);
	}

}
