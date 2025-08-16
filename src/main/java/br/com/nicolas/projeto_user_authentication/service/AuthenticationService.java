package br.com.nicolas.projeto_user_authentication.service;

import br.com.nicolas.projeto_user_authentication.dto.AccessDTO;
import br.com.nicolas.projeto_user_authentication.dto.AuthenticationDTO;
import br.com.nicolas.projeto_user_authentication.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AccessDTO login(AuthenticationDTO authenticationDTO) {
        try {
            //Cria mecanismo de credencial para o spring
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(), authenticationDTO.getPassword());
            //Prepara mecanismo para autenticação
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            //Busca usuário logado
            UserDetailsImpl userAuthenticate = (UserDetailsImpl)authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            AccessDTO accessDTO = new AccessDTO(token);

            return accessDTO;
        } catch (BadCredentialsException e) {
            //TODO Login ou senha inválido
        }
        return new AccessDTO("Acesso negado");
    }
}
