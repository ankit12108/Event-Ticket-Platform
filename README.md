# 🎟️ Event Ticket Platform

A full-stack event management & ticketing system enabling:  
👨‍💼 **Organizers** – create & manage events  
🎫 **Attendees** – browse & purchase tickets  
🛂 **Event Staff** – validate tickets via QR scanning  

---

## 🌐 System Architecture

| Layer | Technology |
|-------|------------|
| Frontend | Flutter (Android / iOS / Web) |
| Backend | Spring Boot |
| Security | Spring Security + OAuth2 |
| Authentication | Keycloak |
| Database | PostgreSQL |
| Object Mapping | MapStruct |
| Containerization | Docker |

---

## ✨ Features

### 👨‍💼 Organizer
- Create, update & publish events
- Configure ticket types
- Real-time ticket sales dashboard
- Export attendee and validation reports

### 🎫 Attendee
- Browse all published events
- Secure ticket purchase
- Digital tickets with QR code
- Download purchased tickets anytime

### 🛂 Staff
- QR scanning for entry validation
- Instant result: Valid / Invalid / Already-used / Expired
- Manual validation fallback
- Designed for fast queue flow

---

## 🔗 REST API Overview (Examples)

| Method | Endpoint | Purpose |
|--------|----------|---------|
| POST | `/api/v1/events` | Create event |
| GET | `/api/v1/published-events` | Browse available events |
| POST | `/api/v1/published-event/{eventId}/ticket-types/{typeId}` | Purchase ticket |
| GET | `/api/v1/tickets/{ticketId}` | View purchased ticket |
| GET | `/api/v1/tickets/{ticketId}/qr-codes` | Fetch QR code |
| POST | `/api/v1/events/{eventId}/ticket-validations` | Validate ticket at gate |

---

## 🚀 Getting Started

### ▶️ Run Backend
```bash
mvn spring-boot:run
```
---

## 🛣️ Roadmap

| Status | Planned Feature |
|--------|-----------------|
| 🔄 In Progress | User roles & permissions |
| 📌 Next | Payment Gateway (Razorpay / Stripe) |
| 📌 Next | Email / notification service |
| 📌 Next | Offline QR scanning |
| 🚀 Future | Event analytics dashboard |

---
## ⭐ Appreciation

| Message |
|--------|
| If this project helped you or inspired you, please star ⭐ the repository — it really motivates! |

---
## 💬 Support

| Type | Where |
|------|-------|
| 🐞 Bug Report | GitHub Issues |
| 💡 Feature Request | GitHub Discussions |
| ❓ Questions | GitHub Q&A |

---

## 🤝 Contributing

| Step | Action |
|------|--------|
| 1 | Fork the repository |
| 2 | Create a feature branch |
| 3 | Commit your changes |
| 4 | Submit a Pull Request |

---
