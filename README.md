# Loan Management System 

Welcome to the Loan Management System, a project designed to manage loans efficiently. This document provides an overview of the project structure, setup instructions, API endpoints, and usage guidelines.

## Project Structure

The project comprises the following key components:

- **`src/main/java`**: Contains the main Java source files.
- **`src/main/resources`**: Holds configuration files and resources.
- **`build.gradle.kts`**: The Gradle build script for managing project dependencies and tasks.
- **`Dockerfile`**: Defines the Docker image for containerizing the application.

## Prerequisites

Ensure you have the following installed on your system:

- [Java Development Kit (JDK) 17+]
- [Gradle](https://gradle.org/install/)
- [Docker](https://www.docker.com/get-started) (optional, for containerization)

## Setup and Installation

**Clone the Repository**:
   ```bash
       git clone https://github.com/Nahasean94/Credable-Technical-Assessment.git
       cd Credable-Technical-Assessment
```

The database used is Postgres. You can use a docker container or otherwise, and setup a username and password, which 
you can update in the application.properties file.

Once you run the application, you can access the Swagger API documentation here:
http://localhost:8190/swagger-ui/index.html

The project is simple and missing some key features that should be present in a production environment. Some of 
these features include:
1. Event management system- for queueing requests and make the requests asynchronous 
2. Stronger security features
3. Caching
4. Performance e.g use of multi threading
5. Secure config management especially for credentials
6. Monitoring tools


