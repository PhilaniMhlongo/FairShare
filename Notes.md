# Spring Boot Example

## Configuring Embedded Web Server

Create a application.yml file on resources


Let say we want to a port
```yaml
server:
  port: 8000
```

Now let say you want to build a Spring boot application without a webserver. But you dont want to do it

```yaml
spring:
  main:
    web-application-type: none

```
The defualt is 
```yaml
spring:
  main:
    web-application-type: servlet

```


## Hello Internet

To build a basic hello world
Go to SpringBootExampleApplication 

create a function called greet
but and annotation @GetMapping()
Also remember that have you have to add @RestController so that each method you add is expose as Rest Endpoints

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @GetMapping("/")
    public String greet() {
        return "Hello";
    }
}
```

# Last Vidoe is 23.So watch 23