package com.example.demo.contacto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService {
    public final ContactoRepository contactoRepository;

    public ContactoService(ContactoRepository contactoRepository) {

        this.contactoRepository = contactoRepository;
    }

    public List<Contacto> listaContactos(){

        return contactoRepository.findAll();
    }
}
