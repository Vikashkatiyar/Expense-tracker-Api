# BudgetFlow (expense-tracker-api)

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


## API Documentation
Base URL: http://localhost:8080

# 🔐 1. User APIs
Base Path: `/api/users`

## 1️⃣ Login User

**POST** `/api/users/login`

### Request Body

``` json
{
  "email": "user@gmail.com",
  "password": "password123"
}
```

### Response (200 OK)

``` json
{
  "token": "JWT_TOKEN"
}
```

------------------------------------------------------------------------

## 2️⃣ Register User

**POST** `/api/users/register`

### Request Body

``` json
{
  "firstName": "Vikash",
  "lastName": "Katiyar",
  "email": "vikash@gmail.com",
  "password": "password123"
}
```

### Response (200 OK)

``` json
{
  "token": "JWT_TOKEN"
}
```

------------------------------------------------------------------------

# 📂 2. Category APIs

Base Path: `/api/categories`\
Requires: Authorization Header

### Authorization Header

    Authorization: Bearer <JWT_TOKEN>

------------------------------------------------------------------------

## 1️⃣ Get All Categories

**GET** `/api/categories`

------------------------------------------------------------------------

## 2️⃣ Get Category By ID

**GET** `/api/categories/{categoryId}`

------------------------------------------------------------------------

## 3️⃣ Add Category

**POST** `/api/categories`

### Request Body

``` json
{
  "title": "Travel",
  "description": "Trip expenses"
}
```

------------------------------------------------------------------------

## 4️⃣ Update Category

**PUT** `/api/categories/{categoryId}`

### Request Body

``` json
{
  "title": "Updated Travel",
  "description": "Updated description"
}
```

------------------------------------------------------------------------

## 5️⃣ Delete Category

**DELETE** `/api/categories/{categoryId}`

Note: Deleting a category also deletes all transactions under it.

------------------------------------------------------------------------

# 💳 3. Transaction APIs

Base Path: `/api/categories/{categoryId}/transactions`\
Requires: Authorization Header

------------------------------------------------------------------------

## 1️⃣ Get All Transactions

**GET** `/api/categories/{categoryId}/transactions`

------------------------------------------------------------------------

## 2️⃣ Get Transaction By ID

**GET** `/api/categories/{categoryId}/transactions/{transactionId}`

------------------------------------------------------------------------

## 3️⃣ Add Transaction

**POST** `/api/categories/{categoryId}/transactions`

### Request Body

``` json
{
  "amount": 1500,
  "note": "Hotel Booking",
  "transactionDate": 1700000000
}
```

------------------------------------------------------------------------

## 4️⃣ Update Transaction

**PUT** `/api/categories/{categoryId}/transactions/{transactionId}`

------------------------------------------------------------------------

## 5️⃣ Delete Transaction

**DELETE** `/api/categories/{categoryId}/transactions/{transactionId}`

------------------------------------------------------------------------

# 🔐 Authentication Flow

1.  Register or Login
2.  Receive JWT Token
3.  Pass token in header for protected APIs

```{=html}
<!--Authorization: Bearer <JWT_TOKEN> -->
```

------------------------------------------------------------------------

# 🧠 Data Hierarchy

User ├── Categories │ ├── Transactions

-   One User → Many Categories
-   One Category → Many Transactions
-   Deleting Category → Deletes all its Transactions
