package com.example.demo;

import com.example.demo.contacto.Contacto;
import com.example.demo.contacto.ContactoRepository;
import com.example.demo.contacto.Genero;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactoRepository contactoRepository, MongoTemplate mongoTemplate){
		return args -> {
			int contador = 0;
			for (int i = 0; i < 10; i++) {
				contador++;
				String email = "contacto" + (contador)+ "@gmail.com";
				String nombre = "Contacto"+ (contador);
				Random aleatorio = new Random();
				Contacto contacto = new Contacto(
						nombre,
						LocalDate.of(aleatorio.nextInt(10)+1970,aleatorio.nextInt(12)+1,aleatorio.nextInt(30)+1),
						email,
						Genero.Hombre);

//				usandoMongoTemplateAndQuery(contactoRepository, mongoTemplate, email, contacto);
				contactoRepository.findContactoByEmail(email)
						.ifPresentOrElse(c -> System.out.println(c + " ya existe "),()->{
							System.out.println("Contacto insertado correctamente ->"+ contacto);
							contactoRepository.insert(contacto);
						});
			}
		};
	}

	private void usandoMongoTemplateAndQuery(ContactoRepository contactoRepository, MongoTemplate mongoTemplate, String email, Contacto contacto) {
		Query query=new Query();
		query.addCriteria(Criteria.where("email").is(email));

		List<Contacto> contactos = mongoTemplate.find(query, Contacto.class);
		if (contactos.size()>1){
			throw new IllegalStateException("Ya existe un contacto con dicho email " + email);
		}
		if (contactos.isEmpty()) {
			System.out.println("Contacto insertado correctamente ->"+ contacto);
			contactoRepository.insert(contacto);
		} else {
			System.out.println(contacto + " ya existe ");
		}
	}
}
