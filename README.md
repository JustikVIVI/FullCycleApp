# Full Cycle App

This application mimics a fitness center booking system, allowing you to manage users, subscriptions, and book training sessions. (Some functions are still in progress)

## Overview

This is a simple Spring application that I am using to explore new technologies and gain a deeper understanding of Spring and full-cycle backend development.

## Features

- **User Management**: Select and manage users.
- **Subscription Management**: Handle different user subscriptions.
- **Training Booking**: Book training sessions for users (work in progress).

## Technologies Used

- **Spring Boot**: The core framework for the application.
- **PostgreSQL**: The database used for storing application data, deployed to Heroku.
- **OpenApi**: Codegeneration for API.
- **Flyway**: Database migration tool.
- **Docker**: Containerization of the application.
- **Docker Compose**: Managing local development environment with PostgreSQL and Adminer.
- **GitHub Actions**: CI/CD pipeline for building and deploying the application to my personal VPS.
- **Heroku**: Platform used for deployments.
- **Papertrail**: Log management.

## Local Development

For local development, Docker and Docker Compose are used to set up the application and database environment. The Docker Compose setup includes:

- **PostgreSQL**: Database service.
- **Adminer**: Database management tool.

## Usage

To run the application locally:

1. Clone the repository:
   ```bash
   git clone https://github.com/JustikVIVI/FullCycleApp.git
   cd FullCycleApp
2. Start the Docker Compose (for PostgreSQL):
   ```bash
   docker-compose up --build
3. Run an app:
   ```bash
   ./gradlew bootRun
