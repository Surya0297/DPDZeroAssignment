# User Registration and Data Storage System

This is a backend system developed using Spring Boot for user registration and data storage. It provides RESTful APIs for user registration, token generation, data storage, retrieval, updating, and deletion.

## Framework and Technologies

- **Spring Boot**: This project is built using the Spring Boot framework, which simplifies the development of Java applications.

- **Hibernate**: Hibernate is used for database mapping and object-relational mapping (ORM).

- **MySQL**: MySQL is used as the database to store user and data information.

## Database Schema

The database schema consists of two tables:

1. **User**: Stores user information, including username, email, password, full name, age, and gender.
   CREATE TABLE user (
       id BIGINT NOT NULL AUTO_INCREMENT,
       username VARCHAR(255) NOT NULL,
       email VARCHAR(255) NOT NULL,
       password VARCHAR(255) NOT NULL,
       full_name VARCHAR(255) NOT NULL,
       age INT NOT NULL,
       gender VARCHAR(255) NOT NULL,
       PRIMARY KEY (id),
       UNIQUE KEY (username),
       UNIQUE KEY (email)
   );
   
2.**Data**: Stores key-value pairs.
  CREATE TABLE data (
    id BIGINT NOT NULL AUTO_INCREMENT,
    `key` VARCHAR(255) NOT NULL,
    `value` VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
  );

Instructions to Run the Code
Follow these steps to run the application:

Clone the Repository:

git clone https://github.com/Surya0297/DPDZeroAssignment/tree/main
cd user-registration-data-storage
Database Configuration:

Configure the database connection in the application.properties file located in the src/main/resources directory:

spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
Build and Run the Application:

You can build and run the application using Maven:

mvn clean install
mvn spring-boot:run
The application will be accessible at http://localhost:8080.

Instructions to Set Up the Code
If you want to set up this code in your own Spring Boot project, follow these steps:

Dependencies:

Add the required dependencies to your project's pom.xml file:

<!-- Spring Boot Starter Web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Spring Boot Starter Data JPA -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- MySQL Connector -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>

<!-- Hibernate Validator -->
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
</dependency>

Application Configuration:

Configure the Spring Boot application class with @SpringBootApplication annotation. Also, make sure to add the necessary packages for component scanning.

Database Configuration:

Configure the database connection in the application.properties file, as mentioned in the "Instructions to Run the Code" section.

Entity Classes:

Create entity classes for User and Data and annotate them with @Entity, @Table, and validation annotations as needed.

Service and Repository Classes:

Create service and repository classes for User and Data to handle business logic and database operations.

Controller Classes:

Create controller classes to define RESTful endpoints and handle incoming requests.

Exception Handling:

Implement exception handling classes to handle various exceptions and return appropriate error responses.

Testing:

Write unit tests for your service and controller classes to ensure the application works as expected.

Build and Run:

Build and run your Spring Boot application as described in the "Instructions to Run the Code" section.
