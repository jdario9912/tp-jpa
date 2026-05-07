package com.utn;

import com.utn.entities.*;
import com.utn.enums.Estado;
import com.utn.enums.FormaPago;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Categoria c1 = Categoria.builder()
                .id(101L)
                .eliminado(false)
                .createdAt(LocalDate.now())
                .nombre("Hamburguesas")
                .descripcion("Variedad de hamburguesas con carne de angus y pan artesanal.")
                .build();

        Categoria c2 = Categoria.builder()
                .id(50L)
                .eliminado(false)
                .createdAt(LocalDate.now())
                .nombre("Gaseosas")
                .descripcion("Línea de bebidas con gas.")
                .build();

        Categoria c3 = Categoria.builder()
                .id(20L)
                .eliminado(false)
                .createdAt(LocalDate.now())
                .nombre("Pizzas")
                .descripcion("Pizzas a la piedra")
                .build();

        Producto p1 = Producto.builder()
                .id(1L).eliminado(false).createdAt(LocalDate.now())
                .nombre("Cheeseburger Simple")
                .precio(8.50)
                .descripcion("Carne de res, queso cheddar y pan brioche.")
                .stock(50).disponible(true).imagen("cheeseburger.jpg")
                .categoria(c1)
                .build();

        Producto p2 = Producto.builder()
                .id(2L).eliminado(false).createdAt(LocalDate.now())
                .nombre("Coca-Cola 500ml")
                .precio(2.00)
                .descripcion("Envase de vidrio.")
                .stock(100).disponible(true).imagen("coke.jpg")
                .categoria(c2)
                .build();

        Producto p3 = Producto.builder()
                .id(4L).eliminado(false).createdAt(LocalDate.now())
                .nombre("Truffle Burger")
                .precio(14.50)
                .descripcion("Carne madurada con mayonesa de trufa negra.")
                .stock(4).disponible(false).imagen("truffle_b.jpg")
                .categoria(c1)
                .build();

        Producto p4 = Producto.builder()
                .id(5L).eliminado(false).createdAt(LocalDate.now())
                .nombre("Sprite 500ml")
                .precio(1.50)
                .descripcion("Envase de vidrio.")
                .stock(200).disponible(true).imagen("agua.jpg")
                .categoria(c2)
                .build();

        Producto p5 = Producto.builder()
                .id(7L).eliminado(false).createdAt(LocalDate.now())
                .nombre("Veggie Delight")
                .precio(10.00)
                .descripcion("Medallón de garbanzos y rúcula.")
                .stock(30).disponible(false).imagen("veggie.jpg")
                .categoria(c1)
                .build();

        Producto p6 = Producto.builder()
                .id(8L).eliminado(false).createdAt(LocalDate.now())
                .nombre("Fanta 500ml")
                .precio(3.50)
                .descripcion("Envase de vidrio.")
                .stock(2).disponible(false).imagen("monster.jpg")
                .categoria(c2)
                .build();

        Producto p7 = Producto.builder()
                .id(9L).eliminado(false).createdAt(LocalDate.now())
                .nombre("Jalapeño Burger")
                .precio(11.25)
                .descripcion("Carne de res con extra jalapeños y salsa brava.")
                .stock(25).disponible(true).imagen("hot_burger.jpg")
                .categoria(c1)
                .build();

        Producto p8 = Producto.builder()
                .id(11L)
                .eliminado(false)
                .createdAt(LocalDate.now())
                .nombre("Margarita Pepperoni")
                .precio(12.50)
                .descripcion("Base de tomate San Marzano, mozzarella fior di latte y pepperoni crujiente.")
                .stock(40)
                .disponible(true)
                .imagen("pepperoni_pizza.jpg")
                .categoria(c3)
                .build();

        Producto p9 = Producto.builder()
                .id(12L)
                .eliminado(false)
                .createdAt(LocalDate.now())
                .nombre("Cuatro Quesos a la Piedra")
                .precio(14.00)
                .descripcion("Mezcla de gorgonzola, provolone, parmesano y mozzarella sobre masa fina.")
                .stock(25)
                .disponible(true)
                .imagen("4quesos.png")
                .categoria(c3)
                .build();

        Producto p10 = Producto.builder()
                .id(13L)
                .eliminado(false)
                .createdAt(LocalDate.now())
                .nombre("Huerta Mediterránea")
                .precio(11.90)
                .descripcion("Pimientos asados, cebolla morada, aceitunas negras y rúcula fresca.")
                .stock(1)
                .disponible(false)
                .imagen("veggie_pizza.jpg")
                .categoria(c3)
                .build();

        List<Producto> listaProductos = List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);

        System.out.println("Productos disponibles");
        listaProductos.stream().filter(p -> p.getDisponible()).forEach(System.out::println);

        try {
            DetallePedido d1 = DetallePedido.builder()
                    .id(101L).eliminado(false).createdAt(LocalDate.now())
                    .cantidad(3).subtotal(p1.getPrecio() * 3).producto(p1)
                    .build();
            DetallePedido d2 = DetallePedido.builder()
                    .id(102L).eliminado(false).createdAt(LocalDate.now())
                    .cantidad(1).subtotal(p2.getPrecio() * 1).producto(p2)
                    .build();
            DetallePedido d3 = DetallePedido.builder()
                    .id(103L).eliminado(false).createdAt(LocalDate.now())
                    .cantidad(2).subtotal(p9.getPrecio() * 2).producto(p9)
                    .build();
            DetallePedido d4 = DetallePedido.builder()
                    .id(104L).eliminado(false).createdAt(LocalDate.now())
                    .cantidad(1).subtotal(p5.getPrecio() * 1).producto(p5)
                    .build();

            Set<DetallePedido> detallesPedido = Set.of(d1, d2, d3, d4);


            Pedido pe1 = Pedido.builder()
                    .id(10L)
                    .eliminado(false)
                    .createdAt(LocalDate.now())
                    .fecha(LocalDate.now())
                    .estado(Estado.PENDIENTE)
                    .total(12000.00)
                    .formaPago(FormaPago.EFECTIVO)
                    .detallePedidos(detallesPedido)
                    .build();

            System.out.println("\nCantidad de ítems del pedido");
            Long items = pe1.getDetallePedidos().stream().count();
            System.out.println(items);

            System.out.println("\nProductos con stock menor a 5");
            listaProductos.stream().filter(p -> p.getStock() < 5).forEach(producto ->  System.out.println(producto.getNombre()));


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
