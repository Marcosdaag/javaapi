# E-Commerce API (Spring Boot)
Video de test  youtube.com/watch?v=LjaD6rOP1jk&feature=youtu.be
Este es un proyecto backend simple para gestionar productos de un comercio electrónico. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar) y simular la compra de productos gestionando el stock.

## 🛠 Tecnologías Utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Base de datos H2
* Maven

## 🚀 Instalación y Ejecución

1.  Clonar el repositorio
2.  Abre el proyecto en el IDE
3.  Ejecuta la clase principal: `ECommerceApplication.java`.
4.  El servidor iniciará en el puerto **8080**.

## 🔗 Endpoints de la API

La URL base es: `http://localhost:8080/api/productos`

### 1. Listar todos los productos
* **Método:** `GET`
* **URL:** `/api/productos`
* **Descripción:** Devuelve la lista completa de productos disponibles.

### 2. Buscar producto por nombre
* **Método:** `GET`
* **URL:** `/api/productos/buscar?nombre={nombre}`
* **Ejemplo:** `/api/productos/buscar?nombre=Laptop`

### 3. Crear un producto
* **Método:** `POST`
* **URL:** `/api/productos`
* **Body (JSON):**
    ```json
    {
      "nombre": "Monitor 24 pulgadas",
      "stock": 50
    }
    ```

### 4. Actualizar un producto
* **Método:** `PUT`
* **URL:** `/api/productos/{id}`
* **Body (JSON):**
    ```json
    {
      "nombre": "Monitor 24 pulgadas (Oled)",
      "stock": 45
    }
    ```

### 5. Eliminar un producto
* **Método:** `DELETE`
* **URL:** `/api/productos/{id}`

### 6. Comprar producto (Reducir Stock)
* **Método:** `POST`
* **URL:** `/api/productos/{id}/comprar?cantidad={cantidad}`
* **Ejemplo:** `/api/productos/1/comprar?cantidad=2`
* **Descripción:** Reduce el stock del producto si hay suficiente disponibilidad.

## 📦 Estructura del Proyecto

* `model`: Entidades de la base de datos (Producto).
* `repository`: Interfaces para acceso a datos (JPA).
* `service`: Lógica de negocio (validaciones, cálculos de stock).
* `controller`: Endpoints REST para recibir las peticiones.
