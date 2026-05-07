package com.utn.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
//@RequiredArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public class Categoria extends Base {
    private String nombre;
    private String descripcion;
}
