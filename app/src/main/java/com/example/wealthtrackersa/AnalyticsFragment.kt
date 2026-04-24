package com.example.wealthtrackersa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.Locale

class AnalyticsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Listen for data from InputFragment via Fragment Result API
        parentFragmentManager.setFragmentResultListener("sa_ni_data", this) { _, bundle ->
            val income = bundle.getDouble("income")
            val expenses = bundle.getDouble("expenses")
            displayResults(income, expenses)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_analytics, container, false)
    }

    private fun displayResults(income: Double, expenses: Double) {
        val view = view ?: return

        val wealthManager = WealthManager()
        val netIncome = wealthManager.getNetIncome(income, expenses)
        val k = wealthManager.getK()
        val savings = wealthManager.calculateSavings(income, expenses)

        // Hide placeholder and show result TextViews
        view.findViewById<TextView>(R.id.sa_ni_tv_placeholder).visibility = View.GONE
        view.findViewById<TextView>(R.id.sa_ni_tv_income).apply {
            visibility = View.VISIBLE
            text = String.format(Locale.US, "Your Income: %.2f", income)
        }
        view.findViewById<TextView>(R.id.sa_ni_tv_expenses).apply {
            visibility = View.VISIBLE
            text = String.format(Locale.US, "Your Expenses: %.2f", expenses)
        }
        view.findViewById<TextView>(R.id.sa_ni_tv_net).apply {
            visibility = View.VISIBLE
            text = String.format(Locale.US, "Net: %.2f", netIncome)
        }
        view.findViewById<TextView>(R.id.sa_ni_tv_k_value).apply {
            visibility = View.VISIBLE
            text = String.format(Locale.US, "Coefficient (K): %.4f", k)
        }
        view.findViewById<TextView>(R.id.sa_ni_tv_savings).apply {
            visibility = View.VISIBLE
            text = String.format(Locale.US, "Total Savings: %.2f", savings)
        }
    }
}
