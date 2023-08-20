# API - Users Register with PostgreSQL and Redis (CACHE)

This project provides a user registration API built using the Java Spring framework. It incorporates both PostgreSQL for data storage and Redis for caching, optimizing data retrieval and enhancing performance.

## Features

- **User Operations:** Perform CRUD (Create, Read, Update, Delete) operations on user data.
- **Caching:** Utilize Redis caching to store frequently accessed user data, improving response times.
- **PostgreSQL Database:** Store user data in a PostgreSQL database for persistent storage.
- **Java Spring:** Developed using the Java Spring framework for robust and scalable architecture.
- **Easy Integration:** Seamlessly integrate this API into your Spring-based projects.

## API Endpoints

- **GET /users/{id}:** Retrieve details of a specific user.
- **POST /users:** Create a new user.
- **PUT /users/{id}:** Update user information.
- **DELETE /users/{id}:** Delete a user.
- **GET /users?t=[:search-term]:** Search for users based on a search term.
- **GET /users/total-users:** Get the total count of registered users.


