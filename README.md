# 🐾 Vet Clinic System

## Overview
The **Vet Clinic System** is a veterinary clinic management application. It allows pet owners to register their pets, book visits with doctors, and manage clinics and doctor data.  
Built using **Spring Boot**, **Spring MVC**, **Hibernate (JPA Annotations)**, and **MySQL**, the system provides REST APIs for interaction with the data.

---

## Technologies Used
- **Java 17**
- **Spring Boot **
- **Spring Data JPA**
- **Hibernate (Annotations)**
- **Spring Security**
- **Lombok**
- **MySQL**
- **Maven**

---

## System Entities
| Entity | Fields | Relationships |
|--------|--------|---------------|
| **User** | id, username, email, phone, password, role, createdAt | Superclass for Owner and Doctor |
| **Owner** | gender, address | OneToMany: Pets |
| **Doctor** | name, photo, bio | ManyToOne: Clinic |
| **Pet** | name, gender, dateOfBirth, animalKind, photos, weight | ManyToOne: Owner |
| **Clinic** | name, email, phone, address, workingDays, openHour, closeHour, facebookUrl, instagramUrl, websiteUrl | OneToMany: Doctors |
| **Visit** | pet, doctor, clinic, date | ManyToOne: Pet, Doctor, Clinic |
| **AccessToken** | token, expiration | ManyToOne: User |

---

## Features
1. **User Management**
   - Roles: `OWNER`, `DOCTOR`, `ADMIN`
   - User registration
   - Manage user data

2. **Pet Management**
   - Create pets and link them to owners
   - Get pet details by ID

3. **Clinic Management**
   - Create and update clinics
   - Search clinics by phone number or address
   - Manage working hours and working days

4. **Doctor Management**
   - Create doctors and assign to a clinic
   - Assign / Deassign Doctor to/from Clinic
   - Get doctor details by ID

5. **Visit Management**
   - Schedule visits for pets with a doctor at a clinic
   - Get visit details by ID

---

## REST API Endpoints

### Owner
- `GET /api/owners/{id}/pets` → Get all pets of an owner

### Pet
- `POST /api/pets` → Create a new pet
- `GET /api/pets/{id}` → Get a pet by ID

### Clinic
- `POST /api/clinics` → Create a clinic
- `GET /api/clinics/{id}` → Get clinic by ID
- `GET /api/clinics/search?phone=&address=` → Search clinics

### Doctor
- `POST /api/doctors` → Create a doctor
- `GET /api/doctors/{id}` → Get doctor by ID
- `PUT /api/doctors/{id}/assign/{clinicId}` → Assign doctor to a clinic
- `PUT /api/doctors/{id}/deassign` → Remove doctor from clinic

### Visit
- `POST /api/visits` → Create a visit
- `GET /api/visits/{id}` → Get visit by ID

---

## Project Structure


## Postman Documentation
You can explore and test all API endpoints using the Postman collection provided [here](https://documenter.getpostman.com/view/33214421/2sB3HtEbtk).



