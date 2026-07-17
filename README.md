\# CyberStore - Backend



\## Descripción



CyberStore es un sistema web de venta de productos tecnológicos.  

Este repositorio contiene el backend desarrollado con Spring Boot, encargado de gestionar la lógica del negocio, la seguridad, la autenticación, las APIs REST y la conexión con la base de datos MySQL.



El backend permite administrar usuarios, productos, categorías, carrito de compras, pedidos, estados de pedido y reportes.



\---



\## Tecnologías utilizadas



\- Java

\- Spring Boot

\- Spring Security

\- JWT

\- Spring Data JPA

\- Hibernate

\- MySQL

\- Maven

\- Railway



\---



\## Arquitectura del backend



El backend está organizado bajo una arquitectura por capas:



```text

Controller

Service

Repository

Entity

DTO

Security

Config



Descripción de capas

Controller: recibe las peticiones HTTP desde Angular.

Service: contiene la lógica de negocio.

Repository: se comunica con la base de datos mediante JPA.

Entity: representa las tablas de la base de datos.

DTO: transporta datos entre frontend y backend.

Security: gestiona autenticación, autorización y JWT.

Config: contiene configuraciones generales del sistema.

Entidades principales

Usuario

Producto

Categoría

Carrito

Pedido

DetallePedido

Endpoints principales

Autenticación

Método	Endpoint	Descripción

POST	/auth/register	Registrar usuario

POST	/auth/login	Iniciar sesión

GET	/auth/test	Probar backend

Productos

Método	Endpoint	Descripción

GET	/productos	Listar productos

GET	/productos/{id}	Buscar producto por ID

POST	/productos	Registrar producto

PUT	/productos/{id}	Actualizar producto

DELETE	/productos/{id}	Eliminar producto

POST	/productos/imagen	Subir imagen de producto

Categorías

Método	Endpoint	Descripción

GET	/categorias	Listar categorías

POST	/categorias	Registrar categoría

PUT	/categorias/{id}	Actualizar categoría

DELETE	/categorias/{id}	Eliminar categoría

Carrito

Método	Endpoint	Descripción

GET	/carrito/usuario/{usuarioId}	Ver carrito del usuario

POST	/carrito	Agregar producto al carrito

PUT	/carrito/{id}	Actualizar cantidad

DELETE	/carrito/{id}	Eliminar producto del carrito

Pedidos

Método	Endpoint	Descripción

GET	/pedidos	Listar pedidos

GET	/pedidos/{id}	Buscar pedido por ID

GET	/pedidos/usuario/{usuarioId}	Listar pedidos por usuario

POST	/pedidos	Registrar pedido

PUT	/pedidos/{id}/estado	Actualizar estado del pedido

DELETE	/pedidos/{id}	Eliminar pedido

Reportes

Método	Endpoint	Descripción

GET	/reportes/resumen	Mostrar resumen del sistema

Estados del pedido



El sistema utiliza los siguientes estados:



PENDIENTE

CONFIRMADO

EN\_PREPARACION

EN\_CAMINO

ENTREGADO

CANCELADO



Flujo principal:



PENDIENTE → CONFIRMADO → EN\_PREPARACION → EN\_CAMINO → ENTREGADO

Seguridad



El sistema usa autenticación mediante JWT.



Roles implementados:



ADMIN

USER

Permisos principales

El usuario USER puede ver productos, agregar al carrito, generar pedidos y consultar sus compras.

El usuario ADMIN puede gestionar productos, categorías, usuarios, pedidos y reportes.

Base de datos



Base de datos utilizada:



MySQL



En producción, la base de datos se encuentra desplegada en Railway.



Variables de entorno



Para producción se utilizan variables de entorno:



DB\_URL=jdbc:mysql://HOST:PUERTO/BASE\_DATOS

DB\_USERNAME=usuario

DB\_PASSWORD=password

PORT=8080



Archivo de configuración:



src/main/resources/application.properties

Despliegue



El backend fue desplegado en Railway.



URL del backend:



https://tienda-production-856f.up.railway.app



Prueba de funcionamiento:



https://tienda-production-856f.up.railway.app/auth/test



Respuesta esperada:



FUNCIONA



Autor



Proyecto desarrollado por:



Victor Flores

Jade Medina

Marco Leon





Carrera:



Ingeniería de Sistemas e Informática



