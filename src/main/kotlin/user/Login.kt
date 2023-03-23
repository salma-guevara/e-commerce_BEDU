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
