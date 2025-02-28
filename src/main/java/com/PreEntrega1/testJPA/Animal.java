package com.PreEntrega1.testJPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data // Te ahorras de escribir los getters y setters
@Table(name = "Animales")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int edad;
    private String color;
    private String especie; // caballo, oveja, vaca, etc.
    private String sexo; // macho o hembra
    private String descripcion;
    private String raza;
    private String caravana;
    private Long numero_carabana_madre; // si es hijo de otro animal se pone numero de carabana de la "madre"

    @ManyToOne(optional = false)
    @JoinColumn(name = "cabania_id")
    private Cabania cabania;

    public Animal() {
    }

    public Animal(String especie, String raza, String sexo, int edad, String caravana, String descripcion,
            String color, Cabania cabania, Long numero_carabana_madre) {
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.edad = edad;
        this.caravana = caravana;
        this.descripcion = descripcion;
        this.color = color;
        this.cabania = cabania;
        this.numero_carabana_madre = numero_carabana_madre; // Inicializar el nuevo campo
    }

}
