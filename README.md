🛒 Spring Boot MVC Product Management System (with Security)
📌 Overview

This project is a Spring Boot MVC web application for managing products with Spring Security integration.

It implements:

Authentication → verifies user identity
Authorization → restricts access based on roles

Users can perform CRUD operations, but access is controlled using roles like ADMIN and USER.

🛠️ Tech Stack
Java
Spring Boot
Spring MVC
Spring Data JPA (Hibernate)
MySQL
Thymeleaf
Spring Security
Maven
🏗️ Architecture (MVC)
Controller → Handles Requests
Service → Business Logic
Repository → Database Layer
Entity → Table Mapping
View → Thymeleaf UI
Security → Authentication & Authorization
🔐 Security Implementation
✔ Authentication
Users must login using username & password
Passwords are encrypted using BCrypt
✔ Authorization (Role-Based Access)
Feature	Role Required
View Products	USER / ADMIN
Add Product	ADMIN
Update Product	ADMIN
Delete Product	ADMIN
🔑 Roles
ADMIN → Full access (CRUD)
USER → Read-only access
✨ Features

✔ Add new product (ADMIN only)
✔ Update product (ADMIN only)
✔ Delete product (ADMIN only)
✔ View all products (USER & ADMIN)
✔ Login authentication system
✔ Role-based authorization
✔ MVC-based UI using Thymeleaf

📂 Project Structure
com.Aadi
 ├── controller      → Handles web requests
 ├── service         → Business logic
 ├── repository      → JPA repositories
 ├── entity          → Product entity
 ├── security        → Security configuration
 ├── templates       → Thymeleaf pages
 ├── resources       → application.properties
🗄️ Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/productdb
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
🔐 Security Configuration (Concept)
Uses Spring Security
Configured with:
SecurityFilterChain
DaoAuthenticationProvider
UserDetailsService
BCryptPasswordEncoder
🧪 Sample Roles Logic
if(username.equals("admin")) {
    role = "ADMIN";
} else {
    role = "USER";
}
▶️ How to Run
Clone repository:
git clone https://github.com/AadityaMohite/SpringBoot_MVC_Productmanagement-Project.git
Open in IDE
Configure MySQL
Run:
mvn spring-boot:run
Open:
http://localhost:8080/
📸 Screens (Add Later)
Login Page
Product List
Add Product Form
Update Product Page
⚠️ Key Learning Concepts
Authentication vs Authorization
Role-Based Access Control (RBAC)
Spring Security Configuration
MVC Architecture
