package com.example.menukotlinoop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class BasicCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_calculator)


        val num1 = findViewById<EditText>(R.id.editN1)
        val num2 = findViewById<EditText>(R.id.editN2)
        val btnCalcu = findViewById<Button>(R.id.btnCalculate)
        val lblResult = findViewById<TextView>(R.id.lblresult)


        /** Spinner fill with data */
        val spinner = findViewById<Spinner>(R.id.operation_spinner)
        val operations = arrayOf("Sumar", "Restar", "Multiplicar", "Dividir")
        val spinnerAdapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, operations)
        spinner.adapter = spinnerAdapter

        btnCalcu.setOnClickListener {

            val operation = spinner.selectedItem.toString()
            val n1 = num1.text.toString()
            val n2 = num2.text.toString()
            val calculator = Calculator()
            calculator.operate(n1,n2,operation)
            if (ValidationUtils.isValidCalculator(calculator)) {
                Toast.makeText(this, "Please enter valid data", Toast.LENGTH_SHORT).show()
            } else {
                lblResult.text = calculator.result.toString()

            }
        }
    }

}