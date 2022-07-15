package com.ProyectoAP.ProyectoAP.security.service;


import com.ProyectoAP.ProyectoAP.security.entity.Rol;
import com.ProyectoAP.ProyectoAP.security.enums.RolNombre;
import com.ProyectoAP.ProyectoAP.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.Optional;


@Service
@Transactional
public class RolService {

    @Autowired
     
    RolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
