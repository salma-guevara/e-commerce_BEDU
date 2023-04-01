package car

import product.Product
import user.Login
import user.User

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
                val producto1 = Product(1,"Celular",20000.00,"Equipo celular de última generación")
                val producto2 = Product(2,"Figura de acción",800.00,"Figura de acción de plástico")
                val producto3 = Product(3,"Pantalones",20000.00,"Equipo celular de última generación")
                val producto4 = Product(4,"Celular",20000.00,"Equipo celular de última generación")
                val producto5 = Product(5,"Celular",20000.00,"Equipo celular de última generación")
                val lista = mapOf<Int,Product>(
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
                        total += car.verProductos()!!.get(i).price
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