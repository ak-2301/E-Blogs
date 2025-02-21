# E-Blogs

## 📌 Overview
E-Blogs is a blogging application built using **Spring Boot** and **PostgreSQL** that allows users to create, read, update, and delete blog posts. The application follows a well-structured folder hierarchy, including entity, services, payload, repository, and controller layers.

## 🚀 Features
- 📝 **CRUD Operations**: Users can create, update, delete, and read blog posts.
- 🔍 **Search & Filter**: Retrieve posts based on various criteria.
- 📦 **Structured Codebase**: Implements a clean architecture with service, repository, and controller layers.
- 🔐 **Validation & Security**: Uses validation annotations for data integrity.
- 🗄 **Database**: Integrated with PostgreSQL.
- 🔄 **DTOs & Mappers**: Uses Data Transfer Objects (DTOs) for efficient data handling.

## 🏗 Project Structure
```
E-Blogs/
│── src/main/java/com/example/eblogs
│   ├── entity/        # Contains all entity classes
│   ├── repository/    # Handles database interactions
│   ├── service/       # Business logic layer
│   ├── controller/    # REST API endpoints
│   ├── payload/       # DTOs and request/response models
│   ├── config/        # Application configurations
│── src/main/resources
│   ├── application.properties  # Database and app configurations
│── pom.xml  # Maven dependencies
│── README.md  # Project documentation
```

## 🛠 Tech Stack
- **Backend**: Java, Spring Boot
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **API Documentation**: Swagger (if implemented)

## 🚀 Getting Started
### Prerequisites
- Java 17+
- Maven 3+
- PostgreSQL

### Installation & Setup
1. **Clone the Repository**
   ```sh
   git clone https://github.com/ak-2301/E-Blogs.git
   cd E-Blogs
   ```
2. **Configure Database**
   - Update `application.properties` with PostgreSQL credentials.
3. **Build & Run**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
4. **Access the API**
   - The API will be available at `http://localhost:8080`
   - If Swagger is enabled, visit `http://localhost:8080/swagger-ui.html`

## 🤝 Contributing
Contributions are welcome! Feel free to fork the repository and submit pull requests.

## 📜 License
This project is licensed under the **MIT License**.

## 📧 Contact
For any queries or suggestions, feel free to reach out to **[Ankit Kansal](https://github.com/ak-2301)**.

---
Happy Coding! 🚀

