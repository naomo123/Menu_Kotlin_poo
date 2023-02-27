package com.example.menukotlinoop

class ValidationUtils {
    companion object {
        fun isValidCalculator(data: Calculator): Boolean {

            if (data.operation == ""){
                return false
            }
            if(data.number1 == null){
                return false
            }
            if(data.number2 == null){
                return false
            }
            // All checks passed, input data is valid
            return true
        }
    }
}
