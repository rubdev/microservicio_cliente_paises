package dev.rub.microservicio_cliente_paises.controller;

import dev.rub.microservicio_cliente_paises.model.Pais;
import dev.rub.microservicio_cliente_paises.service.PaisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaisesController {

    @Autowired
    PaisesService paisesService;

    @GetMapping(value = "/paises", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pais> obtenerPaises() {
        return paisesService.obtenerPaises();
    }

    @GetMapping(value = "/paises/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pais> obtenerPaisesPorNombre(@PathVariable("nombre") String nombre) {
        return paisesService.obtenerPaisesPorNombre(nombre);
    }

}
