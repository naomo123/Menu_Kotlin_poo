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
import java.util.Vector

class AverageStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_average_student)

        val grades = Vector<Double>()

        val processBtn = findViewById<Button>(R.id.calculate_avg)
        val result = findViewById<TextView>(R.id.result_avg)

        val name = findViewById<EditText>(R.id.student)
        val grade1 = findViewById<EditText>(R.id.grade1et)
        val grade2 = findViewById<EditText>(R.id.grade2et)
        val grade3 = findViewById<EditText>(R.id.grade3et)
        val grade4 = findViewById<EditText>(R.id.grade4et)
        val grade5 = findViewById<EditText>(R.id.grade5et)

        processBtn.setOnClickListener {

            try {
                grades.addAll(
                    listOf(
                        grade1.text.toString().toDouble(),
                        grade2.text.toString().toDouble(),
                        grade3.text.toString().toDouble(),
                        grade4.text.toString().toDouble(),
                        grade5.text.toString().toDouble()
                    )
                )
                val name = name.text.toString()

                val student = Student(name, grades)

                val message = StringBuilder()

                message.append("Promedio del alumno: ${student.average}\n")

                if (student.average >= 6.0) {
                    message.append("Alumno aprobado")
                } else {
                    message.append("Alumno reprobado")
                }

                result.text = message.toString()
            } catch (e: Exception) {
                val errMsg = "Hay un campo vacío"
                result.text = errMsg
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
            Toast.makeText(this, "Inicio", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}