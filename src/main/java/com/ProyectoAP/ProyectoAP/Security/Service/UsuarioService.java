
package com.ProyectoAP.ProyectoAP.Security.Service;
import com.ProyectoAP.ProyectoAP.Security.Entity.Usuario;
import com.ProyectoAP.ProyectoAP.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
     @Autowired
     iUsuarioRepository iusuarioRepository;
    
     public  Optional <Usuario> getByNombreUsuario ( String nombreUsuario){
     return  iusuarioRepository.findByNombreUsuario(nombreUsuario);
     }
    
    public boolean existsByNombreUsuario ( String nombreUsuario) {
    
    return iusuarioRepository.existByNombreUsuario(nombreUsuario);
    }
    
     public boolean existsByEmail ( String email ) {
    
    return iusuarioRepository.existByEmail(email);
    }
    
     public void save (Usuario usuario){
     
         iusuarioRepository.save(usuario);
     }
    
}
