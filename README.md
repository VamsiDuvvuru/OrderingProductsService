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

## Additional Information
1.End Points for product:
   - **POST** `/products`: Create a new product.
     sample curl:
   ```sh
     curl -X POST \
     'http://localhost:9090/ProductOrderService/products' \
     -H 'accept: */*' \
     -H 'Content-Type: application/json' \
     -d '{
     "id": 0,
     "name": "string",
     "price": 0
     }'
   ```

2. End Points for order:
   - **POST** `/orders`: Create a new order.
   sample curl:
   ```sh
     curl -X 'POST' \
     'http://localhost:9090/ProductOrderService/orders' \
     -H 'accept: */*' \
     -H 'Content-Type: application/json' \
     -d '{
     "id": 0,
     "productId": 0,
     "status": "PENDING"
     }'
   ```
3. End Points for order status:
   - **GET** `/orders/{orderId}`: Get the status of an order by its ID.
   sample curl:
   ```sh
     curl -X 'GET' \
     'http://localhost:9090/ProductOrderService/orders/1' \
     -H 'accept: */*'
   ```