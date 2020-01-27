package com.example.username.kotlinexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var etNumero1: EditText
    private lateinit var etNumero2: EditText
    private lateinit var btnSumar: Button
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
        initializeBtnSumarListener()
    }

    private fun setupUI() {
        etNumero1 = findViewById(R.id.etNumero1)
        etNumero2 = findViewById(R.id.etNumero2)
        btnSumar = findViewById(R.id.btnSumar)
        txtResultado = findViewById(R.id.txtResultado)
    }

    private fun initializeBtnSumarListener() {
        btnSumar.setOnClickListener {
            val numero1 = getTextFromEditText(etNumero1)
            val numero2 = getTextFromEditText(etNumero2)
            if (campoVacio(numero1, numero2)) {
                Toast.makeText(this, "Completar todos los campos", Toast.LENGTH_LONG).show()
            } else {
                val resultado = numero1.toInt() + numero2.toInt()
                txtResultado.text = "El resultado es: $resultado"
            }
        }
    }

    private fun campoVacio(numero1: String, numero2: String): Boolean {
        return numero1.isEmpty() || numero2.isEmpty()
    }

    private fun getTextFromEditText(editText: EditText): String {
        return editText.text.toString()
    }

}
