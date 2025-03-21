package com.PreEntrega1.testJPA.dto;

import java.util.Date;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonInclude;

@Data
public class AnimalCreateDTO {
    private Date ingreso;
    private boolean activo;
    private String color;
    private String especie;
    private String sexo;
    private String descripcion;
    private String raza;
    private int caravana;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(example = "null")
    private Integer numero_carabana_madre;
    // Con esta anotación,el campo `comentarioBaja` se omitirá cuando sea null
    // y swagger mostrará el campo como null en el ejemplo del la solicitud.
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(example = "null")
    private String comentarioBaja;
}
