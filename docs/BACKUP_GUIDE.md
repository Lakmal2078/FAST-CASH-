# Backup Guide

## What is stored locally

The app uses Room for:

- Users.
- Banks/payment destinations.
- Deposits.
- Withdrawals.

The manifest currently enables Android backup:

```xml
android:allowBackup="true"
```

The app also references backup/data-extraction rules.

## Critical warning

A mobile local database must **not** be treated as the authoritative financial ledger.

For production:

```text
Android local DB = cache/offline UX
Backend DB       = source of truth
```

## Backend backup strategy

Recommended:

- Automated encrypted daily full backups.
- Frequent incremental/WAL-compatible backups where supported.
- Point-in-time recovery.
- Off-site/region-separated backup copies where appropriate.
- Retention policy.
- Access control.
- Backup encryption.
- Restore testing.

## Suggested retention

Define a policy with legal/compliance requirements first. A common engineering baseline is:

- Short-term daily recovery points.
- Weekly recovery points.
- Monthly archival points.

Do not use these values blindly for regulated data.

## Restore test

At least periodically:

1. Provision an isolated recovery environment.
2. Restore the latest backup.
3. Validate schema/migrations.
4. Validate transaction counts/checksums.
5. Validate audit logs.
6. Run application smoke tests.
7. Record recovery time.
8. Record recovery point achieved.
9. Document failures and corrective actions.

## Android backup considerations

Because transaction/account data may be sensitive, review whether Android cloud/device backup should contain:

- User data.
- Transaction records.
- Receipt references.
- Sensitive account data.

If backup is not appropriate, explicitly configure backup/data-extraction rules to exclude sensitive stores.

Do not assume `allowBackup=true` is a secure financial-data backup strategy.

## Signing-key backup

The Android release keystore is operationally critical.

Keep an encrypted, access-controlled backup in at least one separate secure location.

Never store the keystore password beside the keystore.
