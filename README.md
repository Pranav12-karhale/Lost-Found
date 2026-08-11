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
    <img src="https://img.shields.io/badge/Render-Ready-black.svg" alt="Render" />
  </p>
</div>

<hr />

## ✨ Features

- **📊 Interactive Dashboard**: Real-time statistics of total lost items, found items, and successful matches.
- **📝 Report Lost Items**: Easily submit lost item reports with categories, location tracking, dates, and photo uploads.
- **🕵️ Report Found Items**: Help the community by logging items you've found, including comprehensive descriptions and images.
- **🔍 Advanced Search System**: Filter and search through the entire database by keyword, category, or status (Lost/Found).
- **☁️ Cloud & Docker Ready**: Instantly deployable locally via Docker Compose or on the cloud via Render (Infrastructure as Code).
- **🎨 Premium UI/UX**: Designed with a sleek, responsive interface featuring modern CSS, glassmorphism, and micro-animations.

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
- Render Blueprint (`render.yaml`)

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

## ☁️ Cloud Deployment (Render.com)

This project is fully configured for a **1-Click Cloud Deployment** on [Render](https://render.com) utilizing the free tier. 

1. Create a free account on **Render.com**.
2. Go to your Dashboard and click **New +** -> **Blueprint**.
3. Connect your GitHub account and select this repository.
4. Render will automatically read the `render.yaml` file and provision:
   - A **Managed PostgreSQL Database**.
   - A **Web Service** (Spring Boot Docker container).
   - A persistent disk volume for image uploads.
5. Click **Apply** and wait for the build to finish!

Your app will be live and accessible via a public URL (e.g., `https://lost-and-found-web.onrender.com`).

---

## 📸 Screenshots
*(Add your beautiful screenshots here by dragging and dropping them into the README editor on GitHub!)*

---

## 🤝 Contributing
Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/Pranav12-karhale/Lost-Found/issues).

<div align="center">
  <p>Made with ❤️ by Pranav</p>
</div>
