# Clínica Veterinaria - Spring Boot

API REST para gestionar los dueños y las mascotas de una clínica veterinaria. Se levanta con un solo comando usando Docker (aplicación + base de datos MySQL).

## Tecnologías
- Java 17
- Spring Boot (Spring Web, Spring Data JPA)
- MySQL 8
- Docker y Docker Compose (Dockerfile multi-stage)
- Maven

## Cómo arrancarla
Solo necesitas tener [Docker Desktop](https://www.docker.com/products/docker-desktop/) abierto.

```
git clone https://github.com/diegogonzalo017/clinica-veterinaria-springboot.git
cd clinica-veterinaria-springboot
docker compose up --build
```

La primera vez tarda unos minutos porque Maven descarga las dependencias dentro de Docker. Cuando termine:
- API: `http://localhost:8080`
- MySQL (desde tu equipo): `localhost:3307`

Prueba rápida: abre `http://localhost:8080/traer/mascotas`. Debe responder `[]`.

Para pararla: `docker compose down`.

> Las credenciales de la base de datos (`root` / `1234`) son de desarrollo local.

## Modelo de datos
- Un **dueño** puede tener **varias mascotas**.
- Cada **mascota** pertenece a **un solo dueño** (o a ninguno).

La relación está implementada con `@ManyToOne` en la entidad `Mascota`, que guarda la clave foránea `id_dueño`. Es una relación unidireccional, lo que evita problemas de serialización JSON en bucle.

## Endpoints

### Dueños
| Método | Ruta | Qué hace |
|--------|------|----------|
| GET | `/traer/dueños` | Lista todos los dueños |
| GET | `/traer/dueño/{id_dueño}` | Busca un dueño por id |
| POST | `/crear/dueño` | Crea un dueño |
| PUT | `/editar/dueño/{id_dueño}` | Edita un dueño |
| DELETE | `/eliminar/dueño/{id_dueño}` | Elimina un dueño |

### Mascotas
| Método | Ruta | Qué hace |
|--------|------|----------|
| GET | `/traer/mascotas` | Lista todas las mascotas |
| GET |