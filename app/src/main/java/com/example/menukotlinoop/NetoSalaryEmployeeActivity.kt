package com.example.menukotlinoop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class NetoSalaryEmployeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neto_salary_employee)


        val name = findViewById<EditText>(R.id.employee)
        val salary = findViewById<EditText>(R.id.baseSalary)
        val processBtn = findViewById<Button>(R.id.calculate)
        val result = findViewById<TextView>(R.id.result_lbl2)

        processBtn.setOnClickListener {

            try {
                val name = name.text.toString()
                val salary = salary.text.toString()
                val employee = Employee(name, salary.toDouble())
                val message = StringBuilder()
                employee.SetEmployee(name,salary)
                message.append("Nombre del empleado: ${employee.name}\n")
                message.append("Salario base: \$${employee.baseSalary}\n")
                message.append("AFP (-4%): \$${employee.afpDeduction}\n")
                message.append("Renta (-5%): \$${employee.rentDeduction}\n")
                message.append("ISSS (-3%): \$${employee.isssDeduction}\n")
                message.append("Total de deducciones: \$${employee.totalDeductions}\n")
                message.append("Salario neto: \$${employee.netSalary}\n")
                result.text = message.toString()
            } catch (e: Exception){
                val errMsg = "Hay campos vacíos"
                result.text = errMsg;
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
