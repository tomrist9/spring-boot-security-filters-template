#  Spring Boot Security Filters Template

###  Custom Filters + Method-Level Security with Spring Security 6 & Spring Boot 3

This project demonstrates how to **extend and customize Spring Security’s filter chain** to implement fine-grained security logic using `addFilterBefore`, `addFilterAfter`, and `addFilterAt`.  
It also includes **method-level authorization** using annotations like `@PreAuthorize`, `@PostAuthorize`, `@PreFilter`, and `@PostFilter`.

---

##  Features

-  **Custom Filters**
  - Implemented using `OncePerRequestFilter`
  - Added with `addFilterBefore()`, `addFilterAfter()`, and `addFilterAt()`
  - Demonstrates custom authentication and logging filters

-  **Method-Level Security**
  - Secured service methods using:
    - `@PreAuthorize`
    - `@PostAuthorize`
    - `@PreFilter`
    - `@PostFilter`

- ⚙️ **Fine-grained Access Control**
  - Example roles: `ADMIN`, `USER`
  - Role-based endpoint authorization via `@EnableMethodSecurity`

-  **Testing-Friendly Setup**
  - Easily integrable with `MockMvc` for future security testing
  - Stateless filter architecture

---

##  Project Architecture

```bash
spring-boot-security-filters-template

├── src
│ ├── main
│ │ ├── java/com/example/securityfilters
│ │ │ ├── config/ → Security configuration
│ │ │ ├── controller/ → Demo secured REST endpoints
│ │ │ ├── filter/ → Custom filters
│ │ │ ├── service/ → Business logic with @PreAuthorize
│ │ │ └── model/ → Simple DTOs/entities
│ │ └── resources/
│ │ └── application.yml
└── pom.xml


---

## 🧠 Core Concepts Covered

| Concept | Description |
|----------|--------------|
| **Filter Chain** | Ordered chain of filters intercepting HTTP requests before controllers. |
| **addFilterBefore()** | Adds a custom filter before a specific Spring Security filter (e.g., `UsernamePasswordAuthenticationFilter`). |
| **addFilterAfter()** | Adds a custom filter after a specific filter. |
| **addFilterAt()** | Replaces a filter at a specific position. |
| **OncePerRequestFilter** | Ensures the filter executes only once per request. |
| **Method-Level Security** | Uses annotations to restrict access to service-level methods. |

---

## ⚙️ Technologies Used

- **Java 17**
- **Spring Boot 3.3+**
- **Spring Security 6**
- **Lombok**
- **Gradle**
- **Postman** for API testing

---

## 🧰 Example Endpoints

| Endpoint | Method | Access | Description |
|-----------|---------|--------|--------------|
| `/api/public` | GET | Public | Accessible by anyone |
| `/api/user` | GET | USER | Requires authenticated user |
| `/api/admin` | GET | ADMIN | Restricted to admin role |

Example of method-level security in a service class:

```java
@PreAuthorize("hasRole('ADMIN')")
public String getAdminData() {
    return "Admin-only secure data";
}

