# Microservices Practice Project

This repository contains three standalone Spring Boot microservices for a simple banking domain:

- `accounts` for customer and account management
- `cards` for card management
- `loans` for loan management

Each service is built as an independent Maven project and runs with its own embedded server and in-memory H2 database.

## Tech Stack

- Java 21
- Spring Boot 4.0.5
- Spring Web MVC
- Spring Data JPA
- H2 Database
- Spring Boot Actuator
- Spring Validation
- Springdoc OpenAPI UI
- Maven Wrapper

## Repository Structure

```text
microservices/
|- accounts/
|- cards/
|- loans/
```

## Services

| Service | Port | Description |
|---|---:|---|
| `accounts` | `8080` | Customer and account CRUD APIs |
| `cards` | `9000` | Card CRUD APIs |
| `loans` | `8090` | Loan CRUD APIs |

## Prerequisites

- Java 21 installed and available on `PATH`
- Maven 3.9+ or the included Maven Wrapper scripts

## Run The Project

There is no parent aggregator project at the repository root, so each service must be started separately.

### Start `accounts`

```bash
cd accounts
./mvnw spring-boot:run
```

### Start `cards`

```bash
cd cards
./mvnw spring-boot:run
```

### Start `loans`

```bash
cd loans
./mvnw spring-boot:run
```

## Build And Test

Run these commands inside any service directory:

```bash
./mvnw clean test
./mvnw clean package
```

## Local Development Notes

- All services use `jdbc:h2:mem:testdb`
- Username is `sa`
- Password is blank
- Data is reset every time a service restarts
- H2 console is enabled for each service

## Swagger UI

After starting a service, OpenAPI UI is available at:

- `http://localhost:8080/swagger-ui/index.html`
- `http://localhost:9000/swagger-ui/index.html`
- `http://localhost:8090/swagger-ui/index.html`

## H2 Console

After starting a service, H2 console is available at:

- `http://localhost:8080/h2-console`
- `http://localhost:9000/h2-console`
- `http://localhost:8090/h2-console`

Use these connection values:

- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: leave blank

## API Summary

All services expose endpoints under `/api`.

### Accounts API

- `POST /api/create`
- `GET /api/fetch?mobileNumber=9345432123`
- `PUT /api/update`
- `DELETE /api/delete?mobileNumber=9345432123`

Create account example:

```bash
curl -X POST http://localhost:8080/api/create \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Eazy Bytes",
    "email": "tutor@eazybytes.com",
    "mobileNumber": "9345432123"
  }'
```

Update account example:

```bash
curl -X PUT http://localhost:8080/api/update \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Eazy Bytes",
    "email": "tutor@eazybytes.com",
    "mobileNumber": "9345432123",
    "accountsDto": {
      "accountNumber": 3454433243,
      "accountType": "Savings",
      "branchAddress": "123 Main Street, New York"
    }
  }'
```

### Cards API

- `POST /api/create?mobileNumber=4354437687`
- `GET /api/fetch?mobileNumber=4354437687`
- `PUT /api/update`
- `DELETE /api/delete?mobileNumber=4354437687`

Update card example:

```bash
curl -X PUT http://localhost:9000/api/update \
  -H "Content-Type: application/json" \
  -d '{
    "mobileNumber": "4354437687",
    "cardNumber": "100646930341",
    "cardType": "Credit Card",
    "totalLimit": 100000,
    "amountUsed": 1000,
    "availableAmount": 99000
  }'
```

### Loans API

- `POST /api/create?mobileNumber=4365327698`
- `GET /api/fetch?mobileNumber=4365327698`
- `PUT /api/update`
- `DELETE /api/delete?mobileNumber=4365327698`

Update loan example:

```bash
curl -X PUT http://localhost:8090/api/update \
  -H "Content-Type: application/json" \
  -d '{
    "mobileNumber": "4365327698",
    "loanNumber": "548732457654",
    "loanType": "Home Loan",
    "totalLoan": 100000,
    "amountPaid": 1000,
    "outstandingAmount": 99000
  }'
```

## Current Limitations

- The services are independent and not wired together through service discovery or an API gateway
- The database is in-memory only
- Build outputs under `target/` are generated artifacts, not source files
