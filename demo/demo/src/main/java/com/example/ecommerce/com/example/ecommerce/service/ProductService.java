package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> obtenerTodos() {
    return productRepository.findAll();
  }

  public void agregarProducto(Product producto) {
    productRepository.save(producto);
  }

  public Product buscarPorId(int id) {
    return productRepository.findById(id).orElse(null);
  }

  public Product actualizarProducto(int id, Product productoNuevo) {
    Product p = buscarPorId(id);
    if (p != null) {
      p.setNombre(productoNuevo.getNombre());
      p.setStock(productoNuevo.getStock());
      return productRepository.save(p);
    }
    return null;
  }

  public boolean eliminarProducto(int id) {
    if (productRepository.existsById(id)) {
      productRepository.deleteById(id);
      return true;
    }
    return false;
  }


  public List<Product> buscarPorNombre(String nombre) {
    return productRepository.findByNombreContainingIgnoreCase(nombre);
  }

  public String comprarProducto(int id, int cantidad) {
    Product p = buscarPorId(id);

    if (p == null) {
      return "Producto no encontrado.";
    }
    if (p.getStock() < cantidad) {
      return "No hay suficiente stock.";
    }
    p.setStock(p.getStock() - cantidad);
    productRepository.save(p);
    return "✅ Compra realizada. Stock restante: " + p.getStock();
  }
}