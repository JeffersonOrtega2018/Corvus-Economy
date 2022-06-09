package com.finanzas.entities;

import lombok.AllArgsConstructor;
// import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Getter
@Inheritance (strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
// @Builder
@SuperBuilder(toBuilder = true)
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name= "email", nullable = false, unique = true)
  private String email;
  @Column(name = "password", nullable = false)
  private String password;
  @Column(name = "nombres", nullable = false)
  private String nombres;
  @Column(name = "apellidos", nullable = false)
  private String apellidos;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "role_id")
  private Collection<Role> rols = new ArrayList<>();
}
