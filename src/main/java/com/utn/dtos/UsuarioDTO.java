package com.utn.dtos;

import com.utn.entities.Usuario;

public record UsuarioDTO(
        String nombre,
        String apellido,
        String email,
        String celular
) {
    public static UsuarioDTO from(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                usuario.getCelular()
        );
    }
}
