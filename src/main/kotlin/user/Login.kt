package user

import car.addToCar
import product.Product

class Login {
    fun login(email: String, password: String, name: String){

        println("\nPor favor, ingresa tus datos para iniciar sesión: ")
        println("Ingresa tu correo: ")
        val currentEmail = readln().toString()

        if(currentEmail == email){
            println("Ingresa tu contraseña: ")
            val currentPassword = readln().toString()
            if(currentPassword == password){
                println("\nBienvenid@ ${name}, tu sesión se ha iniciada correctamente.")
                println("\nElige la siguiente acción " +
                        "\n1. Ver productos" +
                        "\n2. Pagos" +
                        "\n3. Envíos" +
                        "\n4. Devoluciones" +
                        "\n5. Preguntas frecuentes")

                when (readln().toInt()) {
                    1 -> {
                        //Agregar funcionalidad
                        println("Lista de productos")
                        val producto1 = Product(1,"Celular",20000.00,"Equipo celular de última generación")
                        val producto2 = Product(2,"Figura de acción",800.00,"Figura de acción de plástico")
                        val producto3 = Product(3,"Pantalones",20000.00,"Equipo celular de última generación")
                        val producto4 = Product(4,"Celular",20000.00,"Equipo celular de última generación")
                        val producto5 = Product(5,"Celular",20000.00,"Equipo celular de última generación")
                        println("SKU: ${producto1.id} ${producto1.name}  :$ ${producto1.price}" )
                        println("SKU: ${producto2.id} ${producto2.name}  :$ ${producto2.price}")
                        println("SKU: ${producto3.id} ${producto3.name}  :$ ${producto3.price}")
                        println("SKU: ${producto4.id} ${producto4.name}  :$ ${producto4.price}")
                        println("SKU: ${producto5.id} ${producto5.name}  :$ ${producto5.price}")

                        addToCar().agregaralCarro()
                    }
                    2 -> {
                        //Agregar funcionalidad

                        println("Estás pagando")
                    }
                    3 -> {
                        //Agregar funcionalidad
                        println("Checando envíos")
                    }
                    4 -> {
                        //Agregar funcionalidad
                        println("Checando devoluciones")
                    }
                    5 -> {
                        //Agregar funcionalidad
                        println("Preguntas frecuentes")
                    }
                    else -> {
                        println("Ups, algo salió mal, por favor ingresa una opción válida")
                    }
                }
            }else{
                println("\nLo sentimos, los datos introducidos no son correctos :(")
                login(email, password, name)
            }
        }else{
            println("\nLo sentimos, los datos introducidos no son correctos.")
            login(email, password, name)
        }
    }


}
