package com.ProyectoAP.ProyectoAP.security.repository;

import com.ProyectoAP.ProyectoAP.security.entity.Rol;
import com.ProyectoAP.ProyectoAP.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
