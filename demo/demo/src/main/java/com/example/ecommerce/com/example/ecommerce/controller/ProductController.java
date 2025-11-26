package com.example.ecommerce.controller;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  // Listar todos los prodcutos
  @GetMapping
  public List<Product> listarProductos() {
    return productService.obtenerTodos();
  }

  // Crear producto
  @PostMapping
  public String crearProducto(@RequestBody Product producto) {
    productService.agregarProducto(producto);
    return "✅ Producto agregado: " + producto.getNombre();
  }

  // Buscar producto por nombre
  // URL: GET http://localhost:8080/api/productos/buscar?nombre=Laptop
  @GetMapping("/buscar")
  public List<Product> buscar(@RequestParam String nombre) {
    return productService.buscarPorNombre(nombre);
  }

  // Editar producto
  // URL: PUT http://localhost:8080/api/productos/101
  @PutMapping("/{id}")
  public String editar(@PathVariable int id, @RequestBody Product productoNuevo) {
    Product actualizado = productService.actualizarProducto(id, productoNuevo);
    if (actualizado != null) {
      return "✅ Producto " + id + " actualizado correctamente.";
    }
    return "❌ No se encontró el producto con ID " + id;
  }

  // Borrar producto
  // URL: DELETE http://localhost:8080/api/productos/101
  @DeleteMapping("/{id}")
  public String borrar(@PathVariable int id) {
    boolean eliminado = productService.eliminarProducto(id);
    if (eliminado) {
      return "✅ Producto eliminado.";
    }
    return "❌ No se pudo eliminar (ID no existe).";
  }

  // Crear pedido
  // URL: POST http://localhost:8080/api/productos/101/comprar?cantidad=2
  @PostMapping("/{id}/comprar")
  public String comprar(@PathVariable int id, @RequestParam int cantidad) {
    return productService.comprarProducto(id, cantidad);
  }
}