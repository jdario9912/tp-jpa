package com.utn;

import com.utn.entities.*;
import com.utn.enums.Estado;
import com.utn.enums.FormaPago;
import com.utn.enums.Rol;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("utnPU");
             EntityManager em = emf.createEntityManager()) {

            Categoria c1 = Categoria.builder()
                .eliminado(false)
                .createdAt(LocalDate.now())
                .nombre("Hamburguesas")
                .descripcion("Variedad de hamburguesas con carne de angus y pan artesanal.")
                .build();

            Categoria c2 = Categoria.builder()
                .eliminado(false)
                .createdAt(LocalDate.now())
                .nombre("Gaseosas")
                .descripcion("Línea de bebidas con gas.")
                .build();

            Categoria c3 = Categoria.builder()
                .eliminado(false)
                .createdAt(LocalDate.now())
                .nombre("Pizzas")
                .descripcion("Pizzas a la piedra")
                .build();

            Producto p1 = Producto.builder()
                .eliminado(false).createdAt(LocalDate.now())
                .nombre("Cheeseburger Simple")
                .precio(8.50)
                .descripcion("Carne de res, queso cheddar y pan brioche.")
                .stock(50).disponible(true).imagen("cheeseburger.jpg")
                .categoria(c1)
                .build();

            Producto p2 = Producto.builder()
                .eliminado(false).createdAt(LocalDate.now())
                .nombre("Coca-Cola 500ml")
                .precio(2.00)
                .descripcion("Envase de vidrio.")
                .stock(100).disponible(true).imagen("coke.jpg")
                .categoria(c2)
                .build();

            Producto p3 = Producto.builder()
                    .eliminado(false).createdAt(LocalDate.now())
                .nombre("Truffle Burger")
                .precio(14.50)
                .descripcion("Carne madurada con mayonesa de trufa negra.")
                .stock(4).disponible(false).imagen("truffle_b.jpg")
                .categoria(c1)
                .build();

            Producto p4 = Producto.builder()
                    .eliminado(false).createdAt(LocalDate.now())
                .nombre("Sprite 500ml")
                .precio(1.50)
                .descripcion("Envase de vidrio.")
                .stock(200).disponible(true).imagen("agua.jpg")
                .categoria(c2)
                .build();

            Producto p5 = Producto.builder()
                    .eliminado(false).createdAt(LocalDate.now())
                .nombre("Veggie Delight")
                .precio(10.00)
                .descripcion("Medallón de garbanzos y rúcula.")
                .stock(30).disponible(false).imagen("veggie.jpg")
                .categoria(c1)
                .build();

            Producto p6 = Producto.builder()
                    .eliminado(false).createdAt(LocalDate.now())
                .nombre("Fanta 500ml")
                .precio(3.50)
                .descripcion("Envase de vidrio.")
                .stock(2).disponible(false).imagen("monster.jpg")
                .categoria(c2)
                .build();

            Producto p7 = Producto.builder()
                    .eliminado(false).createdAt(LocalDate.now())
                .nombre("Jalapeño Burger")
                .precio(11.25)
                .descripcion("Carne de res con extra jalapeños y salsa brava.")
                .stock(25).disponible(true).imagen("hot_burger.jpg")
                .categoria(c1)
                .build();

            Producto p8 = Producto.builder()
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

            DetallePedido d1 = DetallePedido.builder()
                    .eliminado(false).createdAt(LocalDate.now())
                    .cantidad(3).subtotal(p1.getPrecio() * 3).producto(p1)
                    .build();
            DetallePedido d2 = DetallePedido.builder()
                    .eliminado(false).createdAt(LocalDate.now())
                    .cantidad(1).subtotal(p2.getPrecio() * 1).producto(p2)
                    .build();

            Set<DetallePedido> detallesPedido1 = Set.of(d1, d2);

            Pedido pe1 = Pedido.builder()
                .eliminado(false)
                .createdAt(LocalDate.now())
                .fecha(LocalDate.now())
                .estado(Estado.PENDIENTE)
                .total(12000.00)
                .formaPago(FormaPago.TARJETA)
                .build();
            pe1.setDetallePedidos(detallesPedido1);

            DetallePedido d3 = DetallePedido.builder()
                    .eliminado(false).createdAt(LocalDate.now())
                .cantidad(2).subtotal(p3.getPrecio() * 2).producto(p3)
                .build();
            DetallePedido d4 = DetallePedido.builder()
                    .eliminado(false).createdAt(LocalDate.now())
                .cantidad(1).subtotal(p4.getPrecio() * 1).producto(p4)
                .build();

            Set<DetallePedido> detallesPedido2 = Set.of(d3, d4);

            Pedido pe2 = Pedido.builder()
                    .eliminado(false)
                    .createdAt(LocalDate.now())
                    .fecha(LocalDate.now())
                    .estado(Estado.PENDIENTE)
                    .total(12000.00)
                    .formaPago(FormaPago.EFECTIVO)
                    .build();
            pe2.setDetallePedidos(detallesPedido2);

            DetallePedido d5 = DetallePedido.builder()
                    .eliminado(false).createdAt(LocalDate.now())
                    .cantidad(2).subtotal(p5.getPrecio() * 2).producto(p5)
                    .build();
            DetallePedido d6 = DetallePedido.builder()
                    .eliminado(false).createdAt(LocalDate.now())
                    .cantidad(1).subtotal(p6.getPrecio() * 1).producto(p6)
                    .build();

            Set<DetallePedido> detallesPedido3 = Set.of(d5, d6);

            Pedido pe3 = Pedido.builder()
                    .eliminado(false)
                    .createdAt(LocalDate.now())
                    .fecha(LocalDate.now())
                    .estado(Estado.PENDIENTE)
                    .total(12000.00)
                    .formaPago(FormaPago.TRANSFERENCIA)
                    .build();
            pe3.setDetallePedidos(detallesPedido3);

            Usuario u1 = new Usuario(null, false, LocalDate.now(), "Bad", "Bunny", "bunny@email.com", "123456789", "secreto", Rol.USUARIO);
            u1.addPedido(pe1);
            u1.addPedido(pe2);

            Usuario u2 = new Usuario(null, false, LocalDate.now(), "Katty", "Perry", "katty@email.com", "123456789", "secreto", Rol.ADMIN);
            u2.addPedido(pe3);

            em.getTransaction().begin();

            em.persist(p7);
            em.persist(p8);
            em.persist(p9);
            em.persist(p10);

            em.persist(u1);
            em.persist(u2);

            em.find(Producto.class, p9.getId()).setStock(33);
            em.find(Producto.class, p10.getId()).setPrecio(15.00);

            Usuario usuarioEncontradoId = em.find(Usuario.class, u1.getId());
            Usuario usuarioEncontradoEmail = em.createNamedQuery("Usuario.buscarPorEmail", Usuario.class).setParameter("email","katty@email.com").getResultList().get(0);

            Producto productoEliminar = em.find(Producto.class, p8.getId());
            em.remove(productoEliminar);
            em.getTransaction().commit();

            System.out.println("Usuario encontrado por su id: " + usuarioEncontradoId);
            System.out.println("Usuario encontrado por su email: " + usuarioEncontradoEmail);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}