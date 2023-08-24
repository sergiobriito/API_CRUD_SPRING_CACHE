# User Registration API with Java (Spring), PostgreSQL, and Redis

This project provides an API for user registration built using the Java Spring framework. The application employs PostgreSQL for data storage and Redis for caching, enhancing data retrieval efficiency and overall performance. You can also choose to deploy the application using Docker Compose.

## Features

- **User Operations:** Perform comprehensive CRUD (Create, Read, Update, Delete) operations on user data.
- **Caching with Redis:** Utilize Redis caching to optimize the retrieval of frequently accessed user data, resulting in significantly improved response times.
- **PostgreSQL Database:** Store user data persistently using the PostgreSQL database.
- **Java Spring Framework:** Developed using the Java Spring framework for a robust and scalable architecture.
- 
## API Endpoints

- `GET /users/{id}`: Retrieve details of a specific user.
- `POST /users`: Create a new user.
- `PUT /users/{id}`: Update user information.
- `DELETE /users/{id}`: Delete a user.
- `GET /users?t=[:search-term]`: Search for users based on a search term.
- `GET /users/total-users`: Obtain the total count of registered users.

## Getting Started

Follow these steps to set up and run the API locally:

1. Clone this repository: `git clone https://github.com/sergiobriito/api-spring-redis-cache.git`
2. Build the application: `mvn clean package -DskipTests`
3. Make sure you have Docker Compose installed on your system.
4. Build the Docker images: `docker-compose build`
5. Start the services using Docker Compose: `docker-compose up`

Access the API at `http://localhost:8080/api/v1/users`.

