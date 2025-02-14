# 🛒 E-Commerce Project Backend

This is the ⚙️ backend for an E-Commerce 🛍️ application built using Spring Boot 🌱. It provides RESTful APIs 🔗 for managing 🛠️ products 📦, including CRUD operations 🔄 and image 📸 handling.

## 📌 Requirements

### ✅ Prerequisites
- **☕ Java 17** or later
- **🔨 Maven 3.6+**
- **🗄️ MySQL database**
- **📬 Postman** (optional, for API testing 🧪)
- **🌱 Spring Boot**

### 📦 Dependencies Used
- `🌍 spring-boot-starter-web`
- `📊 spring-boot-starter-data-jpa`
- `✅ spring-boot-starter-validation`
- `🛢️ mysql-connector-java`
- `📝 lombok`

## 🚀 Setup Instructions

### 1️⃣ Clone the Repository
```sh
   git clone https://github.com/yourusername/ecomproject.git
   cd ecomproject
```

### 2️⃣ Configure the Database
Modify `⚙️ src/main/resources/application.properties` to set up your MySQL database:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### 3️⃣ Build and Run the Project
```sh
mvn clean install
mvn spring-boot:run
```

## 🔗 API Endpoints

### 📜 Get All Products
```http
GET /api/products
```
**Response:** Returns a list 📃 of all products.

### 🔍 Get Product by ID
```http
GET /api/product/{id}
```
**Response:** Returns the product 📦 details if found; otherwise, returns `❌ 404 Not Found`.

### ➕ Add a Product
```http
POST /api/product
```
**Request Parameters:**
- `📦 product` (JSON) - Product details
- `🖼️ imageFile` (Multipart File) - Image file

**Response:** Returns the created product.

### 🖼️ Get Product Image
```http
GET /api/product/{id}/image
```
**Response:** Returns the image file for the specified product.

### ✏️ Update Product
```http
PUT /api/product/{id}
```
**Request Parameters:**
- `📦 product` (JSON) - Updated product details
- `🖼️ imageFile` (Multipart File) - Updated image file

**Response:** Returns success ✅ or failure ❌ message.

### ❌ Delete Product
```http
DELETE /api/product/{id}
```
**Response:** Deletes the product if it exists.

### 🔎 Search Products
```http
GET /api/products/search?keyword=example
```
**Response:** Returns a list 📃 of products matching the keyword.

## 📝 Notes
- Ensure that the 🗄️ database is running before starting the backend.
- The API 🔗 is configured to allow Cross-Origin requests (`@CrossOrigin` 🌍).
- Exception handling ⚠️ is included for better error management.

