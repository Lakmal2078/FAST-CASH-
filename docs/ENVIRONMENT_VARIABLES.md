# Environment Variables

## Current variables referenced by the supplied source

| Variable | Required for | Purpose | Secret |
|---|---|---|---|
| `KEYSTORE_PATH` | Release signing | Path to release keystore | No, but sensitive |
| `STORE_PASSWORD` | Release signing | Keystore password | Yes |
| `KEY_PASSWORD` | Release signing | Key password | Yes |
| `ADMIN_PIN_HASH` | Local admin safeguard | SHA-256 hash consumed by `BuildConfig` | Sensitive |

## `.env`

The project configures the Secrets Gradle Plugin with:

```text
propertiesFileName = ".env"
defaultPropertiesFileName = ".env.example"
```

Keep real values in local/CI secret storage.

Example shape:

```dotenv
KEYSTORE_PATH=/secure/path/release.jks
STORE_PASSWORD=<secret>
KEY_PASSWORD=<secret>
ADMIN_PIN_HASH=<sha256-hash>
```

Do not copy this example into source control with real values.

## Variables that should exist in a production backend

These are **recommended backend variables**, not variables currently implemented by the supplied Android source:

```dotenv
DATABASE_URL=
API_BASE_URL=
JWT_ISSUER=
JWT_AUDIENCE=
JWT_SIGNING_KEY=
OBJECT_STORAGE_BUCKET=
OBJECT_STORAGE_ENDPOINT=
OBJECT_STORAGE_ACCESS_KEY=
OBJECT_STORAGE_SECRET_KEY=
REDIS_URL=
LOG_LEVEL=
```

Use a managed secret store rather than a committed `.env` file in production.

## Important distinction

The Android project does not currently read a configurable `API_BASE_URL`; `AppModule.kt` contains a hard-coded Retrofit URL.

Therefore:

- `API_BASE_URL` is not automatically effective.
- The source must be changed to consume a safe build configuration value.
- Never place a private server credential in an Android build; APK contents can be inspected.
