package com.example.wealthtrackersa

class WealthManager {

    companion object {
        // K = (4 + 10) / 22
        private const val K = 14.0 / 22.0
    }

    // Final Savings = (Income - Expenses) * K
    fun calculateSavings(income: Double, expenses: Double): Double {
        return (income - expenses) * K
    }

    // Net Income = Income - Expenses
    fun getNetIncome(income: Double, expenses: Double): Double {
        return income - expenses
    }

    // Return K coefficient value
    fun getK(): Double = K
}
