# Delivery Service

Microsserviço responsável pelo gerenciamento das entregas.

## Responsabilidades

- Cadastro de entregas
- Atualização do status
- Consumo de eventos do Kafka
- Publicação de eventos para rastreamento

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
deliverydb
```

---

## Eventos

Consome:

```text
orders-topic
```

Publica:

```text
delivery-topic
```

---

## Endpoints

| Método | Endpoint |
|---------|----------|
| GET | /deliveries |
| GET | /deliveries/{id} |
| POST | /deliveries |
| PUT | /deliveries/{id} |
| DELETE | /deliveries/{id} |

---

## Swagger

http://localhost:8083/swagger-ui/index.html

---

## Porta

```text
8083
```