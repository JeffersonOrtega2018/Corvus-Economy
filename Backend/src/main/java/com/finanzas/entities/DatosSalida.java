
package com.finanzas.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "DatosSalida")
public class DatosSalida {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name= "f_cupon", nullable = false)
  private String f_cupon;
  @Column(name = "dias_capit", nullable = false)
  private String dias_capit;
  @Column(name = "n_periodos", nullable = false)
  private String n_periodos;
  @Column(name = "ntotal_periodos", nullable = false)
  private String ntotal_periodos;
  @Column(name = "TEA", nullable = false)
  private String TEA;
  @Column(name = "TEP", nullable = false)
  private String TEP;
  @Column(name = "COK", nullable = false)
  private String COK;
  @Column(name = "costes_iemisor", nullable = false)
  private String costes_iemisor;
  @Column(name = "costes_ibonista", nullable = false)
  private String costes_ibonista;
  @Column(name = "precio_actual", nullable = false)
  private String precio_actual;
  @Column(name = "utilidad_perdida", nullable = false)
  private String utilidad_perdida;
  @Column(name = "duracion", nullable = false)
  private String duracion;
  @Column(name = "convexidad", nullable = false)
  private String convexidad;
  @Column(name = "total", nullable = false)
  private String total;
  @Column(name = "duracion_mod", nullable = false)
  private String duracion_mod;
  @Column(name = "TCEA_EMISOR", nullable = false)
  private String TCEA_EMISOR;
  @Column(name = "TCEA_EMISOR_ESCUDO", nullable = false)
  private String TCEA_EMISOR_ESCUDO;
  @Column(name = "TREA_BONISTA", nullable = false)
  private String TREA_BONISTA;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "datosEntrada_id", referencedColumnName = "id")
  private DatosEntrada datosEntrada;
  

}
