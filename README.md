# 💸 PayPal Clone – Spring Boot Microservices

A production-inspired **PayPal Clone** built using **Spring Boot Microservices** that demonstrates secure authentication, distributed system design, event-driven architecture, and scalable backend development.

The project is designed to showcase real-world backend engineering concepts such as **JWT Authentication, REST APIs, API Gateway, Apache Kafka, Docker, Microservices, and Independent Databases**.

---

# 🚀 Features

- 🔐 User Registration & Login
- 🔑 JWT Authentication & Authorization
- 💳 Wallet Management
- 💸 Money Transfer Between Users
- 📩 Notification Service
- 🎁 Reward Service
- 🌐 API Gateway for centralized routing
- 📦 Event-Driven Communication using Apache Kafka
- 🔄 RESTful Microservices
- 🐳 Docker & Docker Compose Support
- 🗄️ Database Per Service Pattern
- 🧩 Independent Deployable Microservices

---

# 🏗️ System Architecture

```text
                                 Client
                                    │
                                    │
                              HTTP Requests
                                    │
                                    ▼
                          ┌──────────────────┐
                          │   API Gateway    │
                          └──────────────────┘
                                    │
        ┌───────────────┬────────────┴───────────────┬───────────────┐
        ▼               ▼                            ▼               ▼
 ┌─────────────┐ ┌──────────────┐          ┌────────────────┐ ┌──────────────┐
 │User Service │ │Wallet Service│          │Transaction Svc │ │Notification  │
 └─────────────┘ └──────────────┘          └────────────────┘ └──────────────┘
        │               │                            │
        ▼               ▼                            ▼
     MySQL DB       MySQL DB                    MySQL DB
                                                     │
                                                     │ Publish Event
                                                     ▼
                                            ┌────────────────┐
                                            │ Apache Kafka   │
                                            └────────────────┘
                                                     │
                                  ┌──────────────────┴──────────────────┐
                                  ▼                                     ▼
                         ┌─────────────────┐                  ┌────────────────┐
                         │Reward Service   │                  │Notification Svc│
                         └─────────────────┘                  └────────────────┘
                                  │                                     │
                               MySQL DB                             MySQL DB
```

---

# 🔄 Workflow

## User Registration

```
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

## User Login

```
Client
   │
   ▼
User Service
   │
Validate Credentials
   │
Generate JWT
   │
Return Token
```

---

## Money Transfer

```
Client
   │
Bearer Token
   │
   ▼
API Gateway
   │
JWT Authentication
   │
   ▼
Transaction Service
   │
Debit Sender Wallet
Credit Receiver Wallet
Store Transaction
   │
Publish Kafka Event
   │
   ▼
Apache Kafka
   │
   ├────────► Notification Service
   │            Send Notification
   │
   └────────► Reward Service
                Add Reward Points
```

---

# 📁 Project Structure

```
paypal-clone
│
├── api-gateway
├── user-service
├── wallet-service
├── transaction-service
├── reward-service
├── notification-service
│
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

# ⚙️ Tech Stack

## Backend

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- JWT
- Maven

## Microservices

- Spring Cloud Gateway
- REST APIs
- Apache Kafka

## Database

- MySQL

## DevOps

- Docker
- Docker Compose

## Tools

- IntelliJ IDEA
- Git
- GitHub
- Postman

---

# 📦 Microservices

| Service | Responsibility |
|----------|----------------|
| User Service | User Registration, Login, JWT Generation |
| Wallet Service | Wallet Creation & Balance Management |
| Transaction Service | Money Transfer Between Users |
| Notification Service | Sends Notifications using Kafka Events |
| Reward Service | Rewards Users after Successful Transactions |
| API Gateway | Centralized Routing & Authentication |

---

# 🌐 REST Communication

```
API Gateway
      │
      ├────────► User Service
      │
      ├────────► Wallet Service
      │
      └────────► Transaction Service
```

---

# 📩 Event Driven Communication

```
Transaction Service
        │
        │ Publish Event
        ▼
   Apache Kafka
        │
        ├────────► Notification Service
        │
        └────────► Reward Service
```

---

# 🔐 Authentication Flow

```
Client
   │
Login
   │
   ▼
User Service
   │
Generate JWT
   │
Return Token
   │
   ▼
Client stores JWT
   │
Every Request
   │
Authorization: Bearer <TOKEN>
   │
   ▼
API Gateway
   │
Validate JWT
   │
Forward Request
```

---

# 🐳 Running the Project

## 1. Clone Repository

```bash
git clone https://github.com/yaswanth24k/paypal-clone.git
```

---

## 2. Navigate

```bash
cd paypal-clone
```

---

## 3. Configure MySQL

Create the following databases:

```
user_db
wallet_db
transaction_db
reward_db
notification_db
```

Update database credentials inside every service's `application.yml`.

---

## 4. Start Kafka & Zookeeper

```bash
docker compose up -d
```

---

## 5. Start Microservices

Run the services in the following order:

```
1. User Service
2. Wallet Service
3. Transaction Service
4. Reward Service
5. Notification Service
6. API Gateway
```

---

# 📮 API Example

## Register

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

Use JWT for protected APIs

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

# 🎯 Design Patterns Used

- Microservices Architecture
- Database per Service Pattern
- Event-Driven Architecture
- API Gateway Pattern
- DTO Pattern
- Repository Pattern
- Service Layer Pattern
- Dependency Injection
- JWT-Based Authentication

---

# 📚 Concepts Demonstrated

- Spring Boot Microservices
- REST API Development
- Spring Security
- JWT Authentication
- Apache Kafka
- Asynchronous Communication
- Docker
- Docker Compose
- API Gateway
- Service Isolation
- Database Per Service
- Event Publishing & Consumption
- Backend System Design

---

# 🚀 Future Enhancements

- Redis-based Rate Limiting
- Eureka Service Discovery
- Circuit Breaker (Resilience4j)
- Distributed Tracing
- Centralized Logging
- Kubernetes Deployment
- CI/CD using GitHub Actions
- Prometheus & Grafana Monitoring
- OpenAPI / Swagger Documentation

---

# 👨‍💻 Author

**Sai Yaswanth**

- GitHub: https://github.com/yaswanth24k
- LinkedIn: https://www.linkedin.com/in/<your-profile>

---

## ⭐ If you found this project useful, consider giving it a Star!
