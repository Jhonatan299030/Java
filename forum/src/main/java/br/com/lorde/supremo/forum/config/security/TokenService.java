package br.com.lorde.supremo.forum.config.security;

import br.com.lorde.supremo.forum.model.Usuario;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    public String generete(Authentication authentication){
        Usuario usuario = (Usuario) authentication.getPrincipal();
        Date hoje = new Date();

        return Jwts.builder().
            setIssuedAt(hoje).
            setIssuer("API do Fórum do Lorde Supremo").
            setSubject(usuario.getId().toString()).
            setExpiration(new Date(hoje.getTime() + Long.parseLong(expiration))).
            signWith(SignatureAlgorithm.HS256, secret)
            .compact();
    }

    public boolean isValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Long getUserIdBy(String token){
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
