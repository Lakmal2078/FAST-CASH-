<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-1.9-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white" alt="Kotlin"/>
  <img src="https://img.shields.io/badge/Jetpack%20Compose-1.6-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white" alt="Jetpack Compose"/>
  <img src="https://img.shields.io/badge/Material%203-Design-34A853?style=for-the-badge&logo=materialdesign&logoColor=white" alt="Material 3"/>
  <img src="https://img.shields.io/badge/Android-24%2B-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Android"/>
  <img src="https://img.shields.io/badge/Architecture-MVVM%20%7C%20Clean-EA4335?style=for-the-badge" alt="Architecture"/>
</p>

<h1 align="center">Fast Official Sri Lanka — Android Cashier Application</h1>

<p align="center">
  An Android cashier / transaction management application built with <strong>Kotlin</strong> and <strong>Jetpack Compose</strong>.<br/>
  Designed for local transaction management, deposit/withdrawal workflows, transaction history, administrative review UI, and a multilingual user experience.
</p>

> [!WARNING]
> ## Production Notice
> This repository is the **Android client application only**. For production financial/transaction processing, a trusted backend, authentication, authorization, server-side validation, transaction integrity, audit logging, and secure data storage are **mandatory**. The Android client must **not** be used as the source of truth for the backend/database.

---

## 📋 Table of Contents

- [📌 Project Overview](#-project-overview)
- [✨ Key Features](#-key-features)
- [🛠️ Technology Stack](#️-technology-stack)
- [🏗️ Architecture](#️-architecture)
- [📂 Project Structure](#-project-structure)
- [📚 Documentation](#-documentation)
- [🚀 Installation](#-installation)
- [📦 Release Build](#-release-build)
- [⚙️ Environment Configuration](#️-environment-configuration)
- [🌐 API Architecture](#-api-architecture)
- [🔐 Security](#-security)
- [🗄️ Data & Transaction Integrity](#️-data--transaction-integrity)
- [📎 Receipt / File Handling](#-receipt--file-handling)
- [🧪 Testing](#-testing)
- [🔄 CI/CD](#-cicd)
- [💾 Backup & Disaster Recovery](#-backup--disaster-recovery)
- [📋 Production Readiness](#-production-readiness)
- [🛡️ Security Checklist](#️-security-checklist)
- [👨‍💻 Development Guidelines](#-development-guidelines)
- [🧹 Git & Secret Hygiene](#-git--secret-hygiene)
- [📱 Android Compatibility](#-android-compatibility)
- [🗺️ Recommended Production Architecture](#️-recommended-production-architecture)
- [⚠️ Production Limitations](#️-production-limitations)
- [📄 License](#-license)
- [📞 Support](#-support)
- [📌 Project Status](#-project-status)

---

## 📌 Project Overview

The primary goals of this application:

- ✅ Deposit workflow management
- ✅ Withdrawal workflow management
- ✅ Transaction history display
- ✅ Local transaction persistence
- ✅ Bank / payment destination management
- ✅ Administrative transaction review UI
- ✅ Sinhala / English / Tamil language support
- ✅ Dark / Light theme support
- ✅ Android-native responsive UI

---

## ✨ Key Features

### ⚡ Deposit Management

- Player/User ID validation
- Bank/payment destination selection
- Deposit amount validation
- Transaction reference handling
- Receipt URI selection
- Duplicate reference detection
- Pending transaction tracking
- Deposit status management

**Supported status values:**

```text
PENDING → APPROVED | REJECTED | CANCELLED
```

### 💸 Withdrawal Management

- Player/User ID
- Withdrawal amount
- Bank information
  - Account holder
  - Account number
  - Branch
- Secret-code field
- Pending withdrawal protection
- Withdrawal status tracking

**Supported status values:**

```text
PENDING → APPROVED | COMPLETED | REJECTED | CANCELLED
```

### 🌙 Dark & Light Theme

- Material 3 design system
- Dark mode
- Light mode
- Edge-to-edge UI
- Adaptive layouts
- Custom typography and color system

### 🌐 Multilingual UI

The application architecture supports:

| Flag | Language |
| :--: | :-- |
| 🇱🇰 | Sinhala |
| 🇬🇧 | English |
| 🇱🇰 | Tamil |

### 📱 Transaction History

Users can review locally stored transaction records and their current local state.

### 🔐 Administrative Interface

The project contains an administrative UI for reviewing pending transactions.

> [!IMPORTANT]
> Client-side admin authentication is only a **local safeguard**. Production authorization **MUST** be performed by a trusted backend.

### ❓ User Guide & FAQ

The application includes user guidance and FAQ-style UI components for explaining transaction workflows.

---

## 🛠️ Technology Stack

| Component | Technology |
| :-- | :-- |
| **Language** | Kotlin |
| **UI** | Jetpack Compose |
| **Design System** | Material 3 |
| **Architecture** | MVVM / Clean Architecture style |
| **Database** | Room |
| **Database Processing** | KSP |
| **Async** | Kotlin Coroutines |
| **Reactive State** | Flow / StateFlow |
| **Networking** | Retrofit |
| **HTTP Client** | OkHttp |
| **JSON** | Moshi |
| **Dependency Injection** | Hilt |
| **Navigation** | Navigation Compose |
| **Image Loading** | Coil |
| **Security** | AndroidX Security / SQLCipher integration |
| **Build** | Gradle Kotlin DSL |
| **Minification** | R8 / ProGuard |
| **Minimum Android** | API 24 |
| **Target Android** | API 36 |
| **Compile SDK** | API 36 |

---

## 🏗️ Architecture

The application follows a layered Android architecture:

```text
┌──────────────────────────────────────────┐
│              Jetpack Compose             │
│              UI / Screens                │
└────────────────────┬─────────────────────┘
                     │
                     ▼
┌──────────────────────────────────────────┐
│              ViewModel Layer             │
│          CashierViewModel / State        │
└────────────────────┬─────────────────────┘
                     │
                     ▼
┌──────────────────────────────────────────┐
│             Repository Layer             │
│           CashierRepository              │
└───────────────┬──────────────────┬───────┘
                │                  │
                ▼                  ▼
┌──────────────────────┐   ┌──────────────────────┐
│     Local Data       │   │      Remote API      │
│                      │   │                      │
│ Room / DAO / Entity  │   │  Retrofit / OkHttp   │
└──────────┬───────────┘   └──────────┬───────────┘
           │                          │
           ▼                          ▼
     Local Database              Backend API
```

### Data Flow

```text
UI
 ↓
ViewModel
 ↓
Use case / Repository
 ↓
Local database / Remote API
 ↓
Result
 ↓
StateFlow
 ↓
Compose UI
```

---

## 📂 Project Structure

```text
FAST-CASH-/
│
├── app/
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── com/example/
│       │   │       ├── data/
│       │   │       │   ├── CashierRepository.kt
│       │   │       │   └── local/
│       │   │       │       ├── AppDatabase.kt
│       │   │       │       ├── dao/
│       │   │       │       └── entity/
│       │   │       │
│       │   │       └── ui/
│       │   │           ├── components/
│       │   │           ├── screens/
│       │   │           ├── theme/
│       │   │           └── viewmodel/
│       │   │
│       │   └── res/
│       │
│       └── test/
│
├── docs/
│   ├── README.md
│   ├── INSTALLATION_GUIDE.md
│   ├── DEPLOYMENT_GUIDE.md
│   ├── ENVIRONMENT_VARIABLES.md
│   ├── API_DOCUMENTATION.md
│   ├── ADMIN_MANUAL.md
│   ├── USER_MANUAL.md
│   ├── BACKUP_GUIDE.md
│   ├── SECURITY_CHECKLIST.md
│   ├── TESTING_CHECKLIST.md
│   └── PRODUCTION_CHECKLIST.md
│
├── gradle/
├── .github/
├── .env.example
├── .gitignore
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
└── README.md
```

---

## 📚 Documentation

Complete project documentation is available under [`docs/`](docs/README.md).

### Installation & Deployment

- [Installation Guide](docs/INSTALLATION_GUIDE.md)
- [Deployment Guide](docs/DEPLOYMENT_GUIDE.md)
- [Environment Variables](docs/ENVIRONMENT_VARIABLES.md)

### API & Operations

- [API Documentation](docs/API_DOCUMENTATION.md)
- [Admin Manual](docs/ADMIN_MANUAL.md)
- [User Manual](docs/USER_MANUAL.md)

### Security & Reliability

- [Backup Guide](docs/BACKUP_GUIDE.md)
- [Security Checklist](docs/SECURITY_CHECKLIST.md)
- [Testing Checklist](docs/TESTING_CHECKLIST.md)
- [Production Checklist](docs/PRODUCTION_CHECKLIST.md)

---

## 🚀 Installation

### Requirements

Recommended development environment:

- Android Studio
- JDK 17
- Android SDK Platform 36
- Gradle wrapper (included in the repository)
- Android device/emulator with API 24+

### Clone

```bash
git clone https://github.com/Lakmal2078/FAST-CASH-.git
cd FAST-CASH-
```

### Open in Android Studio

Open the repository root:

```text
FAST-CASH-/
```

Allow Gradle synchronization to complete.

### Build Debug APK

**Linux / macOS / Termux:**

```bash
./gradlew assembleDebug
```

**Windows:**

```bash
gradlew.bat assembleDebug
```

**APK output:**

```text
app/build/outputs/apk/debug/app-debug.apk
```

### Run Tests

```bash
./gradlew test
```

For connected Android tests:

```bash
./gradlew connectedAndroidTest
```

---

## 📦 Release Build

Before creating a production build:

```bash
./gradlew clean
./gradlew test
./gradlew assembleRelease
```

For Play distribution:

```bash
./gradlew bundleRelease
```

**Expected outputs:**

```text
app/build/outputs/apk/release/app-release.apk
app/build/outputs/bundle/release/app-release.aab
```

> [!IMPORTANT]
> Production release signing must use a **protected release keystore**.

---

## ⚙️ Environment Configuration

The project uses environment/secret configuration for sensitive build values.

**Example:** `.env.example`

Potential signing-related values include:

```env
KEYSTORE_PATH=
STORE_PASSWORD=
KEY_PASSWORD=
ADMIN_PIN_HASH=
```

> [!WARNING]
> ### Security rule
> Never commit:
> - `.env`
> - `*.jks`
> - `*.keystore`
> - private keys
> - production passwords
> - API secrets
> - authentication tokens
>
> Use CI/CD secret storage for production credentials.

**See:** [Environment Variables Guide](docs/ENVIRONMENT_VARIABLES.md)

---

## 🌐 API Architecture

The Android client contains a Retrofit-based remote API layer. Conceptually:

```text
Android App
    │
    │ HTTPS
    ▼
Production API
    │
    ├── Authentication
    ├── Authorization
    ├── Validation
    ├── Transaction processing
    ├── Audit logging
    └── Database
```

> [!IMPORTANT]
> The API endpoint contained in the source is currently a **placeholder/example** endpoint and must **not** be treated as a production service.

### Before Production

- [ ] Configure a real HTTPS API
- [ ] Implement authentication
- [ ] Implement server-side authorization
- [ ] Validate every request on the server
- [ ] Add idempotency
- [ ] Protect transaction state transitions
- [ ] Add audit logging
- [ ] Add rate limiting
- [ ] Use secure receipt/object storage

**See:** [API Documentation](docs/API_DOCUMENTATION.md)

---

## 🔐 Security

> [!NOTE]
> Security is a **production requirement**, not an optional feature.

### Current Security Considerations

The application contains:

- Token-provider abstraction
- Authentication interceptor
- Build-time secret configuration
- R8/minification
- Android security components
- Local database protection mechanisms

However, the current client implementation alone is **not sufficient** for production-grade transaction authorization.

### Authentication

Production requires:

```text
User
 ↓
Authentication Service
 ↓
Short-lived access token
 ↓
Android secure storage
 ↓
HTTPS API
```

### Authorization

Never trust:

- ❌ Client-side admin state
- ❌ Client-side transaction status
- ❌ Client-side amount validation
- ❌ Client-side user role

The backend must independently validate and authorize every sensitive operation.

### Admin Security

The client-side admin PIN mechanism is only a **local safeguard**. Production administration should use:

- Server-side authentication
- Role-based access control (RBAC)
- Multi-factor authentication (MFA)
- Short-lived sessions/tokens
- Rate limiting
- Audit logs
- Server-side authorization

### Secrets

Never hard-code:

- API keys
- Passwords
- Admin credentials
- Signing credentials
- Private keys
- Database credentials

---

## 🗄️ Data & Transaction Integrity

The Android Room database is intended for **local application persistence**. For production transaction processing:

```text
Backend Database
       ↑
  Source of Truth
       ↑
  Android Client
       ↑
  Local Cache / UX
```

> [!WARNING]
> The Android database must **not** be treated as the authoritative financial ledger.

Production backend operations should use:

- Atomic database transactions
- Unique constraints
- Idempotency keys
- Concurrency controls
- Server-generated transaction IDs
- Immutable audit records
- Consistent state transitions

---

## 📎 Receipt / File Handling

The Android client can work with receipt URIs. For a production architecture, avoid sending private files through an unrestricted multipart endpoint.

**Recommended flow:**

```text
Android Client
    │
    │ Request upload authorization
    ▼
Backend API
    │
    │ Presigned upload URL
    ▼
Object Storage
    │
    │ Verified metadata
    ▼
Backend Transaction Record
```

The backend should enforce:

- MIME validation
- File-size limits
- Object ownership
- Content integrity
- Secure access
- Retention rules

---

## 🧪 Testing

Run:

```bash
./gradlew test
```

and:

```bash
./gradlew connectedAndroidTest
```

**Important test categories:**

- Input validation
- Deposit validation
- Withdrawal validation
- Duplicate transaction prevention
- Authentication behavior
- API failures
- Network failures
- Database operations
- Transaction state transitions
- Admin authorization
- UI navigation
- Configuration changes
- Offline/online behavior
- Security controls

**See:** [Testing Checklist](docs/TESTING_CHECKLIST.md)

---

## 🔄 CI/CD

The repository contains GitHub Actions configuration under:

```text
.github/workflows/
```

**Recommended production pipeline:**

```text
Git Push
  ↓
GitHub Actions
  ↓
Compile
  ↓
Unit Tests
  ↓
Static Analysis
  ↓
Security / Dependency Scan
  ↓
Release Build
  ↓
Artifact Verification
  ↓
Controlled Deployment
```

> [!IMPORTANT]
> Production signing credentials must be stored as **protected GitHub Actions secrets** and must never be committed to the repository.

---

## 💾 Backup & Disaster Recovery

> [!WARNING]
> Local Android data should **not** be considered the production backup source.

Production infrastructure should provide:

- Automated database backups
- Point-in-time recovery
- Encrypted backup storage
- Retention policy
- Off-site backup strategy
- Restore testing
- Disaster recovery documentation

The release signing keystore must also have a secure backup.

**See:** [Backup Guide](docs/BACKUP_GUIDE.md)

---

## 📋 Production Readiness

Before production deployment, verify:

- [ ] Real production API configured
- [ ] HTTPS enforced
- [ ] Authentication implemented
- [ ] Backend authorization implemented
- [ ] Admin RBAC implemented
- [ ] MFA implemented for privileged users
- [ ] Server-side validation implemented
- [ ] Idempotency implemented
- [ ] Atomic transaction processing implemented
- [ ] Audit logging implemented
- [ ] Secure receipt storage implemented
- [ ] Database backups configured
- [ ] Restore procedure tested
- [ ] Release keystore protected
- [ ] No secrets committed
- [ ] R8/ProGuard verified
- [ ] Automated tests passing
- [ ] Security review completed
- [ ] Monitoring configured
- [ ] Incident-response procedure documented
- [ ] Rollback strategy tested

**Full checklist:** [Production Checklist](docs/PRODUCTION_CHECKLIST.md)

---

## 🛡️ Security Checklist

Before release:

| Control | Requirement | Status |
| :-- | :-- | :--: |
| **Authentication** | Server-side | ☐ |
| **Authorization** | Server-side | ☐ |
| **Admin Access** | RBAC + MFA | ☐ |
| **API** | HTTPS | ☐ |
| **Validation** | Server-side | ☐ |
| **Transactions** | Atomic + Idempotent | ☐ |
| **Audit Logs** | Enabled | ☐ |
| **Secrets** | Protected | ☐ |
| **Database** | Backups | ☐ |
| **Receipts** | Secure Storage | ☐ |
| **Release Signing** | Protected | ☐ |
| **R8/ProGuard** | Verified | ☐ |
| **Testing** | Passed | ☐ |
| **Monitoring** | Enabled | ☐ |
| **Incident Response** | Ready | ☐ |

**Full checklist:** [Security Checklist](docs/SECURITY_CHECKLIST.md)

---

## 👨‍💻 Development Guidelines

When contributing:

- Keep UI logic **out** of repositories.
- Keep database access inside the **data layer**.
- Keep network access behind **repositories/services**.
- Use **ViewModels** for UI state.
- Use **Kotlin Coroutines** for asynchronous work.
- Validate input at the **UI layer** for UX.
- Validate input again at the **backend** for security.
- **Never** trust client-side authorization.
- Do **not** log sensitive information.
- Add tests for security-sensitive business logic.

---

## 🧹 Git & Secret Hygiene

Before committing:

```bash
git status
```

Check for accidental secrets:

```bash
git diff --cached
```

**Never commit:**

- `.env`
- `*.jks`
- `*.keystore`
- `local.properties`
- credentials
- private keys
- production tokens
- database passwords

> [!CAUTION]
> If a secret has already been committed, removing it from the latest commit is **not sufficient**. Rotate/revoke the exposed credential and clean repository history as appropriate.

---

## 📱 Android Compatibility

Current project configuration targets:

| Property | Value |
| :-- | :-- |
| **Minimum SDK** | 24 |
| **Compile SDK** | 36 |
| **Target SDK** | 36 |

**Recommended test matrix:**

- API 24
- Current supported Android release
- Low-memory device
- Small-screen device
- Large-screen device
- Slow network
- Offline mode
- Online/offline transition

---

## 🧭 Documentation Map

```text
docs/
│
├── README.md
│
├── INSTALLATION_GUIDE.md
│   └── Development setup and installation
│
├── DEPLOYMENT_GUIDE.md
│   └── Release and deployment process
│
├── ENVIRONMENT_VARIABLES.md
│   └── Build and secret configuration
│
├── API_DOCUMENTATION.md
│   └── API contract and production requirements
│
├── ADMIN_MANUAL.md
│   └── Administrative interface
│
├── USER_MANUAL.md
│   └── Application user guide
│
├── BACKUP_GUIDE.md
│   └── Backup and recovery
│
├── SECURITY_CHECKLIST.md
│   └── Security controls
│
├── TESTING_CHECKLIST.md
│   └── QA and testing
│
└── PRODUCTION_CHECKLIST.md
    └── Production readiness
```

---

## 🗺️ Recommended Production Architecture

```text
                 ┌──────────────────┐
                 │   Android App    │
                 │ Kotlin / Compose │
                 └────────┬─────────┘
                          │
                      HTTPS/TLS
                          │
                          ▼
                 ┌──────────────────┐
                 │   API Gateway    │
                 │  Rate Limiting   │
                 └────────┬─────────┘
                          │
                          ▼
                 ┌──────────────────┐
                 │ Backend Service  │
                 │ Auth / RBAC      │
                 │ Validation       │
                 │ Idempotency      │
                 │ Audit            │
                 └──────┬─────┬─────┘
                        │     │
              ┌─────────┘     └─────────┐
              ▼                         ▼
     ┌─────────────────┐       ┌─────────────────┐
     │ Production DB   │       │ Object Storage  │
     │ Transactions    │       │ Receipts        │
     └────────┬────────┘       └─────────────────┘
              │
              ▼
     ┌─────────────────┐
     │  Backup / DR    │
     └─────────────────┘
```

---

## ⚠️ Production Limitations

The Android source code should **not** be considered a complete production financial platform by itself. Before production deployment, the following must be implemented and verified:

1. Trusted backend/API
2. Real authentication
3. Server-side authorization
4. Secure administrator authentication
5. Transaction concurrency protection
6. Idempotent transaction APIs
7. Server-side validation
8. Secure receipt storage
9. Audit logging
10. Monitoring and alerting
11. Database backup and disaster recovery
12. Secure production secret management

> [!CAUTION]
> Do **not** use a client-side PIN, local Room database, or client-side transaction status as the sole security authority for real transactions.

---

## 📄 License

No explicit open-source license was identified in the supplied project documentation. Before public distribution or accepting external contributions, add an appropriate `LICENSE` file and clearly define the project's ownership and usage terms.

---

## 📞 Support

For development or repository issues, use the project's GitHub repository and issue-tracking workflow.

**Repository:** [Lakmal2078/FAST-CASH-](https://github.com/Lakmal2078/FAST-CASH-)

---

## 📌 Project Status

| Aspect | Detail |
| :-- | :-- |
| **Application** | Android cashier/transaction client |
| **Architecture** | Kotlin + Jetpack Compose + MVVM/Clean Architecture style |
| **Database** | Room |
| **Networking** | Retrofit / OkHttp |
| **Build** | Gradle Kotlin DSL |
| **Production Status** | ⚠️ Backend/security hardening required before production use |

---

<p align="center">
  <sub>© 2026 Fast Official Sri Lanka. All rights reserved.</sub>
</p>
