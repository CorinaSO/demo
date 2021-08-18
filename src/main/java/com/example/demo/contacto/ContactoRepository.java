package com.example.demo.contacto;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ContactoRepository extends MongoRepository<Contacto,String> {
    Optional<Contacto> findContactoByEmail(String email);
}
