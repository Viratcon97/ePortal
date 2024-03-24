package com.example.eportal.utils

import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog
import com.example.eportal.R

class Constant {

    companion object {
        const val CREDENTIAL = "Login_credential"

        fun errorDialog(context : Context,error : String) : MaterialDialog {
            val errorDialog = MaterialDialog(context)
            errorDialog.title(R.string.error)
            errorDialog.message(text = error)
            errorDialog.cancelable(true)
            errorDialog.negativeButton {
                it.dismiss()
            }
            return errorDialog
        }
    }

}