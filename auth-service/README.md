# Auth Service

Microsserviço responsável pela autenticação dos usuários do sistema LogiTrack.

## Responsabilidades

- Cadastro de usuários
- Login
- Geração de token JWT
- Controle de acesso utilizando Spring Security

---

## Tecnologias

- Java 25
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- JWT
- Swagger/OpenAPI
- Maven
- Lombok

---

## Banco de Dados

PostgreSQL

Banco utilizado:

```text
authdb
```

---

## Endpoints

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| POST | /auth/register | Cadastro de usuário |
| POST | /auth/login | Login e geração do JWT |

---

## Documentação

Swagger:

http://localhost:8080/swagger-ui/index.html

---

## Executando

```bash
./mvnw spring-boot:run
```

---

## Porta

```text
8080
```