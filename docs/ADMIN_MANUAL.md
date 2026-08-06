# Admin Manual

> This manual documents the software's local transaction-review interface. It is not an authorization procedure for real financial settlement.

## Admin screen

The supplied application includes:

- Admin PIN login.
- Dashboard statistics.
- Pending deposits list.
- Pending withdrawals list.
- Approve action.
- Reject action.
- Withdrawal payout-reference field.
- Withdrawal rejection-reason field.
- Logout.

## Local login

The app compares the SHA-256 hash of the entered PIN against `BuildConfig.ADMIN_PIN_HASH`.

This is **not sufficient for production administration**.

Why:

- The verifier is client-side.
- The hash is compiled into the application.
- APKs can be reverse engineered.
- There is no demonstrated server-side role/permission check.
- There is no demonstrated brute-force protection.

## Production admin workflow

A production backend should require:

1. Authenticated admin account.
2. Server-side role check.
3. MFA for privileged users.
4. Short-lived access tokens.
5. Re-authentication for sensitive actions.
6. Audit log entry for every approve/reject action.
7. Idempotent state transitions.
8. Separation of duties where required.
9. Rate limiting and lockout controls.
10. Immutable or append-only audit history.

## Transaction review

For each pending transaction verify, at minimum:

- Transaction ID.
- User/player identifier.
- Amount.
- Destination account.
- Reference.
- Evidence/receipt.
- Current status.
- Creation time.
- Previous actions.

Never approve solely because a client-side field says a transaction is valid.

## Rejecting a transaction

A rejection reason should be:

- Specific.
- Non-sensitive.
- Recorded server-side.
- Associated with the admin identity.
- Associated with a request/audit ID.

## Logout

Use the app's logout control after completing administrative work.

For a production app, server-side sessions/tokens should also be invalidated or expire quickly.
