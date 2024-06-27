![JDBCTemplate](JBDC/JDBCTemplate.png)

To install JDBC template
go to pom.xml
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jdbc</artifactId>
</dependency>
```
to open postgress in docker
```shell
docker exec  -it postgres bash
```
Once the postgres is open.OPen the database
```shell
psql -U philani
```
```shell
\l
```
to drop a table
```shell
drop database customer;
#This fail because the database customer is being used by other users
```

# Database Migration
- Flyway
- Liquibase

## Flyway
```xml


<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
```

Under resource create a new directory
and under db create Migration

