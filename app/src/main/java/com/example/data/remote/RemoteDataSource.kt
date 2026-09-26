package com.example.data.remote

interface RemoteDataSource {
    suspend fun submitDeposit(request: SubmitDepositRequest, idempotencyKey: String? = null): SubmitDepositResponse
    suspend fun submitWithdrawal(request: SubmitWithdrawalRequest, idempotencyKey: String? = null): SubmitWithdrawalResponse
}
