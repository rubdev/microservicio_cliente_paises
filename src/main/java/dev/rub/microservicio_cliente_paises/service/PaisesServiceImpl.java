package dev.rub.microservicio_cliente_paises.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dev.rub.microservicio_cliente_paises.model.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisesServiceImpl implements PaisesService {

    @Autowired
    RestTemplate restTemplate;

    private static final String URL_BASE = "https://restcountries.eu/rest/v2/all";

    @Override
    public List<Pais> obtenerPaises() {
        List<Pais> paisList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode arrayNode;
        // LLamada al servicio rest
        String res = restTemplate.getForObject(URL_BASE, String.class);
        // Procesamos
        try {
            // obtenemos array json con la respuesta
            arrayNode = (ArrayNode) objectMapper.readTree(res);
            for (Object objNode : arrayNode) {
                // Parseo a objeto json
                ObjectNode jsonElement = (ObjectNode) objNode;
                // Relleno datos
                String nombre = jsonElement.get("name").asText();
                String capital = jsonElement.get("capital").asText();
                Integer poblacion = jsonElement.get("population").asInt();
                String bandera = jsonElement.get("flag").asText();
                // Guardo lista paises
                Pais pais = new Pais(nombre, capital, poblacion, bandera);
                paisList.add(pais);
            }
        } catch (JsonProcessingException jex) {
            jex.printStackTrace();
        }

        return paisList;
    }

    @Override
    public List<Pais> obtenerPaisesPorNombre(String nombre) {
        return obtenerPaises()
                .stream()
                .filter(pais -> pais.getNombre().contains(nombre))
                .collect(Collectors.toList());
    }

}
