# User Service

Microsserviço responsável pelo gerenciamento dos usuários cadastrados no sistema.

## Responsabilidades

- Cadastro de usuários
- Consulta
- Atualização
- Exclusão

---

## Tecnologias

- Java 25
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Swagger/OpenAPI

---

## Banco

```text
userdb
```

---

## Endpoints

| Método | Endpoint |
|---------|----------|
| GET | /users |
| GET | /users/{id} |
| POST | /users |
| PUT | /users/{id} |
| DELETE | /users/{id} |

---

## Swagger

http://localhost:8081/swagger-ui/index.html

---

## Porta

```text
8081
```