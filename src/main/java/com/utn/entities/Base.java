package com.utn.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
public abstract class Base {
    private Long id;
    private Boolean eliminado;
    private LocalDate createdAt;
}
