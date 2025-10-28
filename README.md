# 🏨 Hotel Management & Booking System

A full-featured **Hotel Management and Booking Web Application** built with **Spring Boot**, **Hibernate**, and **RESTful APIs**.  
It allows hotel admins to manage rooms, bookings, services, and customers — while guests can browse rooms, make reservations, and complete payments online.

---

## 🚀 Features

### 🧑‍💼 Admin / Manager
- Manage hotels, rooms, and room types  
- Track bookings and customer details  
- Assign and manage employees  
- Add and manage extra services (e.g., room service, laundry)

### 🧑‍🤝‍🧑 Customer
- Browse available rooms and check availability  
- Make, view, and cancel bookings  
- Manage profile and payment information  
- Leave reviews for hotels or rooms  

### 💳 Payments
- Record and track payments for bookings  
- Support for multiple payment methods  
- Refund and cancellation handling  

---

## 🧱 Core Entities

- `Hotel` – Basic hotel info  
- `Room` – Individual rooms with types and availability  
- `RoomType` – Room category and base pricing  
- `User` – Base user account (roles: ADMIN, MANAGER, CUSTOMER)  
- `CustomerProfile` – Extended info for customers  
- `Booking` – Room reservation details  
- `Payment` – Payment records  
- `Employee` – Staff management  
- `Service` – Extra hotel services (spa, laundry, etc.)  
- `BookingService` – Mapping between bookings and services  

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-------------|
| Backend | Spring Boot (Web, Data JPA, Validation, Security) |
| Database | PostgreSQL / MySQL / H2 (for dev) |
| ORM | Hibernate |
| API | RESTful JSON endpoints |
| Build Tool | Maven / Gradle |
| Authentication | Spring Security with JWT |
| Frontend *(optional)* | React / Thymeleaf / Angular |

---

## ⚙️ Setup Instructions

1. **Clone the repo**
   ```bash
   git clone https://github.com/<your-username>/hotel-management-system.git
   cd hotel-management-system
