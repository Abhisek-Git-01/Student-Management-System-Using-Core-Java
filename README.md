# 🎓 Student Management System (Core Java + JDBC)

<p align="center">
  <img src="https://img.shields.io/badge/Java-Core-orange"/>
  <img src="https://img.shields.io/badge/JDBC-Database-blue"/>
  <img src="https://img.shields.io/badge/MySQL-DB-green"/>
  <img src="https://img.shields.io/badge/OOP-Concepts-purple"/>
  <img src="https://img.shields.io/badge/Console-App-lightgrey"/>
</p>

---

## 🚀 Overview

The **Student Management System** is a **Core Java console-based application** that performs CRUD operations using **JDBC for database connectivity**.

This project demonstrates real-world interaction between Java applications and relational databases.

---

## 🎯 Features

* ➕ Add new student
* 📄 View all students
* ✏️ Update student details
* ❌ Delete student records
* 🔍 Search student by ID
* 🗄️ Persistent storage using **MySQL + JDBC**

---

## 🏗️ Application Flow

<p align="center">
  <img src="images/student-flow.png" width="700"/>
</p>

---

## 🛠️ Tech Stack

* Java (Core Java)
* JDBC
* MySQL
* OOP Concepts

---

## 📂 Project Structure

```id="p1z8m4"
src/
│
├── model        # Student class
├── dao          # JDBC operations (StudentDAO)
├── service      # Business logic
├── util         # DB connection utility
└── main         # Entry point
```

---

## 🔄 Working Flow

User Input → Service Layer → DAO (JDBC) → Database → Response

---

## ▶️ How to Run

1. Clone the repository

```bash id="k2v7q9"
git clone https://github.com/Abhisek-Git-01/<your-repo-name>.git
```

2. Setup database:

* Create MySQL database
* Create student table
* Update DB credentials in code

3. Run the main class

---

## 📌 Sample Menu

```id="m9x3t1"
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Search Student
6. Exit
```

---

## 💡 Key Concepts Used

* JDBC (Connection, PreparedStatement, ResultSet)
* CRUD Operations
* OOP Principles
* Exception Handling
* Database Connectivity

---

## 🎯 Learning Outcome

* Built a database-driven Java application
* Learned how to perform CRUD operations using JDBC
* Understood SQL query execution from Java
* Implemented layered architecture (DAO + Service)

---

## 📊 Future Enhancements

* 🌐 Convert to Spring Boot REST API
* 🎨 Add GUI (Swing / JavaFX)
* 🔐 Add authentication system

---

## 🤝 Contributing

Feel free to fork and improve this project.

---

## ⭐ Acknowledgement

This project is developed for practicing Core Java and JDBC concepts.

---
