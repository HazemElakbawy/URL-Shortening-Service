# URL Shortening Service 🌐✂️

- This project is a REST-ful API for shortening URLs with functionality to track access statistics.
- It provides endpoints for creating shortened URLs, retrieving original URLs, updating, and deleting shortened URLs.
- This project is part of the community-driven projects published
  on [roadmap.sh](https://roadmap.sh/projects/url-shortening-service).
- Feel free to visit the [projects page](https://roadmap.sh/projects) to explore more.

## Technologies Used 🛠️

- Java 22 ☕
- Spring Boot 🍃
- Spring Data JPA 📊
- MySQL 🐬
- Docker & Docker Compose 🐳
- Maven 📦
- Swagger UI 📚

## Features 🌟

- Shorten long URLs into easily shareable links
- Retrieve original URL using the shortened link
- Access count tracking for each shortened URL
- Create, update, and delete shortened URLs
- API documentation available through Swagger UI

## Prerequisites ⚙️

- Java 22 JDK
- Docker and Docker Compose
- Maven

## Getting Started 🚀

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/URL-Shortening-Service
   cd URL-Shortening-Service
   ```

2. Start the application and database using Docker Compose:
   ```bash
   docker-compose up -d
   ```

3. The API will be available at `http://localhost:8080/api`

## Swagger UI 📊

- You can explore and test the API using Swagger UI. After starting the application, open the following URL in your
  browser: `http://localhost:8080/swagger-ui/index.html`
- This will load the interactive Swagger interface where you can view API documentation, test API endpoints, and inspect
  request/response details.

## Key Learnings📚

- Custom Build Process:
  - Learned to implement a multi-stage Docker build process for a Spring Boot application using `openjdk:22-jdk-slim`.
  - This approach optimizes image size and speeds up deployment by separating the build environment from the runtime
    environment.
  - Cached Maven dependencies to improve build times and avoid unnecessary downloads.
  - Utilized threads per core during the build process for enhanced performance and reduced build time.

- URL Redirection:
  - Implemented URL redirection in the application, allowing users to access the original URL by visiting the shortened
    URL.
  - This feature enhances user experience and provides seamless navigation.

- Entity Lifecycle Callbacks:
  - Gained knowledge about using `@PreUpdate` and `@PrePersist` annotations to automatically set the createdAt and
    updatedAt
    timestamps for the database entities.
  - This practice ensures accurate tracking of entity creation and modification times without manual intervention.