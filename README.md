#  Login & Registration System (Java Web Application)

A full-stack Java web application built using Servlets, JSP, and JDBC.  
The system allows users to register and log in securely using a MySQL database with proper validation and database connectivity.

---

##  Features

- User Registration
- User Login Authentication
- Server-side validation
- JDBC-based database connectivity
- MVC architecture (Servlet + JSP)
- Error handling with user-friendly messages

---

##  Tech Stack

| Technology | Purpose |
|------------|----------|
| Java | Backend logic |
| Servlets | Request handling |
| JSP | View layer |
| JDBC | Database connection |
| MySQL | Database |
| Apache Tomcat | Web server |
| HTML/CSS | Frontend |

---

##  Project Structure

```
LoginRegister/
│
├── src/main/java/com/controller/
│   ├── DBConnection.java
│   ├── LoginServlet.java
│   └── RegisterServlet.java
│
├── src/main/webapp/
│   ├── login.jsp
│   ├── register.jsp
│   ├── css/style.css
│   └── WEB-INF/web.xml
│
└── db.properties (ignored for security)
```

---

## ⚙️ How to Run the Project

### 1️. Prerequisites

- Java 8 or higher
- Apache Tomcat
- MySQL Server
- Eclipse IDE (Enterprise Edition recommended)

---

### 2️. Database Setup

Create a database:

```sql
CREATE DATABASE login_system;
```

Create a user table:

```sql
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    contact VARCHAR(100) NOT NULL
);
```

---

### 3. Configure Database Properties

Create `db.properties` inside `src/main/resources`:

```
db.url=jdbc:mysql://localhost:3306/login_system
db.username=root
db.password=your_password
```

> *Note: This file is excluded from GitHub for security reasons.

---

### 4. Deploy on Tomcat

- Import project into Eclipse
- Add Tomcat server
- Run on Server
- Open in browser:

```
http://localhost:8080/LoginRegister
```

---

## Security Notes

- Database credentials are stored in properties file (not committed to GitHub)
- Server-side validation implemented
- Password storage can be improved using hashing (future enhancement)

---

## 📸 Screenshots




---

## Future Improvements

- Password hashing (BCrypt)
- Session management
- Remember me functionality
- Spring Boot migration
- REST API integration

---

## Author

Developed as a Java Web Development project for learning backend architecture and database connectivity.

---

## Why This Project Matters

This project demonstrates:

- Understanding of MVC architecture
- Backend development using Java
- Database integration using JDBC
- Real-world authentication workflow

---

If you found this project useful, consider giving it a ⭐ on GitHub!
