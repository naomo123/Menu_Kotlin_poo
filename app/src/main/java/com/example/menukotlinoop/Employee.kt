package com.example.menukotlinoop

class Employee(name: String, baseSalary: Double ) {

    var name = name
    var baseSalary = baseSalary
    var isssDeduction: Double = 0.0
    var afpDeduction: Double = 0.0
    var rentDeduction: Double = 0.0
    var totalDeductions: Double = 0.0
    var netSalary: Double = 0.0



        fun SetEmployee(name:String, baseSalary:String){

            val employee_name = name
            var salary = baseSalary.toDoubleOrNull()

            afpDeduction = baseSalary.toDouble() * (0.04)
            rentDeduction = baseSalary.toDouble() * (0.05)
            isssDeduction = baseSalary.toDouble() * (0.03)
            totalDeductions = isssDeduction + afpDeduction + rentDeduction
            netSalary = this.baseSalary - this.totalDeductions
        }
}