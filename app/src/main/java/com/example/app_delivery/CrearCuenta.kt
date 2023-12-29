package com.example.app_delivery

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class CrearCuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)

        // Creamos variavles que hacen referencia a los componetes de edicion de texto (EditText)
        val passEditText: TextInputEditText = findViewById(R.id.ediTextPasswordCreate)
        val repetirPassEditText: TextInputEditText = findViewById(R.id.ediTextRepetirContraseñaCreate)
        //Creamos una variable que hace referencia a un Button
        val crearCuentaButton: Button = findViewById(R.id.btn_CrearCuenta)

        // Agregar TextWatcher para validar las contraseñas en tiempo real
        //Esta interfaz permite a los usuarios observar y responder activamente a las modificaciones realizadas en un componente de texto
        passEditText.addTextChangedListener(textWatcher)
        repetirPassEditText.addTextChangedListener(textWatcher)

        // Agregar OnFocusChangeListener para mostrar el mensaje cuando el campo está enfocado
        passEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                mostrarMensajePropiedadesContraseña()
            }
        }

        repetirPassEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                mostrarMensajePropiedadesRepContraseña()
            }
        }

        // Configuración de botones
        RegresarMenu()
        crearCuenta(crearCuentaButton)
    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
            // No se utiliza en este caso
        }

        override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
            // No se utiliza en este caso
        }

        override fun afterTextChanged(editable: Editable?) {
            validarPass()
        }
    }

    private fun crearCuenta(ButtoncrearCuenta: Button) {
        // Agregar un OnClickListener al botón de crear cuenta
        ButtoncrearCuenta.setOnClickListener {
            // Realizar la acción correspondiente al hacer clic en "Crear Cuenta"
            // Puedes agregar aquí el código para crear la cuenta
            Toast.makeText(this, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show()
        }
    }

    private fun RegresarMenu() {
        val regresar: Button = findViewById(R.id.btnCancelar)
        regresar.setOnClickListener {
            val intent = Intent(this@CrearCuenta, MainActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun validarPass() {
        val passEditText: TextInputEditText = findViewById(R.id.ediTextPasswordCreate)
        val repetirPassEditText: TextInputEditText = findViewById(R.id.ediTextRepetirContraseñaCreate)
        val errorMessage: TextView = findViewById(R.id.errorMessage)
        val propiedadesContraseña: TextView = findViewById(R.id.PropiedadesContraseña)
        val propiedadesRepContraseña: TextView = findViewById(R.id.PropiedadesRepContraseña)

        val password = passEditText.text.toString()
        val repetirPassword = repetirPassEditText.text.toString()

        if (password != repetirPassword) {
            errorMessage.text = "Error: las contraseñas no coinciden"
            errorMessage.visibility = View.VISIBLE
        } else {
            errorMessage.visibility = View.GONE
        }

        // Validar caracteres permitidos en la contraseña
        val caracteresPermitidos = Regex("[a-zA-Z0-9.,;$:!?_-]+")
        actualizarMensaje(propiedadesContraseña, password, caracteresPermitidos)
        actualizarMensaje(propiedadesRepContraseña, repetirPassword, caracteresPermitidos)
    }

    private fun mostrarMensajePropiedadesContraseña() {
        val propiedadesContraseña: TextView = findViewById(R.id.PropiedadesContraseña)
        propiedadesContraseña.text = "Puedes usar letras, números y signos de puntuación"
        propiedadesContraseña.visibility = View.VISIBLE
    }

    @SuppressLint("SetTextI18n")
    private fun mostrarMensajePropiedadesRepContraseña() {
        val propiedadesRepContraseña: TextView = findViewById(R.id.PropiedadesRepContraseña)
        propiedadesRepContraseña.text = "Puedes usar letras, números y signos de puntuación"
        propiedadesRepContraseña.visibility = View.VISIBLE
    }

    @SuppressLint("SetTextI18n")
    private fun actualizarMensaje(textView: TextView, text: String, regex: Regex) {
        if (!regex.matches(text)) {
            textView.text = "Puedes usar letras, números y signos de puntuación"
            textView.visibility = View.VISIBLE
        } else {
            textView.visibility = View.GONE
        }
    }
}