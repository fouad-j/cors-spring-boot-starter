# Cors spring boot starter

> This starter allows cors for sub domains

> You can use this starter till v5.2 of spring-web

> /!\ NB: The last version of spring 5.3 released 27/10/2020 contains this feature

### How to use

* Deploy it in your repository manager like Nexus

* Add dependency:

```xml
    <dependency>
        <groupId>com.jfouad.spring</groupId>
        <artifactId>cors-spring-boot-starter</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
```

* Add configuration

```yml
spring:
  cors:
    enable: true
    allowedOrigins:
      - *.company1.com
      - *.company2.com
    apiPaths:
      - /rest/v1/articles
      - /rest/v1/articles/{articleId}
```
