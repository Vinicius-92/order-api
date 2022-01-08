[![My Linkedin Profile](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](http://www.linkedin.com/in/vinicius-92)

## Order control REST API 

### A full CRUD API for a model/entity Order, OrderItem and Client

A fully functional API that control order with the association with order items and clients. Made using:

* Java 11
* Maven
* JUnit
* H2-Database
* Spring Boot
* Spring Data Jpa
* Lombok
* Swagger Documentation

### What I've learned: 

How to structure a Spring Boot Java application using best practices and SOLID principles, using dependencies from Maven like Lombok to save time and create more readable and easy to maintain code. I also learn got a better understanding of associations (One to Many, Many to One, etc) using annotations. I've also have learned the importance of DTO and Service classes.
**Update:** Returning to the project a few months later I'm now implementing tests and improving the overall architecture.

### Swagger Documentation:

You can access after the project is running in the /swagger-ui.html endpoint.

[![Click here for documentation](https://raw.githubusercontent.com/swagger-api/swagger.io/wordpress/images/assets/SW-logo-clr.png)](http://localhost:8080/swagger-ui.html)

### How to use:

You can use an API Test application, Postman or Insomnia, to test the endpoints you'll clone the project to your machine and run, you'll need Java 11 and Maven 3.8.1. The commands to clone and to run are the following:

Clone:
```shell script
git clone https://github.com/Vinicius-92/order-api.git
```

Run: (in the root of project directory)
```shell script
mvn spring-boot:run
```

#### Endpoints:

GET - List all entities in database:
```
/clients
/orders
/products
```

GET - Fetch specific data by ID:
```
/clients/{id}
/orders/{id}
/products/{id}
```

DELET - Delete a register by ID:
```
/clients/{id}
/orders/{id}
/products/{id}
```

POST - Create entity instance:
```
/clients/{id}
/products/{id}
```
JSON required in body:
```json
Client:
{
    "name": "Example name",
    "email": "example@email.com"
}

Product:
{
    "name": "Product Name",
    "price": 1999.0
}
``` 

### To-do:
* ~Added Swagger Documentation~-> Done
* ~Separate the class repository to delegate the responsibility for the service class~ -> Done
* ~Create a DTO object in order to improve how the responses from endpoints can be more efficient~ -> Done
* ~Create a database to test application's endpoints~ -> Done
* ~Create personalized exceptions~ -> Done
