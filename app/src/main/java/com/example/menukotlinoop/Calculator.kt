package com.example.menukotlinoop

class Calculator {
    var number1: Double
    var number2: Double
    var operation: String
    var result: Double

    constructor() {
        this.number1 = 0.0
        this.number2 = 0.0
        this.operation = ""
        this.result = 0.0
    }

    fun operate(number1: String, number2: String, operation: String) {
        val n1 = number1.toDoubleOrNull()
        val n2 = number2.toDoubleOrNull()
        this.number1 = n1!!
        this.number2 = n2!!

        when (operation) {
            "Sumar" -> {
                this.result = n1 + n2
            }
            "Restar" -> {
                this.result = n1 - n2
            }
            "Multiplicar" -> {
                this.result = n1 * n2
            }
            "Dividir" -> {
                if (n2 == 0.0) {
                    throw IllegalArgumentException("No puedes dividir entre 0")
                }
                this.result = n1 / n2
            }
        }
    }
}