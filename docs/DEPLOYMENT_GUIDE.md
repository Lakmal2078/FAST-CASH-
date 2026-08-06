# Deployment Guide

## Deployment model

The supplied project is an Android client. It does not include a deployable backend.

Production deployment therefore has two separate tracks:

1. **Android application release**
2. **Trusted backend/API deployment**

Do not expose a private database directly to the Android client.

## A. Backend deployment requirements

A production backend should provide:

- HTTPS-only API.
- Authentication and role-based authorization.
- Server-side validation.
- Transaction/idempotency controls.
- Persistent database.
- Secure receipt/object storage.
- Audit log.
- Monitoring and alerting.
- Rate limiting.
- Backup and restore procedures.
- Secret management.

The Android client should communicate only with the API.

## B. Configure the Android API endpoint

The current source hard-codes the Retrofit base URL in `AppModule.kt`.

Before release, replace this design with a build-time/environment-specific configuration such as:

```text
debug -> staging API
release -> production API
```

Do not silently ship a placeholder domain.

## C. Release signing

The Gradle file reads:

```text
KEYSTORE_PATH
STORE_PASSWORD
KEY_PASSWORD
```

Use a dedicated release keystore stored outside source control.

Recommended process:

1. Create/obtain the release keystore.
2. Store it in a protected CI secret/file store.
3. Inject credentials only during CI release builds.
4. Restrict access to the signing key.
5. Back up the keystore securely.
6. Never commit `.jks`, passwords, or recovery material.

## D. Build a release APK

```bash
./gradlew clean
./gradlew test
./gradlew assembleRelease
```

Expected output:

```text
app/build/outputs/apk/release/app-release.apk
```

For Play distribution, prefer an Android App Bundle:

```bash
./gradlew bundleRelease
```

## E. CI/CD

The supplied workflow currently builds a **debug APK** and uploads it as an artifact.

Before production CI/CD:

- Add automated unit tests.
- Add static analysis.
- Add dependency/security scanning.
- Use protected CI secrets.
- Add release signing only in protected environments.
- Build release artifacts only from reviewed tags/commits.
- Generate checksums.
- Keep debug artifacts separate from production artifacts.

## F. Staging promotion

Recommended sequence:

```text
Commit
  -> CI
  -> Unit tests
  -> Static/security checks
  -> Staging backend
  -> QA
  -> Release candidate
  -> Production backend
  -> Signed release
  -> Controlled rollout
  -> Monitoring
```

## G. Rollback

Keep:

- Previous signed application artifact.
- Previous backend version.
- Database migration rollback/forward strategy.
- Release manifest and checksum.
- Incident notes.

Never perform destructive database changes without a tested recovery plan.
