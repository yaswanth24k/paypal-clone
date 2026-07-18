PayPal Clone – Microservices Architecture

A production-inspired PayPal Clone built using Spring Boot Microservices, demonstrating secure authentication, distributed system design, event-driven communication, and scalable backend architecture.

This project focuses on backend engineering concepts such as JWT authentication, REST APIs, API Gateway, asynchronous messaging with Kafka, Docker containerization, and independent microservices.

🚀 Features
🔐 JWT Authentication & Authorization
👤 User Registration & Login
💳 Wallet Management
💸 Money Transfer Between Users
📩 Notification Service
🎁 Reward Service
📦 Event-Driven Architecture using Apache Kafka
🌐 RESTful APIs
🐳 Dockerized Services
🗄️ Independent Databases for Microservices
🔄 Service-to-Service Communication
🧩 Microservices Architecture
🏗️ Architecture
                         Client
                           │
                           │ REST API
                           ▼
                  ┌─────────────────┐
                  │   API Gateway   │
                  └─────────────────┘
                           │
      ┌────────────────────┼────────────────────┐
      ▼                    ▼                    ▼
┌─────────────┐     ┌──────────────┐     ┌──────────────┐
│ User Service│     │ Wallet Service│     │Transaction Svc│
└─────────────┘     └──────────────┘     └──────────────┘
       │                    │                    │
       │                    │                    │
       ▼                    ▼                    ▼
     MySQL               MySQL               MySQL
                                                │
                                                │ Publish Event
                                                ▼
                                         Apache Kafka
                                                │
                         ┌──────────────────────┴──────────────────────┐
                         ▼                                             ▼
               ┌──────────────────┐                         ┌─────────────────┐
               │Notification Svc  │                         │ Reward Service  │
               └──────────────────┘                         └─────────────────┘
                         │                                             │
                      MySQL                                         MySQL
🔄 Application Workflow
1. User Registration
Client
   │
   ▼
User Service
   │
   ▼
Create User
   │
   ▼
Create Wallet
2. User Login
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
3. Money Transfer
Client
   │
JWT Token
   │
   ▼
API Gateway
   │
Authenticate Request
   │
   ▼
Transaction Service
   │
Debit Sender
Credit Receiver
Save Transaction
   │
Publish Kafka Event
   │
   ▼
────────────────────────────────────
│                                  │
▼                                  ▼
Notification Service         Reward Service
Send Notification          Add Reward Points
📁 Project Structure
paypal-clone/
│
├── api-gateway/
├── user-service/
├── wallet-service/
├── transaction-service/
├── reward-service/
├── notification-service/
│
├── docker-compose.yml
└── README.md
🛠️ Tech Stack
Backend
Java 17
Spring Boot
Spring MVC
Spring Data JPA
Spring Security
JWT
Maven
Microservices
REST APIs
Spring Cloud Gateway
Apache Kafka
Database
MySQL
DevOps
Docker
Docker Compose
Tools
IntelliJ IDEA
Git
GitHub
Postman
⚙️ Services
Service	Responsibility
User Service	Registration, Login, JWT Authentication
Wallet Service	Wallet Creation & Balance Management
Transaction Service	Money Transfers
Notification Service	Transaction Notifications
Reward Service	Reward Points
API Gateway	Centralized Routing & Authentication
📡 REST Communication
API Gateway
      │
      ├────────► User Service
      │
      ├────────► Wallet Service
      │
      └────────► Transaction Service
📨 Event Driven Communication
Transaction Service
        │
        │
Publish Event
        │
        ▼
Apache Kafka
        │
        ├────────► Notification Service
        │
        └────────► Reward Service
🐳 Running the Project
1. Clone Repository
git clone https://github.com/yaswanth24k/paypal-clone.git
2. Navigate
cd paypal-clone
3. Configure MySQL

Create separate databases:

user_db
wallet_db
transaction_db
reward_db
notification_db

Update each service's application.yml with your MySQL credentials.

4. Start Kafka
docker compose up -d

This starts:

Kafka
Zookeeper
5. Start Services

Run services in the following order:

1. User Service
2. Wallet Service
3. Transaction Service
4. Reward Service
5. Notification Service
6. API Gateway
🔑 Authentication

Login using:

POST /auth/login

Receive:

{
  "token": "<JWT_TOKEN>"
}

Use it in every protected request:

Authorization: Bearer <JWT_TOKEN>
📮 Example Transaction Request
POST /api/transactions/create
{
  "senderId": 1,
  "receiverId": 2,
  "amount": 250.0
}

Example Response

{
  "id": 1,
  "senderId": 1,
  "receiverId": 2,
  "amount": 250.0,
  "status": "SUCCESS"
}
🎯 Learning Objectives

This project demonstrates practical implementation of:

Microservices Architecture
JWT Authentication
Secure REST API Development
Apache Kafka Event Streaming
Asynchronous Communication
Docker Containerization
API Gateway
Distributed System Design
Service Isolation
Database per Service Pattern
🚧 Future Improvements
Redis-based Rate Limiting
Eureka Service Discovery
Circuit Breaker (Resilience4j)
Distributed Tracing
Centralized Logging
Kubernetes Deployment
CI/CD Pipeline with GitHub Actions
Monitoring using Prometheus & Grafana
OpenAPI / Swagger Documentation
👨‍💻 Author

Sai Yaswanth

GitHub: https://github.com/yaswanth24k
LinkedIn: (Add your LinkedIn profile URL here)
⭐ If you found this project interesting, consider giving it a star!
