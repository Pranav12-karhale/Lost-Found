<div align="center">
  <h1>🔍 Lost & Found Management System</h1>
  <p>
    <strong>A modern, full-stack Spring Boot web application to help communities track, report, and recover lost and found items.</strong>
  </p>

  <!-- Badges -->
  <p>
    <img src="https://img.shields.io/badge/Java-17-orange.svg" alt="Java 17" />
    <img src="https://img.shields.io/badge/Spring_Boot-3.1-brightgreen.svg" alt="Spring Boot" />
    <img src="https://img.shields.io/badge/PostgreSQL-15-blue.svg" alt="PostgreSQL" />
    <img src="https://img.shields.io/badge/Docker-Enabled-blue.svg" alt="Docker" />
  </p>
</div>

<hr />

## ✨ Features

- **📊 Interactive Dashboard**: Real-time statistics of total lost items, found items, and successful matches.
- **📝 Report Lost Items**: Easily submit lost item reports with categories, location tracking, dates, and photo uploads.
- **🕵️ Report Found Items**: Help the community by logging items you've found, including comprehensive descriptions and images.
- **🔍 Advanced Search System**: Filter and search through the entire database by keyword, category, or status (Lost/Found).
- **🎨 Premium UI/UX**: Designed with a sleek, responsive interface featuring modern CSS, glassmorphism, and micro-animations.

---

## 🏗️ System Architecture

The application follows a standard modern, layered **MVC (Model-View-Controller)** architectural pattern.

### 🧩 High-Level Component Diagram

```mermaid
graph TD
    Client["📱 Web Browser / Client"]
    
    subgraph "Spring Boot Application"
        Controller["🎮 WebController\n(Handles HTTP Requests)"]
        Service["⚙️ FileService\n(Business Logic / Uploads)"]
        Repository["🗄️ JPA Repositories\n(Data Access Layer)"]
        Model["📦 Entity Models\n(LostItem, FoundItem)"]
    end
    
    Database[("🐘 PostgreSQL Database")]
    Disk[("📁 Local File System\nUploads")]

    Client <-->|HTTP GET / POST| Controller
    Controller -->|Calls| Service
    Controller -->|Uses| Model
    Controller <-->|CRUD Operations| Repository
    
    Service -->|Saves Images| Disk
    Repository <-->|Hibernate / SQL| Database
```

### 🔄 Data Flow: Reporting a Lost Item

```mermaid
sequenceDiagram
    participant User as "👤 User"
    participant View as "🖥️ Thymeleaf View"
    participant Controller as "🎮 WebController"
    participant Service as "⚙️ FileService"
    participant Repo as "🗄️ LostItemRepository"
    participant DB as "🐘 Database"

    User->>View: Fills out "Report Lost" form & attaches image
    View->>Controller: POST /report-lost (multipart/form-data)
    Controller->>Service: saveFile(image)
    Service-->>Controller: Returns saved image path
    Controller->>Controller: Creates LostItem Entity
    Controller->>Repo: save(LostItem)
    Repo->>DB: INSERT INTO lost_items...
    DB-->>Repo: Success
    Repo-->>Controller: Saved Entity
    Controller-->>View: Redirect to /report-lost
    View-->>User: Displays updated list of lost items
```

---

## 🛠️ Technology Stack

**Backend Framework:**
- Java 17
- Spring Boot 3
- Spring Data JPA (Hibernate)
- Spring MVC

**Frontend:**
- Thymeleaf (Server-side rendering)
- HTML5 / Vanilla CSS3 (Custom Premium Design)

**Database & Infrastructure:**
- PostgreSQL
- Docker & Docker Compose

---

## 🚀 Getting Started (Local Development)

The easiest way to run the application locally is by using **Docker**. This will automatically provision both the Spring Boot web server and the PostgreSQL database.

### Prerequisites
- [Docker & Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running.

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Pranav12-karhale/Lost-Found.git
   cd Lost-Found
   ```

2. **Run with Docker Compose**
   ```bash
   docker-compose up --build
   ```

3. **Access the Application**
   Open your browser and navigate to:
   👉 **`http://localhost:8080`**

*(To stop the application, press `Ctrl + C` in the terminal and run `docker-compose down`)*

---

## 📸 Screenshots
*(Add your beautiful screenshots here by dragging and dropping them into the README editor on GitHub!)*

---

## 🤝 Contributing
Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/Pranav12-karhale/Lost-Found/issues).

<div align="center">
  <p>Made with ❤️ by Pranav</p>
</div>
