package com.example.menukotlinoop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
            try {
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
            } catch (e: Exception){
                val errMsg = "Hay un campo vacío"
                lblResult.text = errMsg
                Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show();
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.option1) {
            Toast.makeText(this, "Se seleccionó la primera opción", Toast.LENGTH_LONG).show()
            val intent = Intent(this, BasicCalculatorActivity::class.java)
            startActivity(intent)
        }
        if (id == R.id.option2) {
            Toast.makeText(this, "Se seleccionó la segunda opción", Toast.LENGTH_LONG).show()
            val intent = Intent(this, AverageStudentActivity::class.java)
            startActivity(intent)

        }
        if (id == R.id.option3) {
            Toast.makeText(this, "Se seleccionó la tercer opción", Toast.LENGTH_LONG).show()
            val intent = Intent(this, NetoSalaryEmployeeActivity::class.java)
            startActivity(intent)
        }
        if (id == R.id.option4) {
            Toast.makeText(this, "Calculadora básica", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}