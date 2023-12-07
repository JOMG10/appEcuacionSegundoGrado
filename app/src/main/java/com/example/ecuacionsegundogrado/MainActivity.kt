package com.example.ecuacionsegundogrado

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var editTextA: EditText
    private lateinit var editTextB: EditText
    private lateinit var editTextC: EditText
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextA = findViewById(R.id.editTextA)
        editTextB = findViewById(R.id.editTextB)
        editTextC = findViewById(R.id.editTextC)
        tvResultado = findViewById(R.id.tvResultado)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        btnCalcular.setOnClickListener { calcularSoluciones() }
    }

    @SuppressLint("SetTextI18n")
    private fun calcularSoluciones() {
        val a = editTextA.text.toString().toDouble()
        val b = editTextB.text.toString().toDouble()
        val c = editTextC.text.toString().toDouble()

        val discriminante = b * b - 4 * a * c

        if (discriminante < 0) {
            tvResultado.text = "No hay soluciones reales."
        } else {
            val x1 = (-b + sqrt(discriminante)) / (2 * a)
            val x2 = (-b - sqrt(discriminante)) / (2 * a)

            tvResultado.text = "Solución 1: $x1\nSolución 2: $x2"
        }
    }
}
