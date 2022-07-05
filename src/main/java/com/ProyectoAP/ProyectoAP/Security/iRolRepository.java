
package com.ProyectoAP.ProyectoAP.Security;

import com.ProyectoAP.ProyectoAP.Security.Entity.Rol;
import com.ProyectoAP.ProyectoAP.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
    
}
