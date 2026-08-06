# Fast Cash Android — Technical Documentation

> **Scope:** This documentation is based on the supplied `FAST-CASH--1.0.0` Android source archive. It describes the software as a cashier/transaction application and intentionally avoids operational instructions for gambling or betting services.

## Project status

This repository is an **Android client**, not a complete production backend.

Important findings from the supplied source:

- Kotlin + Jetpack Compose + Material 3.
- MVVM/Clean Architecture style with Hilt dependency injection.
- Room is used for local persistence.
- Retrofit + OkHttp + Moshi are prepared for remote API calls.
- The configured Retrofit base URL is currently `https://api.fastxbet.example.com/`, which is a placeholder and must not be treated as a production endpoint.
- `DefaultTokenProvider` returns `null`; therefore production authentication is **not implemented by default**.
- Local admin authentication uses a SHA-256 PIN hash and is explicitly documented in the source as a weak safeguard.
- Release minification/R8 is enabled.
- The project contains unit/instrumentation tests covering validation, authentication headers, and transaction safeguards.

## Main capabilities

- User/player ID storage.
- Bank/payment destination selection.
- Deposit submission with optional receipt URI and reference.
- Withdrawal submission with bank/account details.
- Local transaction history.
- Pending transaction queues.
- Local admin view for reviewing pending deposits/withdrawals.
- Sinhala/English language state in the local user model.
- Local Room database.
- Optional remote submission through Retrofit.

## Architecture

```text
Compose UI
   |
CashierViewModel
   |
Use Cases
   |
CashierRepository
   |--------------------|
LocalDataSource      RemoteRepository
   |                    |
Room / DAOs          Retrofit / OkHttp
   |
SQLite database
```

## Important production limitation

The source archive does **not** contain a production server, server database, real authentication service, or transaction settlement engine.

Before production use, implement a trusted backend that owns:

1. Authentication and authorization.
2. Server-side validation.
3. Idempotency.
4. Transaction state transitions.
5. Audit logging.
6. Authorization checks for every admin action.
7. Secure receipt/file storage.
8. Rate limiting and abuse prevention.
9. Database backups and disaster recovery.

See the other documents in this package for the required controls.

## Documentation index

- [Installation Guide](INSTALLATION_GUIDE.md)
- [Deployment Guide](DEPLOYMENT_GUIDE.md)
- [Environment Variables](ENVIRONMENT_VARIABLES.md)
- [API Documentation](API_DOCUMENTATION.md)
- [Admin Manual](ADMIN_MANUAL.md)
- [User Manual](USER_MANUAL.md)
- [Backup Guide](BACKUP_GUIDE.md)
- [Security Checklist](SECURITY_CHECKLIST.md)
- [Testing Checklist](TESTING_CHECKLIST.md)
- [Production Checklist](PRODUCTION_CHECKLIST.md)

## License / ownership

No license file was identified in the supplied archive. Add an explicit license before distributing the source.
