# Employee CRUD Application

This application is a simple Employee CRUD (Create, Read, Update, Delete) service built using JavaEE with Spring Boot. It provides RESTful APIs for managing employee data and stores the data in a PostgreSQL database.

## Features

- Add new employees
- Get employee details by ID
- Update employee details by ID
- Delete employee by ID
- Get a list of employees based on specific criteria

## Technologies Used

- Spring Boot
- RESTful APIs
- PostgreSQL

## Prerequisites

- Java 11 or higher
- Maven
- PostgreSQL

## Getting Started

1. **Clone the repository**

    ```bash
    git clone https://github.com/thqu1et/Employee-Crud.git
    cd employee-crud
    ```

2. **Configure the PostgreSQL Database**

   Ensure you have PostgreSQL installed and running. Create a database and update the `application.properties` file with your database credentials.

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. **Build the Project**

   Use Maven to build the project:

    ```bash
    mvn clean install
    ```

4. **Run the Application**

   Start the Spring Boot application:

    ```bash
    mvn spring-boot:run
    ```

   The application will start and be accessible at `http://127.0.0.1:8080/employee`.

## API Endpoints

### Add Employee

- **URL**: `/add`
- **Method**: `POST`
- **Request Body**: `EmployeeToCreateDTO`

    ```json
    {
        "first_name": "John",
        "last_name": "Doe",
        "department": "Engineering",
        "position": "Developer",
        "grade": "A",
        "salary": 60000
    }
    ```

### Get Employee by ID

- **URL**: `/get/{id}`
- **Method**: `GET`
- **Response Body**: `EmployeeDTO`

    ```json
    {
        "id": 1,
        "fio": "John Doe",
        "department": "Engineering",
        "position": "Developer",
        "grade": "A",
        "salary": 60000
    }
    ```

### Update Employee by ID

- **URL**: `/update/{id}`
- **Method**: `PATCH`
- **Request Body**: `EmployeeToCreateDTO`

    ```json
    {
        "first_name": "John",
        "last_name": "Doe",
        "department": "Engineering",
        "position": "Senior Developer",
        "grade": "A",
        "salary": 70000
    }
    ```

### Delete Employee by ID

- **URL**: `/delete/{id}`
- **Method**: `DELETE`

### Get List of Employees

- **URL**: `/list`
- **Method**: `POST`
- **Request Body**: `EmployeeListDTO`

    ```json
    {
        "first_name": "John",
        "last_name": "Doe",
        "department": "Engineering",
        "position": "Developer",
        "grade": "A",
        "salary": 60000
    }
    ```

- **Response Body**: List of `EmployeeSpecialDTO`

    ```json
    [
        {
            "id": 1,
            "first_name": "John",
            "last_name": "Doe",
            "department": "Engineering",
            "position": "Developer",
            "grade": "A",
            "salary": 60000
        }
    ]
    ```

## Exception Handling

The application includes custom exception handling for the following scenarios:

- **EmptyValueException**: Thrown when a required field is empty or null.
- **NotFoundException**: Thrown when an employee with the given ID is not found.

## Logging

The application uses `Slf4j` for logging purposes. Logs will provide information on application events and errors.

## Conclusion

This Employee CRUD application demonstrates the implementation of RESTful APIs using Spring Boot with a PostgreSQL database. It covers basic CRUD operations and includes exception handling and logging for better maintainability and debugging.

