package br.com.lorde.supremo.forum.config.security;

import br.com.lorde.supremo.forum.model.Usuario;
import br.com.lorde.supremo.forum.repository.UsuarioRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticationByToken extends OncePerRequestFilter {

    private TokenService tokenService;
    private UsuarioRepository repository;

    public AutenticationByToken(TokenService tokenService, UsuarioRepository repository) {
        this.tokenService = tokenService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException
    {
        String token = recuperarToken(request);
        Boolean valido = tokenService.isValid(token);
        if(valido){
            Long userId = tokenService.getUserIdBy(token);
            Usuario user = repository.findById(userId).get();

            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                user, null, user.getAuthorities()
            ));
        }

        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");

        if(token instanceof String) {
            return token.replace("Bearer ", "");
        }
        return null;
    }
}
