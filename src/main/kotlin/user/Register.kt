package user

//import User.Login

class Register {
    companion object{
        fun registerUser(){
            println("\nBienvenido, por favor llena el formulario a continuación para crear tu cuenta nueva: ")
            val user = User()

            println("Ingresa tu nombre: ")
            val name = readln().toString()
            user.name = name

            println("Ingresa tu apellido: ")
            val lastName = readln().toString()
            user.lastName = lastName

            println("Ingresa el correo electrónico que deseas registrar: ")
            val email = readln().toString()
            user.email = email

            println("Crea una contraseña: ")
            val password = readln().toString()
            user.password = password

            println("\nRegistro exitoso, estos son los datos que ingresaste: \n")
            println("Nombre: ${user.name}")
            println("Apellido: ${user.lastName}")
            println("Correo: ${user.email}")
            println("Contraseña: ${user.password}")
            println("\nElige la siguiente acción \n1. Iniciar sesión\n2. Salir")

            when (readln().toInt()) {
                1 -> {
                    val login = Login()
                    login.login(user.email, user.password, user.name)
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
}
