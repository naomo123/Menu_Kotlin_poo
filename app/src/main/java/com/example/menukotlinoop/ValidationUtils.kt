package com.example.menukotlinoop

import android.text.Editable
import android.widget.EditText

class ValidationUtils {
    companion object {

        fun validation(variable: EditText): String {
            if(variable.text.isNullOrEmpty()){
                return variable.text.toString()
            } else {
                return ""
            }
        }

    }
}
