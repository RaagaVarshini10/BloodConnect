# 🩸 BloodConnect — Every Drop Matters

BloodConnect is a web-based blood donation platform that connects people in need of blood with potential donors. It helps users register as donors, search for donors by blood group and city, submit emergency blood requests, and access health reports.

## ✨ Features

- **Donor Registration:** Register with personal details, blood group, city, and availability.
- **Donor Search:** Find potential donors based on blood group and city.
- **Emergency Blood Requests:** Submit requests with blood group, hospital, location, and urgency.
- **Website Alerts:** View emergency blood request alerts directly on the website.
- **Health Report Management:** Upload and download health reports using secure access keys.
- **Notification Logging:** Record mock SMS and WhatsApp notification attempts in MySQL for demonstration.
- **Docker Support:** Run the backend and database using Docker Compose.

## 🛠️ Tech Stack

- **Backend:** Java, Java HttpServer
- **Database:** MySQL
- **Database Connectivity:** JDBC
- **Frontend:** HTML, CSS, JavaScript
- **Database Driver:** MySQL Connector/J
- **Containerization:** Docker, Docker Compose

## 📁 Project Structure

```text
BloodConnect/
├── backend/
│   ├── src/
│   │   ├── Main.java
│   │   ├── Database.java
│   │   ├── Donor.java
│   │   ├── RegisterHandler.java
│   │   ├── SearchHandler.java
│   │   ├── EmergencyRequestHandler.java
│   │   ├── HealthReportHandler.java
│   │   ├── NotificationService.java
│   │   └── Utils.java
│   ├── lib/
│   └── Dockerfile
├── database/
│   └── bloodconnect.sql
├── frontend/
│   ├── index.html
│   ├── register.html
│   ├── search.html
│   └── css/
│       └── style.css
├── docker-compose.yml
└── README.md
```

## ⚙️ Prerequisites

- Java Development Kit (JDK) 21
- Docker Desktop with Docker Compose
- Git

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
cd BloodConnect
```

### 2. Start the application

Make sure Docker Desktop is running, then execute:

```bash
docker compose up --build -d
```

Check the container status:

```bash
docker compose ps
```

### 3. Open the application

Open the homepage in your browser using the frontend URL configured by the application.

The backend uses port `8080`. MySQL is configured to use host port `3307` in the development setup.

### 4. View application logs

```bash
docker compose logs -f backend
```

### 5. Stop the application

```bash
docker compose down
```

To preserve your database and uploaded reports, do not remove the Docker volumes when stopping the application.

## 🗄️ Database

BloodConnect uses MySQL to store donor information, emergency blood requests, health report metadata, and notification logs.

The database schema is available in `database/bloodconnect.sql`.

## 🔔 Website Alerts and Notifications

The Alerts page displays emergency blood request information through the website.

SMS and WhatsApp notification logging currently uses **mock mode** for demonstration. Mock records indicate that notification attempts were logged; they do not confirm real message delivery.

## 🔐 Security Notes

- Do not commit database passwords, API tokens, or other secrets to GitHub.
- Use environment variables or a local `.env` file for credentials, and exclude `.env` from version control.
- Do not commit uploaded health reports or private donor information.
- Health reports should be accessed only by authorized users with valid access keys.
- Use appropriate access controls before deploying the application publicly.

## 🧪 Testing

The application has been tested for key workflows, including donor search, emergency request submission, health report upload/download, and mock notification logging.

Website alerts have also been tested for displaying emergency requests and retaining them after refreshing the page.

## 🔮 Future Enhancements

- Real SMS integration with a supported messaging provider.
- Browser push notifications.
- Donor availability updates.
- Improved authentication and role-based access control.
- Deployment to a cloud hosting platform.

## ❤️ Purpose

BloodConnect aims to make finding potential blood donors easier by connecting people through a simple, accessible web platform.

**Every drop matters. Every donor counts.**