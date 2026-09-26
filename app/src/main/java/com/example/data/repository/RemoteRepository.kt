package com.example.data.repository

import com.example.data.remote.RemoteDataSource
import com.example.data.remote.SubmitDepositRequest
import com.example.data.remote.SubmitWithdrawalRequest
import com.example.data.remote.SubmitDepositResponse
import com.example.data.remote.SubmitWithdrawalResponse

class RemoteRepository(private val remoteDataSource: RemoteDataSource) {
    suspend fun submitDeposit(request: SubmitDepositRequest, idempotencyKey: String? = null): SubmitDepositResponse {
        return remoteDataSource.submitDeposit(request, idempotencyKey)
    }

    suspend fun submitWithdrawal(request: SubmitWithdrawalRequest, idempotencyKey: String? = null): SubmitWithdrawalResponse {
        return remoteDataSource.submitWithdrawal(request, idempotencyKey)
    }
}
