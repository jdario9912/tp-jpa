package com.utn.entities;

import com.utn.enums.Rol;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@ToString(callSuper = true, exclude = "password")
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Usuario extends Base {
    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private String apellido;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String celular;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private Rol rol;

    @Getter
    private Set<Pedido> pedidos =  new HashSet<>();

    public Usuario(Long id, Boolean eliminado, LocalDate createdAt, String nombre, String apellido, String email, String celular, String password, Rol rol) {
        super(id, eliminado, createdAt);
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
        this.password = password;
        this.rol = rol;
    }

    public void addPedido (Pedido pedido) {
        this.pedidos.add(pedido);
    }
}
