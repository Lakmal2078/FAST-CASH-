Fast Official Sri Lanka — Android Cashier Application

Fast Official Sri Lanka යනු Kotlin සහ Jetpack Compose මත ගොඩනගන ලද Android cashier/transaction management application එකකි. යෙදුම local transaction management, deposit/withdrawal workflows, transaction history, administrative review UI සහ multilingual user experience සඳහා නිර්මාණය කර ඇත.

«Production Notice: මෙම repository එක Android client application එකයි. Production financial/transaction processing සඳහා trusted backend, authentication, authorization, server-side validation, transaction integrity, audit logging සහ secure data storage අනිවාර්ය වේ. Android client එක backend/database එකේ source of truth ලෙස භාවිතා නොකළ යුතුය.»

---

📌 Project Overview

මෙම application එකේ ප්‍රධාන අරමුණ:

- Deposit workflow කළමනාකරණය
- Withdrawal workflow කළමනාකරණය
- Transaction history පෙන්වීම
- Local transaction persistence
- Bank/payment destination management
- Administrative transaction review UI
- Sinhala / English / Tamil language support
- Dark / Light theme support
- Android-native responsive UI

---

✨ Key Features

⚡ Deposit Management

- Player/User ID validation
- Bank/payment destination selection
- Deposit amount validation
- Transaction reference handling
- Receipt URI selection
- Duplicate reference detection
- Pending transaction tracking
- Deposit status management

Supported status values include:

PENDING
APPROVED
REJECTED
CANCELLED

💸 Withdrawal Management

- Player/User ID
- Withdrawal amount
- Bank information
- Account holder
- Account number
- Branch
- Secret-code field
- Pending withdrawal protection
- Withdrawal status tracking

Supported status values include:

PENDING
APPROVED
COMPLETED
REJECTED
CANCELLED

🌙 Dark & Light Theme

- Material 3 design system
- Dark mode
- Light mode
- Edge-to-edge UI
- Adaptive layouts
- Custom typography and color system

🌐 Multilingual UI

Application architecture supports:

- 🇱🇰 Sinhala
- 🇬🇧 English
- 🇱🇰 Tamil

📱 Transaction History

Users can review locally stored transaction records and their current local state.

🔐 Administrative Interface

The project contains an administrative UI for reviewing pending transactions.

Important: Client-side admin authentication is only a local safeguard. Production authorization MUST be performed by a trusted backend.

❓ User Guide & FAQ

The application includes user guidance and FAQ-style UI components for explaining transaction workflows.

---

🛠️ Technology Stack

Component| Technology
Language| Kotlin
UI| Jetpack Compose
Design System| Material 3
Architecture| MVVM / Clean Architecture style
Database| Room
Database Processing| KSP
Async| Kotlin Coroutines
Reactive State| Flow / StateFlow
Networking| Retrofit
HTTP Client| OkHttp
JSON| Moshi
Dependency Injection| Hilt
Navigation| Navigation Compose
Image Loading| Coil
Security| AndroidX Security / SQLCipher integration
Build| Gradle Kotlin DSL
Minification| R8 / ProGuard
Minimum Android| API 24
Target Android| API 36
Compile SDK| API 36

---

🏗️ Architecture

The application follows a layered Android architecture:

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
│ Room / DAO / Entity  │   │ Retrofit / OkHttp     │
└──────────┬───────────┘   └──────────┬───────────┘
           │                          │
           ▼                          ▼
     Local Database              Backend API

Data flow

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

---

📂 Project Structure

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

---

📚 Documentation

Complete project documentation is available under ""docs/"" (docs/README.md).

Installation & Deployment

- "Installation Guide" (docs/INSTALLATION_GUIDE.md)
- "Deployment Guide" (docs/DEPLOYMENT_GUIDE.md)
- "Environment Variables" (docs/ENVIRONMENT_VARIABLES.md)

API & Operations

- "API Documentation" (docs/API_DOCUMENTATION.md)
- "Admin Manual" (docs/ADMIN_MANUAL.md)
- "User Manual" (docs/USER_MANUAL.md)

Security & Reliability

- "Backup Guide" (docs/BACKUP_GUIDE.md)
- "Security Checklist" (docs/SECURITY_CHECKLIST.md)
- "Testing Checklist" (docs/TESTING_CHECKLIST.md)
- "Production Checklist" (docs/PRODUCTION_CHECKLIST.md)

---

🚀 Installation

Requirements

Recommended development environment:

- Android Studio
- JDK 17
- Android SDK Platform 36
- Gradle wrapper included in the repository
- Android device/emulator with API 24+

Clone

git clone https://github.com/Lakmal2078/FAST-CASH-.git
cd FAST-CASH-

Open in Android Studio

Open the repository root:

FAST-CASH-/

Allow Gradle synchronization to complete.

Build Debug APK

Linux/macOS/Termux:

./gradlew assembleDebug

Windows:

gradlew.bat assembleDebug

APK output:

app/build/outputs/apk/debug/app-debug.apk

Run tests

./gradlew test

For connected Android tests:

./gradlew connectedAndroidTest

---

📦 Release Build

Before creating a production build:

./gradlew clean
./gradlew test
./gradlew assembleRelease

For Play distribution:

./gradlew bundleRelease

Expected outputs:

app/build/outputs/apk/release/app-release.apk
app/build/outputs/bundle/release/app-release.aab

Production release signing must use a protected release keystore.

---

⚙️ Environment Configuration

The project uses environment/secret configuration for sensitive build values.

Example:

.env.example

Potential signing-related values include:

KEYSTORE_PATH=
STORE_PASSWORD=
KEY_PASSWORD=
ADMIN_PIN_HASH=

Security rule

Never commit:

.env
*.jks
*.keystore
private keys
production passwords
API secrets
authentication tokens

Use CI/CD secret storage for production credentials.

See:

"Environment Variables Guide" (docs/ENVIRONMENT_VARIABLES.md)

---

🌐 API Architecture

The Android client contains a Retrofit-based remote API layer.

Conceptually:

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

Important

The API endpoint contained in the source is currently a placeholder/example endpoint and must not be treated as a production service.

Before production:

- Configure a real HTTPS API.
- Implement authentication.
- Implement server-side authorization.
- Validate every request on the server.
- Add idempotency.
- Protect transaction state transitions.
- Add audit logging.
- Add rate limiting.
- Use secure receipt/object storage.

See:

"API Documentation" (docs/API_DOCUMENTATION.md)

---

🔐 Security

Security is a production requirement, not an optional feature.

Current security considerations

The application contains:

- Token-provider abstraction
- Authentication interceptor
- Build-time secret configuration
- R8/minification
- Android security components
- Local database protection mechanisms

However, the current client implementation alone is not sufficient for production-grade transaction authorization.

Authentication

Production requires:

User
 ↓
Authentication Service
 ↓
Short-lived access token
 ↓
Android secure storage
 ↓
HTTPS API

Authorization

Never trust:

client-side admin state
client-side transaction status
client-side amount validation
client-side user role

The backend must independently validate and authorize every sensitive operation.

Admin security

The client-side admin PIN mechanism is only a local safeguard.

Production administration should use:

- Server-side authentication
- Role-based access control
- MFA
- Short-lived sessions/tokens
- Rate limiting
- Audit logs
- Server-side authorization

Secrets

Never hard-code:

- API keys
- passwords
- admin credentials
- signing credentials
- private keys
- database credentials

---

🗄️ Data & Transaction Integrity

The Android Room database is intended for local application persistence.

For production transaction processing:

Backend Database
      ↑
 Source of Truth
      ↑
 Android Client
      ↑
 Local Cache / UX

The Android database must not be treated as the authoritative financial ledger.

Production backend operations should use:

- Atomic database transactions
- Unique constraints
- Idempotency keys
- Concurrency controls
- Server-generated transaction IDs
- Immutable audit records
- Consistent state transitions

---

📎 Receipt/File Handling

The Android client can work with receipt URIs.

For a production architecture, avoid sending private files through an unrestricted multipart endpoint.

Recommended flow:

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

The backend should enforce:

- MIME validation
- File-size limits
- Object ownership
- Content integrity
- Secure access
- Retention rules

---

🧪 Testing

Run:

./gradlew test

and:

./gradlew connectedAndroidTest

Important test categories:

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

See:

"Testing Checklist" (docs/TESTING_CHECKLIST.md)

---

🔄 CI/CD

The repository contains GitHub Actions configuration under:

.github/workflows/

Recommended production pipeline:

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

Production signing credentials must be stored as protected GitHub Actions secrets and must never be committed to the repository.

---

💾 Backup & Disaster Recovery

Local Android data should not be considered the production backup source.

Production infrastructure should provide:

- Automated database backups
- Point-in-time recovery
- Encrypted backup storage
- Retention policy
- Off-site backup strategy
- Restore testing
- Disaster recovery documentation

The release signing keystore must also have a secure backup.

See:

"Backup Guide" (docs/BACKUP_GUIDE.md)

---

📋 Production Readiness

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

Full checklist:

"Production Checklist" (docs/PRODUCTION_CHECKLIST.md)

---

🛡️ Security Checklist

Before release:

Authentication       [ ] Server-side
Authorization        [ ] Server-side
Admin Access         [ ] RBAC + MFA
API                  [ ] HTTPS
Validation           [ ] Server-side
Transactions         [ ] Atomic + Idempotent
Audit Logs           [ ] Enabled
Secrets              [ ] Protected
Database             [ ] Backups
Receipts             [ ] Secure Storage
Release Signing      [ ] Protected
R8/ProGuard          [ ] Verified
Testing              [ ] Passed
Monitoring           [ ] Enabled
Incident Response    [ ] Ready

Full checklist:

"Security Checklist" (docs/SECURITY_CHECKLIST.md)

---

👨‍💻 Development Guidelines

When contributing:

1. Keep UI logic out of repositories.
2. Keep database access inside the data layer.
3. Keep network access behind repositories/services.
4. Use ViewModels for UI state.
5. Use Kotlin Coroutines for asynchronous work.
6. Validate input at the UI layer for UX.
7. Validate input again at the backend for security.
8. Never trust client-side authorization.
9. Do not log sensitive information.
10. Add tests for security-sensitive business logic.

---

🧹 Git & Secret Hygiene

Before committing:

git status

Check for accidental secrets:

git diff --cached

Never commit:

.env
*.jks
*.keystore
local.properties
credentials
private keys
production tokens
database passwords

If a secret has already been committed, removing it from the latest commit is not sufficient. Rotate/revoke the exposed credential and clean repository history as appropriate.

---

📱 Android Compatibility

Current project configuration targets:

Minimum SDK : 24
Compile SDK : 36
Target SDK  : 36

Recommended test matrix:

API 24
Current supported Android release
Low-memory device
Small-screen device
Large-screen device
Slow network
Offline mode
Online/offline transition

---

🧭 Documentation Map

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

---

🗺️ Recommended Production Architecture

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
                    │ Rate Limiting    │
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
        │ Backup / DR     │
        └─────────────────┘

---

⚠️ Production Limitations

The Android source code should not be considered a complete production financial platform by itself.

Before production deployment, the following must be implemented and verified:

1. Trusted backend/API.
2. Real authentication.
3. Server-side authorization.
4. Secure administrator authentication.
5. Transaction concurrency protection.
6. Idempotent transaction APIs.
7. Server-side validation.
8. Secure receipt storage.
9. Audit logging.
10. Monitoring and alerting.
11. Database backup and disaster recovery.
12. Secure production secret management.

Do not use a client-side PIN, local Room database, or client-side transaction status as the sole security authority for real transactions.

---

📄 License

No explicit open-source license was identified in the supplied project documentation.

Before public distribution or accepting external contributions, add an appropriate "LICENSE" file and clearly define the project's ownership and usage terms.

---

📞 Support

For development or repository issues, use the project's GitHub repository and issue-tracking workflow.

Repository:

"Lakmal2078/FAST-CASH-" (https://github.com/Lakmal2078/FAST-CASH-)

---

📌 Project Status

Application: Android cashier/transaction client
Architecture: Kotlin + Jetpack Compose + MVVM/Clean Architecture style
Database: Room
Networking: Retrofit / OkHttp
Build: Gradle Kotlin DSL
Production status: Backend/security hardening required before production use

---

© 2026 Fast Official Sri Lanka. All rights reserved.
