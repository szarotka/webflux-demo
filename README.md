# WebFlux demo

## API documentation
http://localhost:8080/swagger-ui.html

## 2 ways to define REST services
1. @RestController -> AddPostController
2. Router Functions -> AddPostControllerV2

## DB
What database you want to use? Is asynchronous database access supported in java?

Nosql:
- mongodb
- redis
- cassandra

ADBC (Asynchronous Database Access API) - for Oracle, not ready!!
R2DBC (Reactive Relational Database Connectivity) - as of now, there are three driver implementations:
- PostgreSQL
- H2
- Microsoft SQL Server
