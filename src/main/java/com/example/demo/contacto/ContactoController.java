package com.example.demo.contacto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/contactos")
public class ContactoController {
    private final ContactoService contactoService;

    @Autowired
    public ContactoController(ContactoService contactoService) {
        this.contactoService=contactoService;
    }

    @GetMapping
    public List<Contacto> listaContactos(){
        return contactoService.listaContactos();
    }
}
