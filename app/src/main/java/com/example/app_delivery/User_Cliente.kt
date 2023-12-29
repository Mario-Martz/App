package com.example.app_delivery

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.floatingactionbutton.FloatingActionButton

class User_Cliente : AppCompatActivity() {

    //Declaramos la svariables Globales
    var imgView: ImageView? = null
    var btncamara: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_cliente)
        CapturaPhoto()
    }

    //Creamos la funcion de para cambiar el avatar del usuario al precionar el boton, esto nos permitira acceder a la camara y a los archivos de el usuario de galeria
    open fun CapturaPhoto() {
        imgView = findViewById(R.id.ImgUser)
        btncamara = findViewById(R.id.floatingActionButton)
        btncamara?.setOnClickListener{
            ImagePicker.with(this@User_Cliente)  // Cambiado de this@MainActivity
                .crop() //Crop image(Optional), Check Customization for more option
                .compress(1024) //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1800,
                    1800
                ) //Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && data != null) {
            val uri = data.data
            if (uri != null) {
                imgView!!.setImageURI(uri)
            }
        }
    }
}