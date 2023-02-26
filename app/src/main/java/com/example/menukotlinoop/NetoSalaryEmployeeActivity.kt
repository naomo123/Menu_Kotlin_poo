package com.example.menukotlinoop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class NetoSalaryEmployeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neto_salary_employee)


        val name = findViewById<EditText>(R.id.employee)
        val salary = findViewById<EditText>(R.id.baseSalary)
        val processBtn = findViewById<Button>(R.id.calculate)
        val result = findViewById<TextView>(R.id.result_lbl2)

        processBtn.setOnClickListener {

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
            result.setText(message.toString())

        }


    }
}
