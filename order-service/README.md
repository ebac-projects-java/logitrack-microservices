# Order Service

Microsserviço responsável pelo gerenciamento dos pedidos.

## Responsabilidades

- Cadastro de pedidos
- Consulta de pedidos
- Publicação de eventos no Apache Kafka

---

## Tecnologias

- Java 25
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Apache Kafka
- Swagger/OpenAPI

---

## Banco

```text
orderdb
```

---

## Evento publicado

```text
orders-topic
```

---

## Endpoints

| Método | Endpoint |
|---------|----------|
| GET | /orders |
| GET | /orders/{id} |
| POST | /orders |

---

## Swagger

http://localhost:8082/swagger-ui/index.html

---

## Porta

```text
8082
```