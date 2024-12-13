# Microservices-based Quiz App

This is a Quiz App based on the microservices architecture. The app consists of two microservices: one for managing quizzes and another for managing questions. Communication between microservices is facilitated by Feign Client. Additionally, Eureka Server is used as a Service Registry and an API Gateway is used for receiving requests and routing them to the appropriate microservices.

## Features

- **Quiz Management Microservice**: Manages quizzes, including creation, scoring, and user attempts.
- **Questions Management Microservice**: Manages questions, including CRUD operations.
- **Communication**: Microservices communicate with each other via RESTful APIs using Feign Client.
- **Service Discovery**: Eureka Server is used for service registration and discovery.
- **API Gateway**: Routes requests to the appropriate microservice using an API Gateway.

## Components

- **Backend Microservices**:
  - **Quiz Service**: Manages quizzes and scoring.
  - **Questions Service**: Manages questions.
- **Communication**: Feign Client is used for communication between microservices.
- **Service Registry**: Eureka Server is used for service registration and discovery.
- **API Gateway**: Routes requests to the appropriate microservice.
- **Java Version**: Java JDK 21
- **Spring Boot Version**: 3.3.6
- **Database**: PostgreSQL 7 is used as the database management system.

## Usage

1. **Setup PostgreSQL Database**: Set up PostgreSQL 7 and create databases for each microservice.
2. **Run Eureka Server**: Start the Eureka Server to enable service registration and discovery.
3. **Run Microservices**: Start both the Quiz Service and the Questions Service.
4. **API Gateway**: Start the API Gateway to handle incoming requests and route them to the appropriate microservice.

## API endpoints

- POST /quiz/create/: Admin can create quiz by passing category name, title, numofQuestions as parameters.
- GET /quiz/get/{id}/: To get the questions by id.
- POST /quiz/submit/{id}/: User submits the quiz.

## Development Setup

1. **Clone the Repository**: Clone this repository to your local machine.
2. **Configure Databases**: Set up PostgreSQL 7 and configure the database connections for each microservice.
3. **Run Eureka Server**: Start the Eureka Server by running the corresponding Spring Boot application.
4. **Run Microservices**: Start both the Quiz Service and the Questions Service by running their respective Spring Boot applications.
5. **Run API Gateway**: Start the API Gateway to handle incoming requests and route them to the appropriate microservice.
6. **API Testing**: Use Postman or any REST client to test the APIs provided by each microservice.