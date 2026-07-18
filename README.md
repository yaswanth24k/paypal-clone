# 💸 PayPal Clone – Spring Boot Microservices

A production-inspired **PayPal Clone** built using **Spring Boot Microservices** that demonstrates secure authentication, distributed system design, event-driven architecture, API Gateway routing, Redis-backed rate limiting, and scalable backend development.

This project showcases real-world backend engineering concepts including **Spring Boot, JWT Authentication, Spring Cloud Gateway, Redis, Apache Kafka, Docker, REST APIs, and Microservices Architecture**.

---

## 🚀 Features

- 🔐 JWT Authentication & Authorization
- 👤 User Registration & Login
- 💳 Wallet Creation & Management
- 💸 Secure Money Transfer Between Users
- 🎁 Reward Service
- 🔔 Notification Service
- 🌐 Spring Cloud API Gateway
- 🚦 Redis-based Rate Limiting
- 📦 Event-Driven Communication using Apache Kafka
- 🗄️ Database Per Service Pattern
- 🐳 Docker & Docker Compose
- 🔄 RESTful Microservices

---

# 🏗️ Architecture

```text
                                      Client
                                         │
                                         │ HTTP Requests
                                         ▼
                         ┌─────────────────────────────────┐
                         │          API Gateway            │
                         │  JWT Authentication             │
                         │  Redis Rate Limiting            │
                         └─────────────────────────────────┘
                                         │
          ┌──────────────────────────────┼──────────────────────────────┐
          ▼                              ▼                              ▼
 ┌─────────────────┐           ┌──────────────────┐          ┌────────────────────┐
 │  User Service   │           │ Wallet Service   │          │ Transaction Service│
 └─────────────────┘           └──────────────────┘          └────────────────────┘
          │                              │                              │
          ▼                              ▼                              ▼
      MySQL DB                       MySQL DB                      MySQL DB
                                                                     │
                                                                     │ Publish Event
                                                                     ▼
                                                            ┌─────────────────┐
                                                            │  Apache Kafka   │
                                                            └─────────────────┘
                                                                     │
                                         ┌───────────────────────────┴───────────────────────────┐
                                         ▼                                                       ▼
                              ┌────────────────────┐                                  ┌───────────────────┐
                              │ Notification Svc  │                                  │  Reward Service   │
                              └────────────────────┘                                  └───────────────────┘
                                         │                                                       │
                                         ▼                                                       ▼
                                     MySQL DB                                               MySQL DB
```

---

# 🔄 Application Workflow

## 1️⃣ User Registration

```text
Client
   │
   ▼
User Service
   │
Create User
   │
Create Wallet
   │
Return Success
```

---

## 2️⃣ User Login

```text
Client
   │
   ▼
User Service
   │
Validate Credentials
   │
Generate JWT
   │
Return JWT Token
```

---

## 3️⃣ Money Transfer

```text
Client
   │
Bearer Token
   │
   ▼
API Gateway
   │
JWT Validation
Redis Rate Limiting
   │
   ▼
Transaction Service
   │
Debit Sender Wallet
Credit Receiver Wallet
Save Transaction
   │
Publish Event
   ▼
Apache Kafka
   │
   ├────────► Notification Service
   │              │
   │              └── Send Notification
   │
   └────────► Reward Service
                  │
                  └── Add Reward Points
```

---

# 📂 Project Structure

```text
paypal-clone
│
├── api-gateway
├── user-service
├── wallet-service
├── transaction-service
├── notification-service
├── reward-service
│
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

# 🛠️ Tech Stack

## Backend

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Spring MVC
- JWT
- Maven

## Microservices

- Spring Cloud Gateway
- REST APIs
- Apache Kafka

## Database

- MySQL

## Caching

- Redis

## DevOps

- Docker
- Docker Compose

## Tools

- IntelliJ IDEA
- Git
- GitHub
- Postman

---

# 📦 Services

| Service | Responsibility |
|----------|----------------|
| User Service | User Registration, Login, JWT Generation |
| Wallet Service | Wallet Creation & Balance Management |
| Transaction Service | Process Money Transfers |
| Notification Service | Sends Transaction Notifications |
| Reward Service | Rewards Successful Transactions |
| API Gateway | Authentication, Routing & Rate Limiting |

---

# 🔐 Authentication Flow

```text
Client
   │
POST /auth/login
   │
   ▼
User Service
   │
Generate JWT
   │
Return Token
   │
   ▼
Client
   │
Authorization: Bearer <JWT>
   │
   ▼
API Gateway
   │
Validate JWT
Check Redis Rate Limit
   │
Forward Request
```

---

# ⚡ Event-Driven Communication

```text
Transaction Service
          │
          │ Publish Transaction Event
          ▼
     Apache Kafka
          │
          ├────────► Notification Service
          │
          └────────► Reward Service
```

---

# 🚀 Getting Started

## Clone Repository

```bash
git clone https://github.com/yaswanth24k/paypal-clone.git
```

```bash
cd paypal-clone
```

---

## Configure MySQL

Create separate databases:

```
user_db
wallet_db
transaction_db
reward_db
notification_db
```

Update database credentials inside each service's `application.yml`.

---

## Start Docker Services

```bash
docker compose up -d
```

If using Redis separately:

```bash
docker run -d --name redis -p 6379:6379 redis
```

---

## Start Services

Run the following services:

```
1. User Service
2. Wallet Service
3. Transaction Service
4. Notification Service
5. Reward Service
6. API Gateway
```

---

# 📬 API Examples

## Register User

```
POST /auth/signup
```

---

## Login

```
POST /auth/login
```

Response

```json
{
  "token": "<JWT_TOKEN>"
}
```

---

Use JWT for every protected request

```
Authorization: Bearer <JWT_TOKEN>
```

---

## Create Transaction

```
POST /api/transactions/create
```

Request

```json
{
  "senderId": 1,
  "receiverId": 2,
  "amount": 250
}
```

Response

```json
{
  "id": 1,
  "senderId": 1,
  "receiverId": 2,
  "amount": 250,
  "status": "SUCCESS",
  "timestamp": "2026-07-16T21:08:54"
}
```

---

# 🧠 Design Patterns

- Microservices Architecture
- API Gateway Pattern
- Database Per Service Pattern
- Event-Driven Architecture
- Repository Pattern
- DTO Pattern
- Dependency Injection
- JWT Authentication
- Redis Rate Limiting

---

# 📚 Concepts Demonstrated

- Spring Boot Microservices
- REST API Development
- Spring Security
- JWT Authentication
- Spring Cloud Gateway
- Redis
- Rate Limiting
- Apache Kafka
- Event-Driven Communication
- Docker
- Docker Compose
- Distributed Backend Design

---

# 🚀 Future Enhancements

- Eureka Service Discovery
- Resilience4j Circuit Breaker
- Distributed Tracing
- Centralized Logging
- Kubernetes Deployment
- Prometheus & Grafana Monitoring
- CI/CD with GitHub Actions
- OpenAPI / Swagger Documentation

---

# 👨‍💻 Author

**Sai Yaswanth**

- GitHub: https://github.com/yaswanth24k
- LinkedIn: https://www.linkedin.com/in/sai-yaswanth-863a39373/

---

## ⭐ If you found this project helpful, consider giving it a Star!

If you have any suggestions or feedback, feel free to open an issue or connect with me on LinkedIn.
