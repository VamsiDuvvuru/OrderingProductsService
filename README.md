####This is the read me file#####
1.Initial set up 
  a. java version (21)
  b.  mvn version (3.9.*)
  c. intellij visual studio
2. Project build
    a. mvn clean package -DskipTests
3. Run unit tests
    a. mvn test
4. Run the project
   a. mvn clean package 
   b. cd target/
   c. java -jar OrderProductService-0.0.1-SNAPSHOT.jar --server.port = ${anyport}
   d. open swagger-ui using the below endpoint (replace port number with your running port i.e 9090 should be replaced if not using same port)
      http://localhost:9090/ProductOrderService/swagger-ui/index.html
5. Integration tests using swagger
   a.sample request input are available in swagger so please follow the same for testing
