package com.ProyectoAP.ProyectoAP.util;

import com.ProyectoAP.ProyectoAP.security.Entity.Rol;    
import com.ProyectoAP.ProyectoAP.security.Enums.RolNombre;
import com.ProyectoAP.ProyectoAP.security.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */
@Component
public class CreateRoles implements CommandLineRunner{
    
     @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
         Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);
         
    }
    
}
