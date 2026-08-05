# 🚚 LogiTrack

Sistema distribuído desenvolvido em arquitetura de microsserviços para gerenciamento de pedidos, entregas e rastreamento logístico.

O projeto foi desenvolvido como trabalho final do curso **Java Backend** da **EBAC**, aplicando tecnologias modernas utilizadas em sistemas corporativos, como microsserviços, Apache Kafka, PostgreSQL, MongoDB, Docker, JWT e Swagger/OpenAPI.

---

# 📌 Objetivo

O LogiTrack simula o fluxo completo de uma empresa de logística.

O sistema permite:

- Autenticação de usuários
- Cadastro de usuários
- Criação de pedidos
- Gerenciamento de entregas
- Rastreamento de pedidos
- Comunicação assíncrona entre microsserviços utilizando Apache Kafka

---

# 🏗 Arquitetura

O projeto foi dividido em cinco microsserviços independentes.

| Microsserviço | Responsabilidade |
|---------------|------------------|
| Auth Service | Autenticação e geração de JWT |
| User Service | Cadastro e gerenciamento de usuários |
| Order Service | Cadastro de pedidos |
| Delivery Service | Gerenciamento das entregas |
| Tracking Service | Rastreamento das entregas |

---

# 🛠 Tecnologias

- Java 25
- Spring Boot
- Spring Security
- Spring Data JPA
- Spring Data MongoDB
- PostgreSQL
- MongoDB
- Apache Kafka
- Docker
- Docker Compose
- LocalStack
- JWT
- Swagger / OpenAPI
- Lombok
- Maven
- JUnit 5
- Mockito

---

# 🗄 Banco de Dados

| Microsserviço | Banco |
|---------------|--------|
| Auth Service | PostgreSQL |
| User Service | PostgreSQL |
| Order Service | PostgreSQL |
| Delivery Service | PostgreSQL |
| Tracking Service | MongoDB |

---

# 🔄 Comunicação entre Microsserviços

```text
                +----------------+
                | Auth Service   |
                +----------------+
                        |
                        |
                +----------------+
                | User Service   |
                +----------------+
                        |
                        |
                +----------------+
                | Order Service  |
                +----------------+
                        |
                Kafka (orders-topic)
                        |
                        ▼
                +-------------------+
                | Delivery Service  |
                +-------------------+
                        |
                Kafka (delivery-topic)
                        |
                        ▼
                +-------------------+
                | Tracking Service  |
                +-------------------+
```

---

# 📂 Estrutura do Projeto

```text
logitrack
│
├── auth-service
├── user-service
├── order-service
├── delivery-service
├── tracking-service
│
├── docker-compose.yml
│
└── README.md
```

---

# 📚 Documentação da API

Todos os microsserviços possuem documentação utilizando Swagger/OpenAPI.

| Serviço | URL |
|----------|-----|
| Auth | http://localhost:8080/swagger-ui/index.html |
| User | http://localhost:8081/swagger-ui/index.html |
| Order | http://localhost:8082/swagger-ui/index.html |
| Delivery | http://localhost:8083/swagger-ui/index.html |
| Tracking | http://localhost:8084/swagger-ui/index.html |

---

# 🧪 Testes

O projeto possui testes unitários utilizando:

- JUnit 5
- Mockito

Os testes cobrem a camada de serviço dos microsserviços.

---

# 🐳 Executando o projeto

## 1. Clonar o repositório

```bash
git clone https://github.com/Limabtw/logitrack.git
```

## 2. Entrar no projeto

```bash
cd logitrack
```

## 3. Subir a infraestrutura

```bash
docker compose up -d
```

## 4. Executar cada microsserviço

Em cada pasta:

```bash
./mvnw spring-boot:run
```

---

# 📈 Funcionalidades

- ✅ Cadastro de usuários
- ✅ Login com JWT
- ✅ CRUD de usuários
- ✅ CRUD de pedidos
- ✅ CRUD de entregas
- ✅ Rastreamento de pedidos
- ✅ Comunicação assíncrona com Kafka
- ✅ Documentação com Swagger
- ✅ Testes unitários
- ✅ Containerização com Docker

---

# 🔗 Links

| Plataforma | Link |
|------------|------|
| GitHub | https://github.com/Limabtw |
| LinkedIn | https://www.linkedin.com/in/gustavolima-ti/ |

---

# 👨‍💻 Autor

**Gustavo Lima**

Desenvolvedor Java Backend.

Projeto desenvolvido como requisito para conclusão do curso **Java Backend** da **EBAC**, demonstrando conhecimentos em arquitetura de microsserviços, mensageria com Apache Kafka, autenticação JWT, bancos SQL e NoSQL, Docker, testes automatizados e documentação de APIs.

---

⭐ Caso este projeto tenha sido útil ou interessante, fique à vontade para deixar uma estrela no repositório.