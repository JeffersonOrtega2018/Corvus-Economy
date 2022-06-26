package com.finanzas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Getter
@Inheritance (strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
// @Builder
@SuperBuilder(toBuilder = true)
@Table(name = "TipoInteres")
public class TipoInteres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "name", nullable = false)
    private String name;
}
