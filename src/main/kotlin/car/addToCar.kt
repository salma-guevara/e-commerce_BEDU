package car

import product.*
import user.*

class addToCar {
    companion object{
        var total : Double = 0.0
    }
    fun agregaralCarro(){

        println("\nElige la siguiente acción " +
                "\n1. Agregar productos al carrito" +
                "\n2. Volver al menú")


        when (readln().toInt()) {
            1 -> {
                val car = shoppingCar()

                val producto1 = Producto(1,"Celular",20000.00,"Equipo celular de última generación",10)
                val producto2 = Producto(2,"Figura de acción",800.00,"Figura de acción de plástico",9)
                val producto3 = Producto(3,"Pantalones",20000.00,"Equipo celular de última generación",8)
                val producto4 = Producto(4,"Celular",20000.00,"Equipo celular de última generación",7)
                val producto5 = Producto(5,"Celular",20000.00,"Equipo celular de última generación",6)
                val lista = mapOf<Int,Producto>(
                    1 to producto1,
                    2 to producto2,
                    3 to producto3,
                    4 to producto4,
                    5 to producto5
                )

                try {
                    do {

                        println("Ingrese el SKU del producto que desea agregar")
                        val sku = readln().toInt()
                        println("Ingrese la cantidad de productos que desea")
                        val cantidad = readln().toInt()
                        for (i in 1..cantidad){
                            lista.get(sku)?.let {car.agregarProducto(it) }

                        }
                        println("Para proceder al envio presione 0 para agregar otro producto presione 1")
                        val validacion = readln().toInt()
                    }while ( validacion != 0)
                    val tarticulos = car.verProductos()?.size?.minus(1)
                    for (i in 0..tarticulos!!){
                        total += car.verProductos()!!.get(i).precio
                    }
                    println("Tienes un total de ${car.verProductos()?.size} articulos y un subtotal a pagar de $${total}")
                }catch (ex: Exception){
                    println("Ingresa un valor entero")
                }


            }
            2 -> {
                println("¡Vuelve pronto!")
            }
            else -> {
                println("Ups, algo salió mal, por favor ingresa una opción válida")
            }
        }
    }


}