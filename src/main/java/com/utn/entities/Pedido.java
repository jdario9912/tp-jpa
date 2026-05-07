package com.utn.entities;

import com.utn.enums.Estado;
import com.utn.enums.FormaPago;
import com.utn.interfaces.Calculable;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Pedido extends Base implements Calculable {
    @Getter
    @Setter
    private LocalDate fecha;

    @Getter
    @Setter
    private Estado estado;

    @Getter
    private Double total;

    @Getter
    @Setter
    private FormaPago formaPago;

    @Getter
    private Set<DetallePedido> detallePedidos = new HashSet<>();;

    public Pedido(Long id, Boolean eliminado, LocalDate createdAt, LocalDate fecha, Estado estado, FormaPago formaPago) {
        super(id, eliminado, createdAt);
        this.fecha = fecha;
        this.estado = estado;
        this.formaPago = formaPago;
        this.detallePedidos = new HashSet<>();
    }

    public void addDetallePedido(DetallePedido detallePedido) throws Exception {
        this.detallePedidos.add(detallePedido);
    }

    public DetallePedido findDetallePedidoByProducto(Producto producto) {
        for (DetallePedido detallePedido : detallePedidos) {
            if (detallePedido.getProducto().equals(producto)) return detallePedido;
        }
        return null;
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        this.detallePedidos.removeIf(detallePedido -> detallePedido.getProducto().equals(producto));
    }

    @Override
    public void calcularTotal() {
        detallePedidos.forEach(p -> this.total += p.getSubtotal());
    }
}
