# Testing Checklist

## Existing automated coverage

The supplied source contains tests for:

- Deposit player-ID validation.
- Duplicate deposit reference detection.
- Remote deposit failure handling.
- Successful deposit insertion.
- Prevention of a second pending withdrawal.
- Authentication interceptor behavior.
- Admin PIN hash verification.

## Unit tests

- [ ] Valid player ID accepted.
- [ ] Invalid player ID rejected.
- [ ] Empty amount rejected.
- [ ] Negative amount rejected.
- [ ] Maximum amount enforced.
- [ ] Duplicate reference rejected.
- [ ] Duplicate submission with different reference handled correctly.
- [ ] Remote timeout handled.
- [ ] HTTP 4xx handled.
- [ ] HTTP 5xx handled.
- [ ] Malformed JSON handled.
- [ ] Null/partial API responses handled.

## Transaction-state tests

- [ ] PENDING -> APPROVED.
- [ ] PENDING -> REJECTED.
- [ ] PENDING -> CANCELLED where allowed.
- [ ] APPROVED cannot be approved twice.
- [ ] REJECTED cannot be approved.
- [ ] Concurrent approvals are safe.
- [ ] Duplicate requests are idempotent.
- [ ] Server and client state reconciliation works.

## Security tests

- [ ] No token sent when unauthenticated.
- [ ] Correct bearer token sent when authenticated.
- [ ] Expired token handled.
- [ ] Unauthorized admin action rejected server-side.
- [ ] Non-admin cannot approve/reject.
- [ ] Rate limits work.
- [ ] Sensitive fields are not logged.
- [ ] APK contains no secrets.
- [ ] Release build is not debuggable.

## UI tests

- [ ] Home screen renders.
- [ ] Deposit flow completes.
- [ ] Withdrawal flow completes.
- [ ] History renders.
- [ ] Admin login works with valid credentials.
- [ ] Admin login rejects invalid credentials.
- [ ] Logout works.
- [ ] Empty states render.
- [ ] Loading states render.
- [ ] Error messages are understandable.
- [ ] Rotation/configuration changes preserve appropriate state.
- [ ] Dark/light themes render.
- [ ] Accessibility labels exist.

## Device/API matrix

Test at minimum across:

- [ ] API 24 baseline.
- [ ] Current supported Android version.
- [ ] Low-memory device.
- [ ] Small screen.
- [ ] Large screen.
- [ ] Slow network.
- [ ] Offline/online transition.
- [ ] Different keyboard/input configurations.

## Performance

- [ ] Startup time measured.
- [ ] No main-thread database work.
- [ ] No memory leaks.
- [ ] Receipt selection does not cause excessive memory use.
- [ ] Large transaction history remains responsive.

## CI

```bash
./gradlew test
./gradlew connectedAndroidTest
./gradlew assembleRelease
```

CI should fail on test failures, lint/security failures, and release configuration errors.
