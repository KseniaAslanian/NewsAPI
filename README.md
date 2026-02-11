# NewsAPI

A RESTful web application for managing a news feed, built with Spring Boot.
Data is stored in-memory using ConcurrentHashMap with thread-safe operations.

## Tech Stack

- Java 25
- Spring Boot 3.4.0
- Lombok
- Spring Validation
- Maven

## How to Run

1. Clone the repository
2. Make sure Java 25 is installed
3. Run from IntelliJ IDEA or with: `mvn spring-boot:run`
4. App starts on http://localhost:8080

## Sample Data
Three news items are preloaded automatically on startup
using Spring's ApplicationRunner interface.
No manual data entry required - just run and test!

## API Endpoints

| Method | URL | Description | Status Code |
|--------|-----|-------------|-------------|
| GET | /api/news | Get all news | 200 |
| GET | /api/news/{id} | Get news by ID | 200 / 404 |
| POST | /api/news | Create news | 201 |
| PUT | /api/news/{id} | Update news | 200 / 404 |
| DELETE | /api/news/{id} | Delete news | 204 / 404 |

## Example Request

POST /api/news
```json
{
  "title": "Breaking News",
  "text": "Something important happened today."
}