package com.example.menukotlinoop

import android.text.Editable
import android.widget.EditText

class ValidationUtils {
    companion object {
        fun isValidCalculator(data: Calculator): Boolean {

            if (data.operation == null || data.operation == ""){

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

        fun validation(variable: EditText): String {
            if(variable.text.isNullOrEmpty()){
                return variable.text.toString()
            } else {
                return ""
            }
        }

    }
}
