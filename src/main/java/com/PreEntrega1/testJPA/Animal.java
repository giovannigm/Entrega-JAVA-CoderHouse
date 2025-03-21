package com.PreEntrega1.testJPA;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;

@Entity
@Data // Te ahorras de escribir los getters y setters
@Table(name = "Animales")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date ingreso;
    private boolean activo;
    private String color;
    private String especie; // caballo, oveja, vaca, etc.
    private String sexo; // macho o hembra
    private String descripcion;
    private String raza;
    private int caravana;
    private Integer numero_carabana_madre; // si es hijo de otro animal se pone numero de carabana de la "madre"
    private String comentarioBaja;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cabania_id")
    private Cabania cabania;

    public Animal() {
    }

    public Animal(Date ingreso, boolean activo, String color, String especie, String sexo, String descripcion,
            String raza, int caravana, Integer numero_carabana_madre, String comentarioBaja, Cabania cabania) {
        this.ingreso = ingreso;
        this.color = color;
        this.especie = especie;
        this.sexo = sexo;
        this.descripcion = descripcion;
        this.raza = raza;
        this.caravana = caravana;
        this.numero_carabana_madre = numero_carabana_madre;
        this.activo = activo;
        this.comentarioBaja = comentarioBaja;
        this.cabania = cabania;
    }

}
