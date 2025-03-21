package com.PreEntrega1.testJPA.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.PreEntrega1.testJPA.dto.CabaniaCreateDTO;
import com.PreEntrega1.testJPA.dto.CabaniaDTO;
import com.PreEntrega1.testJPA.service.CabaniaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/Cabania")
public class CabaniaController {

    @Autowired
    private CabaniaService cabaniaService;

    @GetMapping("/all")
    // API: http://localhost:8080/Cabania/all
    @Operation(summary = "Obtener todas las cabanias")
    public ResponseEntity<List<CabaniaDTO>> getAllCabanias() {
        try {
            List<CabaniaDTO> cabaniaDTOs = cabaniaService.listarCabania();
            return ResponseEntity.ok(cabaniaDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/create")
    // API: http://localhost:8080/Cabania/create
    // {
    //     "nombre": "prueba",
    //     "ubicacion": "canelones",
    //     "telefono": "099386549"
    //   }
    @Operation(summary = "Crear una nueva cabania", description = "Crear una nueva cabania en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cabania cread con éxito", content = @Content(schema = @Schema(implementation = CabaniaCreateDTO.class))),
    })
    public ResponseEntity<String> createCabania(@RequestBody CabaniaCreateDTO CabaniaCreateDTO) {
        try {
            cabaniaService.saveCabaniaDTO(CabaniaCreateDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cabania creada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception e) {
        return e.getMessage();
    }

}
