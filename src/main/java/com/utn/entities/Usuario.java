package com.utn.entities;

import com.utn.enums.Rol;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@NamedQuery(
        name = "Usuario.buscarPorEmail",
        query = "SELECT p FROM Usuario p WHERE p.email = :email"
)
@Entity
@Table(name = "usuarios")
@ToString(callSuper = true, exclude = "password")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public class Usuario extends Base {
    @Column(nullable = false)
    @Getter
    @Setter
    private String nombre;

    @Column(nullable = false)
    @Getter
    @Setter
    private String apellido;

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private String email;

    @Column(nullable = false)
    @Getter
    @Setter
    private String celular;

    @Column(nullable = false)
    @Getter
    @Setter
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Getter
    @Setter
    private Rol rol;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
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
