package com.example.app_delivery;

class Platillo {
    var imgPlatillo: Int = 0
    var nombre: String? = null
    var descripcion: String? = null

    constructor() {}

    constructor(imgPlatillo: Int, nombrePlatillo: String, descripPlatillo: String) {
        this.imgPlatillo = imgPlatillo
        this.nombre = nombrePlatillo
        this.descripcion = descripPlatillo
    }

}
