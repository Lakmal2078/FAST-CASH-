package com.example.data.remote

class CashierRemoteDataSource(private val api: CashierApi) : RemoteDataSource {
    override suspend fun submitDeposit(request: SubmitDepositRequest, idempotencyKey: String?): SubmitDepositResponse {
        return api.submitDeposit(idempotencyKey, request)
    }

    override suspend fun submitWithdrawal(request: SubmitWithdrawalRequest, idempotencyKey: String?): SubmitWithdrawalResponse {
        return api.submitWithdrawal(idempotencyKey, request)
    }
}
