
package com.ProyectoAP.ProyectoAP.security.Repository;

import com.ProyectoAP.ProyectoAP.security.Entity.Rol;
import com.ProyectoAP.ProyectoAP.security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
    
}
