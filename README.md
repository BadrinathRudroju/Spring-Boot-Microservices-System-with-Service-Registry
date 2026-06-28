# Spring Boot Microservices System with Service Registry

A simple, opinionated example of a Java Spring Boot microservices system that demonstrates service discovery with a service registry and common microservice patterns (configuration, health checks, inter-service communication, and observability).

## Key ideas
- Modular microservices implemented with Spring Boot
- Centralized Service Registry (service discovery) so services can find each other dynamically
- Typical supporting components: configuration, API gateway, and one or more domain services
- Container-friendly (can be run locally or in Docker)

## Tech stack
- Java (Spring Boot, Spring Cloud)
- Build: Maven (or Gradle)
- Service discovery: Service Registry (e.g., Eureka / Consul)
- Optional: Docker / Docker Compose for local orchestration

## Prerequisites
- Java 11+ (JDK)
- Maven 3.6+ (or Gradle)
- Docker & Docker Compose (optional, for containerized runs)

## Quickstart (local)
1. Build all services:
   ```bash
   mvn -T1C clean package
   ```
2. Start the Service Registry first (so other services can register):
   ```bash
   # from the discovery-service module
   java -jar discovery-service/target/discovery-service-<version>.jar
   ```
3. Start each service (config, gateway, domain services) after the registry:
   ```bash
   java -jar config-service/target/config-service-<version>.jar
   java -jar gateway-service/target/gateway-service-<version>.jar
   java -jar orders-service/target/orders-service-<version>.jar
   java -jar users-service/target/users-service-<version>.jar
   ```
4. Check service registration and health endpoints (e.g., via /actuator/health) and the registry UI.

If a `docker-compose.yml` is provided, you can run the whole stack with:
```bash
docker-compose up --build
```

## Useful endpoints
- Service registry dashboard: http://localhost:8761 (port may vary)
- API Gateway: http://localhost:8080 (routes to downstream services)
- Service actuator/health: http://localhost:<service-port>/actuator/health

## Development tips
- Start the registry first, then configuration/gateway, then domain services.
- Use Spring Cloud Config (if included) for centralized configuration.
- Enable actuator and management endpoints to help with health & metrics.
- Use logging and distributed tracing (Sleuth/OpenTelemetry) for debugging in distributed environments.

## Contributing
Contributions, bug reports and enhancements are welcome. Please open issues or pull requests describing the change and the rationale.


