package dev.rub.microservicio_cliente_paises.service;

import dev.rub.microservicio_cliente_paises.model.Pais;

import java.util.List;

public interface PaisesService {

    List<Pais> obtenerPaises();
    List<Pais> obtenerPaisesPorNombre(String nombre);

}
