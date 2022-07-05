package com.ProyectoAP.ProyectoAP.Security.jwt;

import com.ProyectoAP.ProyectoAP.Security.Entity.UsuarioPrincipal;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    // escritos en el aplication.properties//
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;

    //generador del token//
    
    
    public String generateToken (Authentication authentication){
    
    UsuarioPrincipal usuarioPrincipal=(UsuarioPrincipal) authentication.getPrincipal();
       
   return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
           .setIssuedAt(new Date())
           .setExpiration(new Date(new Date().getTime()+ expiration*1000))
           .signWith(SignatureAlgorithm.HS512,secret).compact();        
       }
   
    public String getNombreUsuarioFromToken (String token){
    
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    
    
}
