package com.example.app_delivery

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class Principal : AppCompatActivity() {

    private lateinit var recyclerViewPlatillo: RecyclerView
    private lateinit var adaptadorPlatillo: RecyclerViewAdaptador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        // Configuración del RecyclerView de platillos
        recyclerViewPlatillo = findViewById(R.id.recyclerProductos)
        val spanCount = 2
        val layoutManager = GridLayoutManager(this, spanCount)
        recyclerViewPlatillo.layoutManager = layoutManager
        adaptadorPlatillo = RecyclerViewAdaptador(obtenerPlatillos())
        recyclerViewPlatillo.adapter = adaptadorPlatillo

        // Configuración de eventos
        EditarAvatar()
        shopping()
    }

    // Método para obtener una lista de platillos de ejemplo
    private fun obtenerPlatillos(): List<Platillo> {
        val platillos = ArrayList<Platillo>()
        platillos.add(Platillo(R.drawable.espaguetis_alfredo_con_pollo_64130b3f23f55, "Platillo1", "Description platillo1"))
        platillos.add(Platillo(R.drawable.descarga, "Platillo2", "Description platillo2"))
        platillos.add(Platillo(R.drawable.espaguetis_puttanesca, "Platillo3", "Description platillo3"))
        platillos.add(Platillo(R.drawable.fetuccini_con_hongos, "Platillo4", "Description platillo4"))
        platillos.add(Platillo(R.drawable.stock_624740112_1, "Platillo5", "Description platillo5"))
        return platillos
    }

    // Método para configurar el evento de clic en el avatar
    private fun EditarAvatar() {
        val imgAvatar: ImageButton = findViewById(R.id.btn_avatar)
        imgAvatar.setOnClickListener {
            val User = Intent(this@Principal, User_Cliente::class.java)
            startActivity(User)
        }
    }

    // Método para configurar el evento de clic en el carrito de compras
    private fun shopping() {
        val imgshopping: TextView = findViewById(R.id.caritoCompras)
        imgshopping.setOnClickListener {
            val Shopping = Intent(this@Principal, shopping::class.java)
            startActivity(Shopping)
        }
    }
}