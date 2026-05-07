package com.utn.entities;


import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class DetallePedido extends Base {
    @Getter
    private Integer cantidad;

    @Getter
    @Setter
    private Double subtotal;

    @Getter
    private Producto producto;

    public DetallePedido(Long id, Boolean eliminado, LocalDate createdAt, Integer cantidad, Double subtotal) {
        super(id, eliminado, createdAt);
        this.subtotal = subtotal;
        this.cantidad = cantidad;
    }

    public DetallePedido(Long id, Boolean eliminado, LocalDate createdAt, Integer cantidad, Double subtotal, Producto producto) throws Exception {
        super(id, eliminado, createdAt);
        this.validarDisponibilidad(producto);
        this.validarStock(cantidad, producto);
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.producto = producto;
    }

    public void setCantidad(Integer cantidad) throws Exception {
        if (this.producto != null) this.validarStock(cantidad, this.producto);
    }

    public void setProducto(Producto producto) throws Exception {
        this.validarDisponibilidad(producto);
        this.producto = producto;
    }

    private void validarDisponibilidad(Producto producto) throws Exception {
        if (!producto.getDisponible()) throw new Exception("El producto no esta disponible");
    }

    private void validarStock(Integer cantidad,  Producto producto) throws Exception {
        if (cantidad > producto.getStock()) throw new Exception("Stock insuficiente");
    }
}
