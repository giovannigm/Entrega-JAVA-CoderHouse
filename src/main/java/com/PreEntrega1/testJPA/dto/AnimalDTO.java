package com.PreEntrega1.testJPA.dto;

import java.util.Date;
import lombok.Data;

@Data
public class AnimalDTO {
    private Long id;
    private Date ingreso;
    private boolean activo;
    private String color;
    private String especie;
    private String sexo;
    private String descripcion;
    private String raza;
    private String caravana;
    private String numero_carabana_madre;
    private String comentarioBaja;
    private CabaniaDTO cabania;

}