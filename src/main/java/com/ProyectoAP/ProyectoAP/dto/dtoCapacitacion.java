

package com.ProyectoAP.ProyectoAP.dto;

import javax.validation.constraints.NotBlank;


public class dtoCapacitacion {
    
   @NotBlank   
   
     private String nombre;
   @NotBlank
     private String lugar;

    public dtoCapacitacion() {
    }

    public dtoCapacitacion(String nombre, String lugar) {
        this.nombre = nombre;
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
   
   
    
}
