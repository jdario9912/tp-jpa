package com.utn.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Table(name = "productos")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class Producto extends Base {
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private String imagen;

    @Column
    private Boolean disponible;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Producto(Long id, Boolean eliminado, LocalDate createdAt, String nombre, Double precio, String descripcion, Integer stock, String imagen, Boolean disponible, Categoria categoria) {
        super(id, eliminado, createdAt);
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagen = imagen;
        this.disponible = disponible;
        this.categoria = categoria;
    }
}
