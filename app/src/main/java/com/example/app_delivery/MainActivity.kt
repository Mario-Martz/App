package com.example.app_delivery

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Almacenamos la referencia del TextView en una variable
        val crearC: TextView = findViewById(R.id.CrearCuenta)
        val resPass: TextView = findViewById(R.id.Respass)
        val btn_Entra: Button = findViewById(R.id.btn_Entra)

        CrearCuenta(crearC)
        RestablecerContraseña(resPass)
        Entra(btn_Entra)
    }

    private fun RestablecerContraseña(respas: TextView) {
        respas.setOnClickListener {
            val intent = Intent(this@MainActivity, RestarPassword::class.java)
            startActivity(intent)
        }
    }

    fun CrearCuenta(Cuenta: TextView) {
        //usamos el evento OnclickListener para que cuando se presione el TextView haga lo que está dentro del método
        Cuenta.setOnClickListener {
            // Al hacer clic en el TextView (CrearCuenta), iniciamos la nueva actividad (CrearCuenta)
            val intent = Intent(this@MainActivity, CrearCuenta::class.java)
            // llamamos al método startActivity que se utiliza para iniciar una nueva actividad en Android
            startActivity(intent)
        }
    }

    fun Entra(btn_Login: Button) {
        btn_Login.setOnClickListener {
            // Inicia la actividad Principal
            val Entrar = Intent(this@MainActivity, Principal::class.java)
            startActivity(Entrar)
        }
    }
}
