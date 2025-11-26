package com.example.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "productos")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank(message = "El nombre no puede estar vacio")
  private String nombre;

  @Min(value = 0, message = "El stock no puede ser negativo")
  private int stock;

  public Product() {
  }

  public Product(String nombre, int stock) {
    this.nombre = nombre;
    this.stock = stock;
  }

  public Integer getId() { return id; }
  public void setId(Integer id) { this.id = id; }

  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }

  public int getStock() { return stock; }
  public void setStock(int stock) { this.stock = stock; }
}