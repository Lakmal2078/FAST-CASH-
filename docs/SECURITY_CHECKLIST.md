# Security Checklist

## Critical findings to resolve before production

- [ ] Replace the placeholder API endpoint.
- [ ] Implement real server authentication.
- [ ] Implement server-side authorization/RBAC.
- [ ] Replace client-only admin PIN authorization.
- [ ] Implement server-side transaction state authority.
- [ ] Add idempotency to deposit/withdrawal operations.
- [ ] Add server-side amount and identity validation.
- [ ] Remove or minimize sensitive data stored locally.
- [ ] Review Android backup rules.
- [ ] Implement secure receipt upload/storage.
- [ ] Protect release signing keys.
- [ ] Ensure no secrets are committed.
- [ ] Add production monitoring and audit logging.

## Authentication

- [ ] Short-lived access tokens.
- [ ] Secure token storage.
- [ ] Refresh-token rotation where applicable.
- [ ] Logout/session invalidation.
- [ ] MFA for administrators.
- [ ] Brute-force protection.
- [ ] Device/session management.

## Authorization

- [ ] Server-side RBAC.
- [ ] Object-level authorization.
- [ ] Admin-only transaction actions.
- [ ] No trust in client status values.
- [ ] Audit every privileged action.

## Transport

- [ ] HTTPS only.
- [ ] No cleartext traffic.
- [ ] Modern TLS.
- [ ] Certificate validation.
- [ ] Consider certificate pinning only with an operational rotation strategy.

## Data

- [ ] Minimize sensitive local storage.
- [ ] Encrypt sensitive local data where required.
- [ ] Use Android Keystore-backed secrets.
- [ ] Do not hard-code encryption keys.
- [ ] Do not log secrets, tokens, account numbers, or private receipt data.

## API

- [ ] Schema validation.
- [ ] Rate limits.
- [ ] Idempotency keys.
- [ ] Replay protection.
- [ ] Request IDs.
- [ ] Generic error responses.
- [ ] Server-side business rules.
- [ ] Database transactions for state changes.

## Build/release

- [ ] Release signing isolated from developers.
- [ ] R8/minification enabled.
- [ ] Dependency vulnerability scan.
- [ ] Static analysis.
- [ ] Reproducible/traceable releases where practical.
- [ ] Debug logging disabled in production.
- [ ] Debug endpoints removed.
- [ ] Secrets scanning in CI.

## Privacy

- [ ] Privacy policy reviewed.
- [ ] Data retention defined.
- [ ] Data deletion process defined.
- [ ] Access requests handled where applicable.
- [ ] Third-party SDK/data collection reviewed.

## Incident response

- [ ] Security contact.
- [ ] Credential rotation procedure.
- [ ] Token revocation procedure.
- [ ] Backup restore procedure.
- [ ] Compromised APK response.
- [ ] Signing-key compromise plan.
