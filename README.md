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
| GET | `/traer/mascota/{id_mascota}` | Busca una mascota por id |
| POST | `/crear/mascota` | Crea una mascota |
| PUT | `/editar/mascota/{id_mascota}` | Edita una mascota |
| DELETE | `/eliminar/mascota/{id_mascota}` | Elimina una mascota |

## Ejemplos (JSON)

Crear un dueño (`POST /crear/dueño`):
```json
{
  "nombre": "Ana",
  "apellido": "López",
  "dni": "12345678A",
  "celular": "600123456"
}
```

Crear una mascota (`POST /crear/mascota`):
```json
{
  "nombre": "Pekos",
  "especie": "perro",
  "raza": "maltés",
  "color": "blanco"
}
```

Asociar la mascota a un dueño (`PUT /editar/mascota/1`). Hay que enviar todos los campos:
```json
{
  "nombre": "Pekos",
  "especie": "perro",
  "raza": "maltés",
  "color": "blanco",
  "dueño": { "id_dueño": 1 }
}
```

## Estructura
```
├── docker-compose.yml        # app + MySQL
└── clinicaVeterinaria/
    ├── Dockerfile            # build en dos etapas (Maven -> JDK)
    ├── pom.xml
    └── src/main/java/.../
        ├── controller/       # DueñoController, MascotaController
        ├── service/
        ├── repository/
        └── model/            # Dueño, Mascota (relación uno a uno)
```

## Autor
Diego García - [LinkedIn](https://www.linkedin.com/in/diego-garcia-80a6a4304/)
