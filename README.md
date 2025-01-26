# animal-reserve

# Project - Animal Reserve

**Giacomo F5 Classroom**

- **Start Date:** Jan 7, 2025 *(Modified Jan 10, 2025)*

**Backend:** Spring & Spring Boot

- **Points:** 100

**Submission Date:** Jan 31, 2025

---

## Description  
Creation of an API for the management and maintenance of an animal reserve.

---

## Target Competencies
- Reinforce API creation concepts.
- Apply database relationships.
- Establish login knowledge using Spring Security and Basic Auth or JWT.

---

## Project Context  
A nature reserve has requested a management system to control its fauna.

---

## Functional Requirements
- Animal Management
- Authentication (ROLE_ADMIN)
- Generation and validation of JWT tokens or session COOKIES (in case Basic Auth is used) for secure sessions.

---

## Authentication System Requirements
- The system is managed by a single user with an administrator role.
- The authentication system can use either Basic Auth or JWT.

---

## Public Requests
1. Retrieve the list of all animals in the reserve with pagination (maximum 20 animals).
2. Retrieve the list of animals by the requested family with pagination (maximum 10 animals).
3. Retrieve the list of animals by country of origin without pagination.
4. Retrieve the list of animals by family and type.

---

## Private Requests
1. Retrieve the total number of animals.
2. Retrieve an animal by its name.
3. Add a new specimen.
4. Delete a specimen.
5. Edit a specimen.

---

## Minimum Required Families
- **Felidae** (Lion, Tiger, Leopard, etc.)
- **Canids** (Fox, Wolves, Jackals, etc.)
- **Reptiles** (Crocodiles, Snakes, Iguanas, etc.)
- **Mustelids** (Otters, Weasels, Badgers, etc.)
- **Leporidae** (Rabbits and Hares)

---

## Data Required for Specimen Registration
- Name
- Type
- Family to which it belongs
- Gender
- Country of origin
- Date of entry
- Image (optional)

---

## Extras
- Each specimen should include a photo.

---

## Pedagogical Modalities
- Individual development.
- 1 Sprint lasting 4 weeks.

---

## Expected Deliverables
1. Source code of the developed backend (GitHub repository link).
2. Postman collection with all endpoints and tests performed (only displayed during review).
3. API Documentation (complete Readme, diagrams, endpoint listing, etc.).
4. Presentation of the process followed during API development.
5. Image of the application uploaded to Docker Hub (optional).

---

## Project Timeline
- **Start:** Tuesday, Jan 7, 2025.
- **Final Individual Review:** Thursday, Jan 30, 2025, and Friday, Jan 31, 2025 (all day).
- **Submission:** Jan 31, 2025.

---

## Competency Frameworks
1. Project management using agile methodologies.
2. Develop a web application API.
3. Manage databases.
4. Develop and execute tests.

---

## Difficulty Level
Medium

```mermaid
erDiagram
    Animal {
        BIGINT id PK
        VARCHAR name
        BIGINT type_id FK
        BIGINT family_id FK
        BIGINT gender_id FK
        BIGINT country_id FK
        DATE date_of_entry
        VARCHAR image
    }
    AnimalType {
        BIGINT id PK
        VARCHAR type_name
    }
    AnimalFamily {
        BIGINT id PK
        VARCHAR family_name
    }
    Gender {
        BIGINT id PK
        VARCHAR gender_name
    }
    Country {
        BIGINT id PK
        VARCHAR country_name
    }
    User {
        BIGINT id PK
        VARCHAR username
        VARCHAR password
        BIGINT role_id FK
    }
    Role {
        BIGINT id PK
        VARCHAR name
    }
    Profile {
        BIGINT id PK
        VARCHAR firstName
        VARCHAR lastName
        VARCHAR email
        BIGINT user_id FK
    }

    Animal ||--o{ AnimalType : "belongs to"
    Animal ||--o{ AnimalFamily : "belongs to"
    Animal ||--o{ Gender : "has"
    Animal ||--o{ Country : "originates from"
    User ||--|{ Profile : "has one"
    User }o--|| Role : "belongs to"

