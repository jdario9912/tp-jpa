package com.utn.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@MappedSuperclass
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
public abstract class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private Boolean eliminado = false;

    @CreationTimestamp()
    private LocalDate createdAt;
}
