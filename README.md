Here is a clearer and more structured version of your `README.md` file. It uses Markdown formatting for better readability and organization.

```markdown
# Order Product Service

A Spring Boot application for managing product orders.

---

## Prerequisites

- **Java:** 21
- **Maven:** 3.9.\*
- **IDE:** IntelliJ IDEA or Visual Studio

---

## Building the Project

```sh
mvn clean package -DskipTests
```

---

## Running Unit Tests

```sh
mvn test
```

---

## Running the Application

1. Build the project:
    ```sh
    mvn clean package
    ```
2. Navigate to the `target` directory:
    ```sh
    cd target/
    ```
3. Start the application (replace `${anyport}` with your desired port):
    ```sh
    java -jar OrderProductService-0.0.1-SNAPSHOT.jar --server.port=${anyport}
    ```

---

## API Documentation

- Open Swagger UI in your browser (replace `9090` with your chosen port):

  [http://localhost:9090/ProductOrderService/swagger-ui/index.html](http://localhost:9090/ProductOrderService/swagger-ui/index.html)

---

## Integration Testing

- Sample request inputs are available in Swagger UI.
- Use the provided examples for testing API endpoints.

---
```
This version uses headings, code blocks, and lists for clarity and ease of use.