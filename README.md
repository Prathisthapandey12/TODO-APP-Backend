# Todo List API Application

A lightweight RESTful backend web service built using **Dropwizard**, **JDBI3**, and **Guice** dependency injection, utilizing an in-memory **H2 database**.

---

## 🛠️ Tech Stack & Libraries
* **Dropwizard** - High-performance REST Java framework (Jetty & Jersey under the hood).
* **Guicey / Guice** - Lightweight dependency injection container to handle object lifecycles.
* **JDBI 3** - SQL convenience library to map database queries seamlessly to Java interfaces.
* **Jackson** - Handles swift JSON serialization/deserialization.

---

## 🏗️ Core API Endpoints

All application requests use the base path: `http://localhost:8080/todos`

| HTTP Method | Endpoint | Description | Request Body | Success Response |
| :--- | :--- | :--- | :--- | :--- |
| **GET** | `/todos` | Fetch all tasks | *None* | `200 OK` (JSON Array) |
| **POST** | `/todos` | Create a new task | JSON object | `200 OK` (Created Object) |
| **POST** | `/todos/{id}/toggle` | Toggle `completed` status | *None* | `200 OK` (Updated Object) |
| **DELETE** | `/todos/{id}` | Delete a specific task | *None* | `204 No Content` |

---

## 🚀 Getting Started

### Prerequisites
Make sure you have the following installed on your machine:
* Java Development Kit (JDK 11 or higher)
* Apache Maven

### 1. Compilation
Before launching the server, compile your source files and build the runnable `.jar` bundle by running:
```bash
mvn clean package
