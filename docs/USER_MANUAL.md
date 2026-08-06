# User Manual

> This is a software-use guide for a generic transaction/cashier application.

## Home

The application provides navigation to the main transaction and account areas.

## Set user/player ID

Enter the identifier required by the backend.

Use only an identifier you are authorized to use.

The source validates deposit player IDs and includes repository-level tests for invalid IDs.

## Deposit workflow

The implemented UI follows a multi-step flow:

1. Select a bank/payment destination.
2. Enter transfer details.
3. Select/upload a receipt.
4. Confirm the player ID.
5. Submit the transaction.

The repository checks for duplicate references before inserting a local deposit.

## Withdrawal workflow

Provide:

- Player ID.
- Amount.
- Secret code.
- Bank.
- Account holder.
- Account number.
- Branch.

The repository prevents a second pending withdrawal under its local rule.

## History

The local database tracks transaction status.

Deposit statuses include:

```text
PENDING
APPROVED
REJECTED
CANCELLED
```

Withdrawal statuses include:

```text
PENDING
APPROVED
COMPLETED
REJECTED
CANCELLED
```

## Security

Do not share:

- Account numbers unnecessarily.
- Secret codes.
- Authentication tokens.
- Screenshots containing private information.

Use only legitimate test data in development.

## Troubleshooting

### Submission fails

Check:

1. Network connectivity.
2. API endpoint configuration.
3. Authentication token.
4. Server response.
5. Local validation errors.

### Admin functions unavailable

The local admin hash may not be configured. More importantly, production authorization must be handled by the backend.

### Receipt cannot be selected

Verify Android media/storage behavior for the device API level and ensure the app has only the permissions it actually needs.
