/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProyectoAP.ProyectoAP.controller;

import com.ProyectoAP.ProyectoAP.exception.resourceNotFoundException;
import com.ProyectoAP.ProyectoAP.model.hys;
import com.ProyectoAP.ProyectoAP.repository.hysRepository;
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

/**
 *
 * @author Pc
 */
@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "https://proyectoap-4e60f.web.app")
public class hysController {

    @Autowired
    private hysRepository hysrepository;

   @CrossOrigin(origins = "https://proyectoap-4e60f.web.app")

    //Buscar todas las habilidades >> http://localhost:8080/api/v1/hys   //
    @GetMapping("/hys")
    public List<hys> buscarTodasLashsy() {
        return hysrepository.findAll();
    }

    //Buscar una habilidad>> http://localhost:8080/api/v1/hys/findById/2   //
   @CrossOrigin(origins = "https://proyectoap-4e60f.web.app")
    @GetMapping("/hys/findById/{id}")

    public hys getUserByID(@PathVariable Long id) {

        hys Hys = hysrepository.findById(id)
                .orElseThrow(() -> new  resourceNotFoundException("No existe habilidad con ese ID:" + id));
               

        return Hys;
    }

    // crear una habilidad nueva>> http://localhost:8080/api/v1/new/hys  //
   @CrossOrigin(origins = "https://proyectoap-4e60f.web.app")
    @PostMapping("/new/hys")
    @PreAuthorize("hasRole('ADMIN')")
   
    public void crearhys(@RequestBody hys hysNueva) {
        hysrepository.save(hysNueva);
    }

    //actualizar datos>> http://localhost:8080/api/v1/hys/edit/{id}//
  @CrossOrigin(origins = "https://proyectoap-4e60f.web.app")
  @PutMapping("/hys/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    
    public ResponseEntity<hys> Actualizar(@PathVariable Long id, @RequestBody hys hysDetalle) {

        hys Habilidad = hysrepository.findById(id)
                .orElseThrow(() -> new resourceNotFoundException("No existe habilidad con ese Id:" + id));

        Habilidad.setNombre(hysDetalle.getNombre());

        Habilidad.setPercent(hysDetalle.getPercent());

        hys Actualizarhys = hysrepository.save(Habilidad);
        return ResponseEntity.ok(Actualizarhys);

    }

  
//Elimina capacitacion>> http://localhost:8080/api/v1/hys/delete/{id} //
    @CrossOrigin(origins = "https://proyectoap-4e60f.web.app")
    @DeleteMapping("/hys/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
  
    public ResponseEntity<Map<String, Boolean>> eliminarHys(@PathVariable Long id) {
        hys hys = hysrepository.findById(id)
                .orElseThrow(() -> new resourceNotFoundException("No existe habilidad con ese Id:" + id));

        hysrepository.delete(hys);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Habiliadad Eliminada", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
