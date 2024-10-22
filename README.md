# API de Distritos de Barcelona

### Descripción:
Esta API permite consultar información sobre los distritos de Barcelona, incluidos datos de renta y número de actividades educativas por distrito. Está construida usando Spring WebFlux y documentada con Swagger/OpenAPI.

### Endpoints:

1. **GET `/api/districts/`**
    - **Descripción**: Obtiene una lista de todos los distritos con sus datos de renta.
    - **Respuesta**:
        - **200**: Lista de distritos con sus datos de renta.
        - **404**: No se encontraron distritos.
        - **500**: Error interno del servidor.
```json
[
  {
    "id": 0,
    "name": "string",
    "valor": 0,
    "colorIndex": 0
  }
]
```
2. **GET `/api/districts/infantil`**
   - **Descripción**: Obtiene la lista de distritos con el número total de centros educativos de Infantil y su porcentaje correspondiente.
   - **Respuesta**:
      - **200**: Lista de distritos con el total de centros de Infantil y el porcentaje.
      - **404**: No se encontraron datos para la educación infantil.
      - **500**: Error interno del servidor.
    ```json
    [
      {
        "id": 1,
        "name": "Ciutat Vella",
        "total": 18,
        "percentage": 5.248618784530387
      }
    ]
    ```

3. **GET `/api/districts/primary`**
   - **Descripción**: Obtiene la lista de distritos con el número total de centros educativos de Primaria y su porcentaje correspondiente.
   - **Respuesta**:
      - **200**: Lista de distritos con el total de centros de Primaria y el porcentaje.
      - **404**: No se encontraron datos para la educación primaria.
      - **500**: Error interno del servidor.
    ```json
    [
      {
        "id": 1,
        "name": "Ciutat Vella",
        "total": 18,
        "percentage": 5.389221556886228
      }
    ]
    ```

4. **GET `/api/districts/secondary`**
   - **Descripción**: Obtiene la lista de distritos con el número total de centros educativos de Secundaria y su porcentaje correspondiente.
   - **Respuesta**:
      - **200**: Lista de distritos con el total de centros de Secundaria y el porcentaje.
      - **404**: No se encontraron datos para la educación secundaria.
      - **500**: Error interno del servidor.
    ```json
    [
      {
        "id": 1,
        "name": "Ciutat Vella",
        "total": 14,
        "percentage": 5.957446808510639
      }
    ]
    ```

### Tecnologías:

- **Spring Boot**
- **Base de Datos**: H2 (en memoria) configurada usando `JdbcTemplate`.
- **Swagger**: Documentación automática con `springdoc-openapi`.
- **Spring WebFlux** (programación reactiva)
- **Java 21**

### Documentación de la API

Una vez que la aplicación se esté ejecutando, puede acceder a la documentación de Swagger en:

[https://hackatonitacademy-4eb658690555.herokuapp.com/webjars/swagger-ui/index.html](https://hackatonitacademy-4eb658690555.herokuapp.com/webjars/swagger-ui/index.html)
