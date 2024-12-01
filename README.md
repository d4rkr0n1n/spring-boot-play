# The Spring Boot Microservices Project

## Architecture

```mermaid
flowchart LR
 subgraph DBSvc["DB Service"]
    direction LR
        API["DB API"]
        DB[("Database")]
  end
 subgraph AppSvc["Application Services"]
    direction TB
        Frontend["Frontend Service"]
        Backend["Backend Service"]
        DBSvc
  end
 subgraph Microservices["Microservices"]
    direction LR
        AppSvc
        APIGateway["APIGateway"]
  end
    APIGateway <--> AppSvc
    Frontend <--> Backend
    Backend <--> DBSvc
    API <--> DB
    World["World"] <--> APIGateway
```

### Done

- [x] Simple Hello World API
- [x] Add GitHub Actions for build and test
- [x] Add Architecture diagram
- [x] Skeleton CRUD API
- [x] Spring JPA Data
- [x] CRUD API
- [x] Business Logic Service
- [x] Add ResponseEntity
- [x] Add Postman API Collection
- [x] Refactor PutMapping Function
- [x] Refactor Service Class
- [x] Response Entity Refactoring
- [x] Thymeleaf Frontened: Initial Setup
- [x] Thymeleaf Frontened: Create
- [x] Thymeleaf Frontened: Delete
- [x] Thymeleaf Frontened: Update
- [x] Refactor HTML templates

### Work in Progress

- [ ] Change naming conventions

## Future Plans

### Prerequisites

- [ ] Improve Architecture Diagram
- [ ] Spring Data Rest for DB
- [ ] Add API Gateway
- [ ] Add Frontend Microservice

### Dockerizing the application

- [ ] Create dockerfile for each service
- [ ] Create docker compose for microservices stack
