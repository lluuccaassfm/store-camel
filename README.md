# store-camel

## Descrição
API para exemplificar a utilização dos conceitos Enterprise Integration Patterns(EIP) com Apache Camel no Java.

## Tecnologias utilizadas

- Apache Camel
- Java 17
- Spring Boot
- Spring Web

## Implementação
A API possui três endpoints implementados que realizam integrações com uma API fake https://fakestoreapi.com. <br>
Os três endpoints são: 
- GET http://localhost:8080/camel/api/products -> Consulta todos os produtos da loja;
- GET http://localhost:8080/camel/api/carts/user/{id-user} -> Consulta o catálogo de cada cliente;
- GET http://localhost:8080/camel/api/products-by-user-cart/{id-user}/{id-cart} -> Consulta os produtos que estão no catálogo de um cliente específico;

## Configuração

Na classe de configuração _application.yaml_ adicionar :

> **fake-store-api.uri**: "https://fakestoreapi.com"
> 
> **management.endpoint.camelroutes.enabled**: true
> 
> **management.endpoint.camelroutes.read-only**: true

## Referência

A explicação da implementação do projeto se encontra no blog [Integrando APis com Apache Camel + Java (Spring Boot)](https://www.linkedin.com/pulse/integrando-apis-com-apache-camel-java-spring-boot-lucas-lima-4v7xf) 