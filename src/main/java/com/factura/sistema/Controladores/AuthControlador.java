package com.factura.sistema.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factura.sistema.Dto.JwtResponse;
import com.factura.sistema.Dto.LoginRequest;
import com.factura.sistema.Entidades.Usuario;
import com.factura.sistema.Servcios.JwtService;
import com.factura.sistema.Servcios.UsuarioServicio;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:9090")
public class AuthControlador {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired 
    private JwtService jwtService;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        System.err.println(request+"datos que llegan");
        request.setPassword("admin");
        request.setUsername("admin");
        System.out.println("el clave es:"+request.getPassword());
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        System.out.println("el usuario es:"+request.getUsername());
        System.out.println("el clave es:"+request.getPassword());
        Usuario usuario = usuarioServicio.listUsuarioNombre(user.getUsername());
        String token = jwtService.generateToken(usuario.getUsername(),usuario.getTipoUsuario().getNombre());
        return new JwtResponse(token,  usuario.getUsername());
     
    }

}
