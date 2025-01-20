# Matches and Match Odds REST API

This project is a Spring Boot application designed to manage Matches and Match Odds. The application uses Spring Data JPA for database interaction, PostgreSQL as the database, and is containerized using Docker.

## Prerequisites

Before you begin, make sure you have the following installed on your machine:

**Docker**: To build and run the application inside a container.

**Maven**: To build the application (if not using Docker).

## Project Structure

**src/**: Contains the source code of the application.

**pom.xml**: Maven configuration file for building the application.

**Dockerfile**: The Docker configuration file to build and run the application in a container.

**docker-compose.yml**: Docker Compose configuration for orchestrating the application and PostgreSQL container.

**application.properties**: Contains database connection properties and Spring Boot settings.

## Build and Run the Application
1. **Clone the Repository**

```bash
git clone https://github.com/your-username/match-odds-api.git
cd match-odds-api
```

2. **Build and Run Using Docker**:
```bash
This application is packaged in a Docker container, and you can run both the Spring Boot application and PostgreSQL using Docker Compose.
```

3. **Build Docker images**:
```bash
First, build the Docker images for the PostgreSQL database and the Spring Boot application.
```

```bash
docker-compose up --build
```

**Start the containers**: Docker Compose will automatically start the containers.

```bash
Your application will be available at http://localhost:8080,
and the PostgreSQL database will be accessible at localhost:5432.
```

## API Documentation
You can view the API documentation (Swagger UI) at the following URL:

```bash
http://localhost:8080/swagger-ui/
```
