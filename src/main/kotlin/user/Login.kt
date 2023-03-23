package user

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
