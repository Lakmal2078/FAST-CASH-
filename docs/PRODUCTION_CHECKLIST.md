# Production Checklist

## Architecture

- [ ] Production backend exists.
- [ ] Android client never connects directly to a private database.
- [ ] Backend is the source of truth.
- [ ] Transaction state is server-controlled.
- [ ] Idempotency is implemented.
- [ ] Audit logging is implemented.

## Android

- [ ] Production API URL configured.
- [ ] Placeholder domain removed.
- [ ] Production authentication implemented.
- [ ] Secure token storage implemented.
- [ ] Admin UI cannot authorize actions by itself.
- [ ] Sensitive local data minimized.
- [ ] Backup policy reviewed.
- [ ] Release minification verified.
- [ ] ProGuard/R8 rules tested.

## Backend

- [ ] HTTPS.
- [ ] Authentication.
- [ ] RBAC.
- [ ] Rate limiting.
- [ ] Input validation.
- [ ] Database transactions.
- [ ] Unique constraints/idempotency.
- [ ] Secure file storage.
- [ ] Audit trail.
- [ ] Monitoring.
- [ ] Alerting.
- [ ] Backup and restore tested.

## Secrets

- [ ] No secrets in Git.
- [ ] No secrets in APK resources.
- [ ] CI secrets protected.
- [ ] Release keystore protected.
- [ ] API signing/auth keys rotated according to policy.
- [ ] Compromise/revocation process documented.

## Release

- [ ] All automated tests pass.
- [ ] Security review complete.
- [ ] Dependency scan clean or formally accepted.
- [ ] Release build signed with production key.
- [ ] Artifact checksum generated.
- [ ] Version code/name updated.
- [ ] Release notes prepared.
- [ ] Rollback version retained.

## Operational readiness

- [ ] On-call owner assigned.
- [ ] Monitoring dashboards ready.
- [ ] Error tracking ready.
- [ ] Incident-response procedure tested.
- [ ] Backup restore tested.
- [ ] Disaster-recovery target defined.
- [ ] Privacy/data-retention requirements reviewed.

## Final go/no-go

Do **not** approve production release while any of these remain true:

1. Placeholder API endpoint is active.
2. Authentication is absent.
3. Admin authorization is client-only.
4. Backend is not the source of truth.
5. Financial/transaction state changes are not atomic.
6. Backups cannot be restored.
7. Release signing credentials are uncontrolled.
