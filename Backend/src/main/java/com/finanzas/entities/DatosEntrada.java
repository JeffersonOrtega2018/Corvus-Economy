package com.finanzas.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DatosEntrada")
public class DatosEntrada {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="name", nullable = false)
  private String name;
  @Column(name= "v_nominal", nullable = false)
  private float v_nominal;
  @Column(name = "v_comercial", nullable = false)
  private float v_comercial;
  @Column(name = "n_años", nullable = false)
  private int n_años;
  @Column(name = "ta_anual_desc", nullable = false)
  private float ta_anual_desc;
  @Column(name = "ImpuestoR", nullable = false)
  private float ImpuestoR;
  @Column(name = "fch_emision", nullable = false)
  private LocalDate fch_emision;
  @Column(name = "prima", nullable = false)
  private float prima;
  @Column(name = "estructuracion", nullable = false)
  private float estructuracion;
  @Column(name = "colocacion", nullable = false)
  private float colocacion;
  @Column(name = "flotacion", nullable = false)
  private float flotacion;
  @Column(name = "cavali", nullable = false)
  private float cavali;
  @Column(name = "tasa_interes", nullable = false)
  private float tasa_interes;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user_id;
  @ManyToOne
  @JoinColumn(name= "frecuencia_id")
  private FrecuenciaBono frecuencia_id;
  @ManyToOne
  @JoinColumn(name= "tipoanho_id")
  private TipoAnho tanho_id;
  @ManyToOne
  @JoinColumn(name= "tipointeres_id")
  private TipoInteres tipointeres_id;  
  @ManyToOne
  @JoinColumn(name= "capitalizacion_id")
  private Capitalizacion capitalizacion_id;  
  @ManyToOne
  @JoinColumn(name= "moneda_id")
  private Capitalizacion nomeda_id;
}
