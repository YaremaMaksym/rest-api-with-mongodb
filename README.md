# rest-api-with-mongodb

This project implements a REST API that has CRUD operations, backed by a MongoDB database deployed within a container. 

## Table of Contents

- [Technologies](#technologies)
- [Installation](#installation)
- [API's](#API's)

## Technologies

The project uses the following technologies:

- Java
- Spring Framework (for creating general infrastructure and supporting database interaction.)
- Spring Boot (for application setup, configuration, and deployment)
- Spring MVC (for handling HTTP requests and responses)
- Spring Data (for interacting with databases)
- Lombok (for reducing boilerplate code and enhancing Java classes)
- MongoDB (as the database)
- Maven (for dependency management)
- Git (for version control)
- Docker (for containerization)

## Installation

To run the project locally, follow these steps:

1. Clone the repository:

   ```
   git clone https://github.com/YaremaMaksym/rest-api-with-mongodb.git
   ```
   
2. Open the project in your preferred IDE.
    
3. Type ```docker-compose up -d``` to start containers.

4. Run the application

## API's

* GET /api/v1/students - get list of all students.
* GET /api/v1/students/{email} - get student by email.
* POST /api/v1/students - register new student.
* PUT /api/v1/students/{email} - update fields of student.
* DELETE /api/v1/students/{email} - delete student.
