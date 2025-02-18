package com.PreEntrega1.testJPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Animales")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String especie; // caballo, oveja, vaca, etc.
    private String raza;
    private String sexo; // macho o hembra
    private int edad;
    private String caravana;
    private String descripcion;
    private String color;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cabania_id")
    private Cabania cabania;

    public Animal(Long id) {
        this.id = id;
    }

    public Animal(String especie, String raza, String sexo, int edad, String caravana, String descripcion,
            String color, Cabania cabania) {
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.edad = edad;
        this.caravana = caravana;
        this.descripcion = descripcion;
        this.color = color;
        this.cabania = cabania;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCaravana() {
        return caravana;
    }

    public void setCaravana(String caravana) {
        this.caravana = caravana;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
