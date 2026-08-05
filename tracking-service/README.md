# Tracking Service

Microsserviço responsável pelo rastreamento das entregas.

## Responsabilidades

- Registrar eventos de rastreamento
- Atualizar localização
- Consultar histórico de rastreamento

---

## Tecnologias

- Java 25
- Spring Boot
- Spring Data MongoDB
- MongoDB
- Swagger/OpenAPI

---

## Banco

```text
trackingdb
```

MongoDB

---

## Evento consumido

```text
delivery-topic
```

---

## Endpoints

| Método | Endpoint |
|---------|----------|
| GET | /tracking |
| GET | /tracking/{id} |
| POST | /tracking |
| PUT | /tracking/{id} |
| DELETE | /tracking/{id} |

---

## Swagger

http://localhost:8084/swagger-ui/index.html

---

## Porta

```text
8084
```