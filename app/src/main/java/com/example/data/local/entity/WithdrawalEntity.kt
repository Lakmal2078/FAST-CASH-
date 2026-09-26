package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "withdrawals",
    indices = [androidx.room.Index(value = ["status"])]
)
data class WithdrawalEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userJid: String = "user_default",
    val playerId: String = "",
    val amountText: String = "",
    val amountMinorUnits: Long = 0,
    val secretCode: String = "",
    val bankName: String = "",
    val accountHolder: String = "",
    val accountNumber: String = "",
    val branch: String = "",
    val status: String = "PENDING", // PENDING, APPROVED, COMPLETED, REJECTED, CANCELLED
    val createdAt: Long = System.currentTimeMillis(),
    val payoutReference: String? = null,
    val rejectionReason: String? = null,
    val idempotencyKey: String? = null
) {
    init {
        require(playerId.length in 5..12) { "Player ID must be 5-12 digits" }
        require(amountMinorUnits in 100_000..50_000_000) { "Withdrawal amount must be between LKR 1,000 and LKR 500,000" }
        require(secretCode.length <= 50) { "Secret code must be <= 50 characters" }
        require(bankName.length <= 100) { "Bank name must be <= 100 characters" }
        require(accountHolder.length <= 100) { "Account holder must be <= 100 characters" }
        require(accountNumber.length <= 50) { "Account number must be <= 50 characters" }
        require(branch.length <= 100) { "Branch must be <= 100 characters" }
    }
}
