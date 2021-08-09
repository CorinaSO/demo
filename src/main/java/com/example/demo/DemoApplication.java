package com.example.demo;

import com.example.demo.contacto.Contacto;
import com.example.demo.contacto.Genero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@RestController
public class DemoApplication {

	final private static List<Contacto> contactos=new ArrayList<>();

	public static void main(String[] args) {
		crearArrayContactos();
		SpringApplication.run(DemoApplication.class, args);
	}

	public static void crearArrayContactos(){
		int contador = 0;
		for (int i = 0; i < 10; i++) {
			contador++;
			Long ident= Long.parseLong(String.valueOf(contador));
			String email = "contacto" + (contador)+ "@gmail.com";
			String nombre = "Contacto"+ (contador);
			Random aleatorio = new Random();
			Contacto contacto = new Contacto(
					ident,
					nombre,
					LocalDate.of(aleatorio.nextInt(10)+1970,aleatorio.nextInt(12)+1,aleatorio.nextInt(30)+1),
					email,
					Genero.Hombre);
			contactos.add(contacto);
		}
	}
	@GetMapping
	public List<Contacto> listaContactos(){
		return contactos;
	}
}
