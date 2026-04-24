package com.example.wealthtrackersa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class InputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etIncome = view.findViewById<EditText>(R.id.sa_ni_et_income)
        val etExpenses = view.findViewById<EditText>(R.id.sa_ni_et_expenses)
        val btnSave = view.findViewById<Button>(R.id.sa_ni_btn_save)

        btnSave.setOnClickListener {
            val incomeText = etIncome.text.toString().trim()
            val expensesText = etExpenses.text.toString().trim()

            // Validate income field
            if (incomeText.isEmpty()) {
                etIncome.error = "Please enter income"
                return@setOnClickListener
            }

            val income = incomeText.toDoubleOrNull()
            if (income == null) {
                etIncome.error = "Invalid number"
                return@setOnClickListener
            }

            // Validate expenses field
            if (expensesText.isEmpty()) {
                etExpenses.error = "Please enter expenses"
                return@setOnClickListener
            }

            val expenses = expensesText.toDoubleOrNull()
            if (expenses == null) {
                etExpenses.error = "Invalid number"
                return@setOnClickListener
            }

            // Send data via Fragment Result API
            val result = Bundle().apply {
                putDouble("income", income)
                putDouble("expenses", expenses)
            }
            parentFragmentManager.setFragmentResult("sa_ni_data", result)

            Toast.makeText(requireContext(), "Calculated!", Toast.LENGTH_SHORT).show()
        }
    }
}
