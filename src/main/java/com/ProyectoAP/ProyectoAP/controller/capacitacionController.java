package com.ProyectoAP.ProyectoAP.controller;

import com.ProyectoAP.ProyectoAP.exception.resourceNotFoundException;
import com.ProyectoAP.ProyectoAP.model.capacitacion;
import com.ProyectoAP.ProyectoAP.repository.capacitacionRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")

public class capacitacionController {

    @Autowired
    private capacitacionRepository caRepository;

    @CrossOrigin(origins = "http://localhost:4200")

    //buscar todas las capacitaciones>> http://localhost:8080/api/v1/capacitacion   //
    @GetMapping("/capacitacion")
    public List<capacitacion> buscarTodasLasPersonas() {
        return caRepository.findAll();
    }

    //Buscar una capacitacion>> http://localhost:8080/api/v1/capacitacion/findById/2   //
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/capacitacion/findById/{id}")
    public capacitacion getUserByID(@PathVariable Long id) {

        capacitacion capa = caRepository.findById(id)
                .orElseThrow(() -> new resourceNotFoundException("No existe persona con ese Id:" + id));

        return capa;
    }

    // crear una capacitacion>> http://localhost:8080/api/v1/new/capacitacion   //
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/new/capacitacion")
    @PreAuthorize("hasRole('ADMIN')")

    public void crearCapacitacion(@RequestBody capacitacion capacitacionNueva) {
        caRepository.save(capacitacionNueva);

    }

//actualizar datos>> http://localhost:8080/api/v1/capacitacion/edit/{id}//
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/capacitacion/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")

    public ResponseEntity<capacitacion> Actualizar(@PathVariable Long id, @RequestBody capacitacion capaDetalle) {

        capacitacion capa = caRepository.findById(id)
                .orElseThrow(() -> new resourceNotFoundException("No existe persona con ese Id:" + id));

        capa.setNombre(capaDetalle.getNombre());
        capa.setLugar(capaDetalle.getLugar());

        capacitacion ActualizarCapacitacion = caRepository.save(capa);
        return ResponseEntity.ok(ActualizarCapacitacion);

    }

//Elimina capacitacion>> http://localhost:8080/api/v1/capacitacion/delete/{id} //
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/capacitacion/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map<String, Boolean>> eliminarCapacitacion(@PathVariable Long id) {
        capacitacion capa = caRepository.findById(id)
                .orElseThrow(() -> new resourceNotFoundException("No existe persona con ese Id:" + id));

        caRepository.delete(capa);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Capacitacion Eliminada", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
