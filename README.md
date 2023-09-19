# expense-tracker-api

REST API for tracking expenses.

A RESTful API created using Spring Boot. We have used PostgreSQL as the relational database and JdbcTemplate to interact with that.
Apart from this, we have used JSON Web Token (JWT) to add authentication. Using JWT, we can protect certain endpoints and ensure that user must be logged-in to access those.

## Used Tools and Technologies:

      Spring Boot 3.0.10
      
      >. spring-boot-devtools
      >. Spring-boot-starter-jdbc
      >. spring-boot-starter-web
      >. JSON Web Token (JWT)
      
      DataBase
      
      >.postgresql
      
      Tools
      
      >. STS(Spring tool suite)
      >. PostMan



## Setup and Installation

1. **Clone the repo from GitHub**
   ```sh
   git clone https://github.com/Vikashkatiyar/Expense-tracker-Api.git
   cd expense-tracker-api
   ```

2. **Create database objects**

   In the root application directory (expense-tracker-api), SQL script file (expensetracker_db.sql) is present for creating all database objects
   
4. Update database configurations in application.properties**
   
   If your database is hosted at some cloud platform or if you have modified the SQL script file with some different username and password, update the src/main/resources/application.properties file accordingly:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/expensetrackerdb
   spring.datasource.username=expensetracker
   spring.datasource.password=password
   ```
5. **Run the spring boot application**
   ```sh
   ./mvnw spring-boot:run
   ```
   this runs at port 8080 and hence all enpoints can be accessed starting from http://localhost:8080
