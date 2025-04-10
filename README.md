# 🛡️ Servicio de Autenticación con Spring Boot

Proyecto de autenticación desarrollado como parte de una arquitectura de microservicios, implementando seguridad con JWT

---

## 🔧 Tecnologías utilizadas

### Backend (Java - Spring Boot)
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- BCrypt (hash de contraseñas)
- CORS Configuration
- Maven

---

## ✨ Funcionalidades principales

- Registro de usuarios
- Inicio de sesión
- Generación de token JWT
- Validación automática del token en cada petición
- Protección de rutas en el frontend
- Separación de vistas autenticadas y públicas

---

## 🔒 Seguridad

- Filtros personalizados para validar el JWT en cada petición
- Cifrado seguro de contraseñas con BCrypt
- 
---

## 🧠 Arquitectura y futuro

Este proyecto está preparado para integrarse con otros microservicios desarrollados en Go y FastAPI. El servicio de autenticación será responsable de validar las peticiones entrantes usando JWT.

---
