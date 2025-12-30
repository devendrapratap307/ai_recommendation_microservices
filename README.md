# AI Recommendation Microservices

A production-style **AI-powered microservices application** built using **Java and Spring Boot**, designed to demonstrate real-world microservice communication, event-driven architecture, and AI-based recommendations.

---

## 🚀 Overview

This project simulates a **Recommendation platform** where user activities are tracked and processed asynchronously to generate **AI-driven fitness recommendations**.

The system is built using **microservices architecture** with **Kafka for event streaming**, **Spring WebClient for service-to-service communication**, and **Gemini AI API** for intelligent recommendations.

---

## 🧩 Microservices Architecture

The application consists of **three core microservices**:

### 1️⃣ User Service
- Manages user-related operations
- Acts as an entry point for user interactions
- Communicates with other services using REST APIs

### 2️⃣ Activity Service
- Records fitness activities performed by users (e.g. workouts, steps, exercises)
- Publishes activity events to **Kafka topics** whenever a new activity is created
- Uses **PostgreSQL** as the primary datastore

### 3️⃣ AI Recommendation Service
- Consumes activity events from **Kafka**
- Uses **Gemini AI API** to analyze activity data
- Generates personalized fitness recommendations
- Stores recommendations in **MongoDB**

---

## 🔁 Event-Driven Flow

```text
User performs activity
        ↓
Activity Service saves activity
        ↓
Kafka event produced
        ↓
AI Recommendation Service consumes event
        ↓
Gemini AI generates recommendation
        ↓
Recommendation stored in MongoDB
```

This asynchronous flow ensures:
- Loose coupling between services
- High scalability
- Fault tolerance

---

## 🛠️ Tech Stack

### Backend
- Java 21
- Spring Boot 3.5.9
- Spring WebClient
- Spring Data JPA
- Spring Data MongoDB

### Databases
- PostgreSQL (User & Activity data)
- MongoDB (AI Recommendations)

### Messaging
- Apache Kafka

### AI Integration
- Gemini AI API

### Dev & Infra
- REST APIs
- Microservices Architecture
- Event-driven design

---

## 📂 Project Structure (High Level)

```text
AI_Microservices/
├── user-service/
├── activity-service/
├── ai-recommendation-service/
├── kafka/
└── README.md
```

---

## 🌐 Inter-Service Communication

- **Synchronous**: REST communication using `Spring WebClient`
- **Asynchronous**: Kafka for activity events and AI processing

---

## ✅ Key Features

- Microservices-based architecture
- Event-driven processing using Kafka
- AI-powered recommendations using Gemini
- Polyglot persistence (Postgres + MongoDB)
- Non-blocking inter-service communication
- Scalable and production-ready design

---

## 🎯 Use Cases

- Track user fitness activities
- Generate intelligent recommendations
- Demonstrate real-world microservice patterns
- Learn Kafka-based async communication
- Integrate AI into backend systems

---

## 🧠 Future Enhancements

- API Gateway integration
- Authentication & Authorization (Keycloak / OAuth2)
- Docker & Kubernetes deployment
- Monitoring with Prometheus & Grafana
- Retry & DLQ support for Kafka

---

## 📌 How to Run (High Level)

1. Start Kafka & Zookeeper
2. Start PostgreSQL & MongoDB
3. Run services in order:
    - user-service
    - activity-service
    - ai-recommendation-service
4. Trigger user activity APIs

---

## 📄 License

This project is for **learning and demonstration purposes**.

---

## 👨‍💻 Author

**Devendra Pratap**  
Software Developer | Java | Spring Boot | Microservices | Kafka | AI Integration

