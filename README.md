# JournalApp – Secure Backend Application (Spring Boot)

JournalApp is a secure, backend-only journaling application built with **Spring Boot 3.5.9** and **Java 17**. The project focuses on authentication, authorization, performance, and clean backend architecture using modern Spring ecosystem tools.

---

## 🚀 Features

* **JWT-based Authentication & Authorization** using Spring Security
* **Role-based access control** for protected APIs
* **Secure journal management** with CRUD operations
* **MongoDB** integration for flexible NoSQL data storage
* **Redis** integration for caching and performance optimization
* **Email service integration** using Spring Mail
* **Swagger / OpenAPI documentation** for API exploration
* **Clean layered architecture** (Controller, Service, Repository, Security)
* **Unit & integration tests** for core business logic

---

## 🛠️ Tech Stack

* **Java 17**
* **Spring Boot 3.5.9**
* **Spring Web** – REST API development
* **Spring Security** – Authentication & Authorization
* **JWT (jjwt-api, jjwt-impl, jjwt-jackson)** – Stateless security
* **MongoDB** – NoSQL database
* **Redis** – Caching layer
* **Spring Data MongoDB**
* **Spring Mail**
* **Springdoc OpenAPI (Swagger UI)**
* **Lombok**
* **Maven**

---

## 🔐 Authentication Flow

1. User registers or logs in
2. Server validates credentials
3. A **JWT token** is generated and returned
4. Client sends the token in the `Authorization` header
5. Spring Security filters validate the token
6. Access is granted based on user role

---

## 📂 Project Structure

```
com.mishrajee.journalapp
│
├── controller   # REST controllers
├── service      # Business logic
├── repository   # MongoDB repositories
├── model        # Domain models
├── security     # JWT, filters, configs
├── config       # Redis, Swagger configs
└── test         # Unit & integration tests
```

---

## 🧪 Testing

The project includes **unit and integration tests** covering:

* Service layer logic
* Authentication and authorization flows
* Repository interactions

Tests are written using **Spring Boot Test** and executed via Maven.

---

## ▶️ Running the Project

### Prerequisites

* Java 17
* MongoDB
* Redis

### Steps

```bash
mvn clean install
mvn spring-boot:run
```

Swagger UI will be available at:

```
http://localhost:8080/swagger-ui.html
```

---

## 📌 API Documentation

All endpoints are documented using **Swagger / OpenAPI** for easy testing and exploration.

---

## 📁 GitHub Repository

🔗 [https://github.com/Mishrajee03/JournalApp](https://github.com/Mishrajee03/JournalApp)

---

## 👨‍💻 Author

**Hariom Mishra**
Java Backend Developer | Spring Boot

---

## 📄 License

This project is for learning and portfolio purposes.
