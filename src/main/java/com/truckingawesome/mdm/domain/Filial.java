package com.truckingawesome.mdm.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "filiais")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Filial {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 3, nullable = false, unique = true)
    private String sigla;
}
