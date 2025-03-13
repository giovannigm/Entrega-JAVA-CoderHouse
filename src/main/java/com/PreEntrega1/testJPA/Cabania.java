package com.PreEntrega1.testJPA;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data // Te ahorras de escribir los getters y setters
@Table(name = "Cabania")
public class Cabania {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ubicacion;
    private String telefono;

    @OneToMany(mappedBy = "cabania", cascade = CascadeType.ALL)
    private List<Animal> animales; // Lista de animales asociados a la cabaña

    public Cabania() {
    }

    public Cabania(String nombre, String ubicacion, String telefono) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
    }

}
