# WebFlux demo

## API documentation
http://localhost:8080/swagger-ui.html

## 2 ways to define REST services
1. @RestController -> AddUserController
2. Router Functions -> AddUserControllerV2

## DB
What database you want to use? Is asynchronous database access supported in java?

Nosql:
- mongodb
- redis
- cassandra

R2DBC (Reactive Relational Database Connectivity) - as of now, there are driver implementations:
- H2 (io.r2dbc:r2dbc-h2)
- MariaDB (org.mariadb:r2dbc-mariadb)
- Microsoft SQL Server (io.r2dbc:r2dbc-mssql)
- MySQL (dev.miku:r2dbc-mysql)
- jasync-sql MySQL (com.github.jasync-sql:jasync-r2dbc-mysql)
- Postgres (io.r2dbc:r2dbc-postgresql)
- Oracle (com.oracle.database.r2dbc:oracle-r2dbc)
(https://spring.io/projects/spring-data-r2dbc)

@Transactional is also supported from some time
