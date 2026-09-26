package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "deposits",
    indices = [androidx.room.Index(value = ["reference"], unique = true)]
)
data class DepositEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userJid: String = "user_default",
    val playerId: String = "",
    val bankName: String = "",
    val amountText: String = "",
    val amountMinorUnits: Long = 0,
    val slipUri: String? = null,
    val status: String = "PENDING", // PENDING, APPROVED, REJECTED, CANCELLED
    val reference: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val idempotencyKey: String? = null
) {
    init {
        require(playerId.length in 5..12) { "Player ID must be 5-12 digits" }
        require(reference.length <= 100) { "Reference must be <= 100 characters" }
        require(bankName.length <= 100) { "Bank name must be <= 100 characters" }
        require(amountMinorUnits >= 0) { "Amount must be non-negative" }
    }
}
