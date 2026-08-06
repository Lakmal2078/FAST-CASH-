# API Documentation

## Current API surface

The Android Retrofit interface defines two POST operations.

Base URL in the supplied source:

```text
https://api.fastxbet.example.com/
```

This is a placeholder and is not a production service.

## Authentication

`AuthInterceptor` adds:

```http
Authorization: Bearer <token>
```

only when `TokenProvider.getToken()` returns a non-empty token.

The default implementation returns `null`.

Therefore the current client does **not** authenticate remote requests by default.

## POST /deposit

Request:

```json
{
  "playerId": "123456",
  "bankName": "Example Bank",
  "amountMinorUnits": 100000,
  "slipUri": "content://example/receipt",
  "reference": "REF-001"
}
```

Response:

```json
{
  "success": true,
  "depositId": 42
}
```

### Fields

| Field | Type | Meaning |
|---|---|---|
| `playerId` | string | Client/player identifier |
| `bankName` | string | Selected bank/payment destination |
| `amountMinorUnits` | integer | Amount represented in minor currency units |
| `slipUri` | string/null | Client-side receipt URI |
| `reference` | string | Transaction/reference value |

## POST /withdrawal

Request:

```json
{
  "playerId": "123456",
  "amountMinorUnits": 200000,
  "secretCode": "<sensitive>",
  "bankName": "Example Bank",
  "accountHolder": "Example User",
  "accountNumber": "0000000000",
  "branch": "Main"
}
```

Response:

```json
{
  "success": true,
  "withdrawalId": 7
}
```

## Production API requirements

The backend should additionally enforce:

- TLS.
- Authentication.
- Authorization.
- Request schema validation.
- Maximum amount limits.
- Currency validation.
- Idempotency keys.
- Server-generated transaction IDs.
- Unique references.
- Rate limiting.
- Replay protection.
- Audit logs.
- Consistent error codes.
- Atomic transaction state changes.

### Recommended error format

```json
{
  "error": {
    "code": "VALIDATION_ERROR",
    "message": "Request validation failed",
    "requestId": "req_..."
  }
}
```

Do not return stack traces, secrets, account credentials, or internal database details.

## Important architectural warning

The client currently sends `slipUri`, which is an Android URI, not a server-side file upload.

For production receipt handling, use:

```text
Client -> API requests upload URL
       -> Client uploads file to object storage
       -> API records verified object metadata
```

Validate MIME type, file size, object ownership, and content integrity on the server.
