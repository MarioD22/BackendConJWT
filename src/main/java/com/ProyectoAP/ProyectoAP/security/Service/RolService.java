
package com.ProyectoAP.ProyectoAP.security.Service;

import com.ProyectoAP.ProyectoAP.security.Entity.Rol;
import com.ProyectoAP.ProyectoAP.security.Enums.RolNombre;
import com.ProyectoAP.ProyectoAP.security.Repository.iRolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional <Rol> getByRolNombre (RolNombre rolNombre){
    
    return irolRepository.findByRolNombre(rolNombre);
    
    }
    
    public void save ( Rol rol){
    
        irolRepository.save(rol);
    }
    
}
