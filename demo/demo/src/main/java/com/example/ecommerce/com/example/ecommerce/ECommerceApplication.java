package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ECommerceApplication.class, args);
    System.out.println("Servidor funcionando en el puerto 8080 del localhost");
  }
}
