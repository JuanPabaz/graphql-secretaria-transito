package secretaria.graphql.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import secretaria.graphql.dto.*;
import secretaria.graphql.entities.RefreshToken;
import secretaria.graphql.exceptions.BadUserCredentialsException;
import secretaria.graphql.repositories.UserRepository;
import secretaria.graphql.services.AuthenticationService;
import secretaria.graphql.services.JwtServiceImpl;
import secretaria.graphql.services.RefreshTokenService;
import secretaria.graphql.services.TrafficTicketService;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthGraphQLController {

    private final AuthenticationService authenticationService;

    private final RefreshTokenService refreshTokenService;

    private final AuthenticationManager authenticationManager;

    private final JwtServiceImpl jwtService;

    private final UserRepository userRepository;

    public AuthGraphQLController(AuthenticationService authenticationService, RefreshTokenService refreshTokenService, AuthenticationManager authenticationManager, JwtServiceImpl jwtService, UserRepository userRepository) {
        this.authenticationService = authenticationService;
        this.refreshTokenService = refreshTokenService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @MutationMapping(name = "login")
    public AuthResponseDTO login(@Argument AuthRequestDTO authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            Optional<RefreshToken> refreshTokenOptional = refreshTokenService.findByUsername(authRequest.getUsername());
            refreshTokenOptional.ifPresent(refreshTokenService::DeleteRefreshToken);
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(authRequest.getUsername());
            AuthResponseDTO authResponseDTO = new AuthResponseDTO();
            authResponseDTO.setRole(userRepository.findRoleByUsername(authRequest.getUsername()));
            authResponseDTO.setRefreshToken(refreshToken.getToken());
            authResponseDTO.setAccessToken(authenticationService.generateToken(authRequest.getUsername()));

            return authResponseDTO;

        }catch (BadUserCredentialsException e){
            throw new BadUserCredentialsException(e.getMessage());
        } catch (Exception e){
            throw new BadUserCredentialsException("Usuario y/o contraseña incorrectas");
        }
    }


}
