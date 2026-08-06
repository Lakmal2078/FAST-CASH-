# Installation Guide

## 1. Prerequisites

Recommended build environment:

- Android Studio with a current Android SDK.
- JDK 17 for the build environment. The included GitHub Actions workflow uses JDK 17.
- Android SDK Platform 36.
- Gradle wrapper/project tooling supplied by the repository.
- Android device or emulator running Android API 24 or newer.

The module declares:

- `minSdk = 24`
- `targetSdk = 36`
- `compileSdk = 36`

## 2. Open the project

1. Extract the archive.
2. Open the directory containing `settings.gradle.kts`.
3. Allow Android Studio to import the Gradle project.
4. Allow dependency resolution to complete.
5. Resolve any SDK/plugin compatibility warnings before building.

## 3. Configure local secrets

The project uses the Secrets Gradle Plugin and expects:

```text
.env
.env.example
```

Do not put real credentials into Git.

At minimum, production signing configuration uses:

```text
KEYSTORE_PATH
STORE_PASSWORD
KEY_PASSWORD
ADMIN_PIN_HASH
```

See `ENVIRONMENT_VARIABLES.md`.

## 4. Debug build

From the project root:

```bash
./gradlew assembleDebug
```

On Windows:

```powershell
gradlew.bat assembleDebug
```

The debug APK should be generated under:

```text
app/build/outputs/apk/debug/app-debug.apk
```

## 5. Run tests

```bash
./gradlew test
```

For connected Android tests:

```bash
./gradlew connectedAndroidTest
```

## 6. Install to a connected device

```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

Only install builds on devices you own or are authorized to test.

## 7. Common setup problems

### SDK not found

Install the Android SDK platform/build tools required by the project and make sure Android Studio points to the correct SDK location.

### Missing Google services configuration

The build is configured to warn when Google Services configuration is missing. If Firebase functionality is required, configure the appropriate project file securely and do not commit private credentials.

### API calls fail

The current Retrofit base URL is a placeholder:

```text
https://api.fastxbet.example.com/
```

A real backend must be supplied before remote submission can work.

### Authentication is absent

`DefaultTokenProvider.getToken()` returns `null`. A production implementation must obtain a short-lived token from a secure authentication flow.
