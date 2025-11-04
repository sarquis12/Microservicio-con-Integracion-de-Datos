# Spring Boot API - Microservicio con Integración de Datos

API REST desarrollada en Spring Boot 3.4.2 con Java 21 que implementa un microservicio para gestión de usuarios e integración de datos climáticos externos.

## 🚀 Características

- **Gestión de Usuarios**: CRUD completo con validación
- **Integración de Datos Climáticos**: Consumo de API externa para datos meteorológicos
- **Arquitectura de Microservicios**: Uso de Apache Camel para integración
- **Base de Datos**: SQL Server con migraciones Flyway
- **API REST**: Endpoints documentados con Swagger/OpenAPI
- **Cliente HTTP**: Retrofit2 para consumo de APIs externas

## 🛠️ Tecnologías

- **Java 21**
- **Spring Boot 3.4.2**
  - Spring Data JPA
  - Spring Web
  - Spring Validation
- **Apache Camel 4.9.0** - Integración y orquestación
- **SQL Server** - Base de datos
- **Flyway** - Migraciones de base de datos
- **Retrofit2** - Cliente HTTP
- **MapStruct** - Mapeo de objetos
- **Lombok** - Reducción de código boilerplate
- **Swagger/OpenAPI** - Documentación de API

## 📋 Requisitos Previos

- Java 21 o superior
- SQL Server (Express o superior)
- Gradle 8.x
- Variables de entorno configuradas (ver sección de Configuración)

## ⚙️ Configuración

### 1. Clonar el repositorio

```bash
git clone <repository-url>
cd springboot-api
```

### 2. Configurar Base de Datos

Crea una base de datos en SQL Server:

```sql
CREATE DATABASE ProyectoSpringV1;
```

### 3. Configurar Variables de Entorno

Crea un archivo `application.yml` en `src/main/resources/` basándote en `application.yml.example`:

```bash
cp src/main/resources/application.yml.example src/main/resources/application.yml
```

Configura las siguientes variables de entorno o edita directamente el archivo:

```yaml
spring:
  datasource:
    url: jdbc:sqlserver://YOUR_SERVER:1433;databaseName=YOUR_DB;trustServerCertificate=true;encrypt=true
    username: YOUR_USERNAME
    password: YOUR_PASSWORD
```

**Variables de entorno disponibles:**
- `DB_URL`: URL de conexión a SQL Server
- `DB_USERNAME`: Usuario de la base de datos
- `DB_PASSWORD`: Contraseña de la base de datos

### 4. Ejecutar Migraciones

Las migraciones de Flyway se ejecutarán automáticamente al iniciar la aplicación.

## 🚀 Ejecución

### Modo Desarrollo

```bash
./gradlew bootRun
```

### Compilar y Ejecutar

```bash
./gradlew build
java -jar build/libs/springboot-api-0.0.1-SNAPSHOT.jar
```

La aplicación estará disponible en: `http://localhost:8081/proyecto`

## 📚 Documentación de API

Una vez iniciada la aplicación, accede a la documentación Swagger en:

```
http://localhost:8081/proyecto/swagger-ui.html
```

`

## 📁 Estructura del Proyecto

```
springboot-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/proyecto/springboot_api/
│   │   │       ├── client/              # Clientes Retrofit
│   │   │       ├── configurations/      # Configuraciones
│   │   │       ├── controllers/         # Controladores REST
│   │   │       ├── models/              # Entidades y DTOs
│   │   │       ├── repositories/        # Repositorios JPA
│   │   │       └── services/            # Lógica de negocio
│   │   └── resources/
│   │       ├── db/migration/            # Scripts Flyway
│   │       ├── application.yml.example  # Plantilla de configuración
│   │       └── application.yml          # Configuración (no versionado)
│   └── test/
├── build.gradle
└── README.md
```


