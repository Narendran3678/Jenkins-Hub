# Spring Boot Jenkins Practice Project

A complete Spring Boot REST API project with JUnit tests, configured for Jenkins CI/CD pipeline practice.

## Project Structure

```
demo/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── DemoApplication.java
│   │   │   ├── controller/
│   │   │   │   └── UserController.java
│   │   │   ├── service/
│   │   │   │   └── UserService.java
│   │   │   ├── model/
│   │   │   │   └── User.java
│   │   │   └── repository/
│   │   │       └── UserRepository.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/example/demo/
│           ├── controller/
│           │   └── UserControllerTest.java
│           └── service/
│               └── UserServiceTest.java
├── Jenkinsfile
├── pom.xml
└── README.md
```

## Features

- RESTful API endpoints (CRUD operations)
- JPA/Hibernate with H2 in-memory database
- Comprehensive JUnit 5 tests with Mockito
- JaCoCo code coverage reports
- Jenkins pipeline configuration
- Maven build automation

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/users` | Get all users |
| GET | `/api/users/{id}` | Get user by ID |
| POST | `/api/users` | Create new user |
| PUT | `/api/users/{id}` | Update user |
| DELETE | `/api/users/{id}` | Delete user |

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- Jenkins (for CI/CD)

## Running Locally

### Build the project
```bash
mvn clean install
```

### Run tests
```bash
mvn test
```

### Run the application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### Access H2 Console
Navigate to: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave empty)

## Testing with cURL

### Create a user
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","email":"john@example.com"}'
```

### Get all users
```bash
curl http://localhost:8080/api/users
```

### Get user by ID
```bash
curl http://localhost:8080/api/users/1
```

### Update user
```bash
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"John Updated","email":"john.updated@example.com"}'
```

### Delete user
```bash
curl -X DELETE http://localhost:8080/api/users/1
```

## Jenkins Setup

### 1. Install Required Jenkins Plugins
- Maven Integration Plugin
- JUnit Plugin
- JaCoCo Plugin
- Pipeline Plugin
- Git Plugin

### 2. Configure Jenkins Tools
Go to **Manage Jenkins > Global Tool Configuration**:
- Add JDK 17 (name: `JDK-17`)
- Add Maven 3.9.5 (name: `Maven-3.9.5`)

### 3. Create Jenkins Pipeline Job
1. Click **New Item**
2. Enter job name and select **Pipeline**
3. Under **Pipeline** section:
   - Definition: **Pipeline script from SCM**
   - SCM: **Git**
   - Repository URL: Your Git repository URL
   - Script Path: `Jenkinsfile`
4. Save and build

## Jenkins Pipeline Stages

1. **Checkout** - Retrieves source code from SCM
2. **Build** - Compiles the application
3. **Unit Tests** - Runs JUnit tests
4. **Code Coverage** - Generates JaCoCo coverage report
5. **Package** - Creates JAR artifact
6. **Archive Artifacts** - Stores build artifacts
7. **SonarQube Analysis** - (Optional) Code quality analysis
8. **Deploy to Dev** - Deploys to development environment
9. **Deploy to Production** - Deploys to production with approval

## Test Coverage

Run coverage report:
```bash
mvn clean test jacoco:report
```

View report at: `target/site/jacoco/index.html`

## License

This is a practice project for learning Jenkins CI/CD.
