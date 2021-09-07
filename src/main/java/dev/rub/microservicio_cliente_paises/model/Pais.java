package dev.rub.microservicio_cliente_paises.model;


public class Pais {

    private String nombre;
    private String capital;
    private Integer poblacion;
    private String bandera;

    public Pais() {

    }

    public Pais(String nombre, String capital, Integer poblacion, String bandera) {
        this.nombre = nombre;
        this.capital = capital;
        this.poblacion = poblacion;
        this.bandera = bandera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Integer getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }
}
