package user

import user.Register.Companion.registerUser

abstract class Menu(){
    abstract fun initMenu()
}

class WelcomeMenu: Menu() {
    override fun initMenu() {
        println("****************************************************************************")
        println("******************************** BIENVENIDO ********************************")
        println("****************************************************************************")
        println("\nPara realiziar una compra, debes crear una cuenta e iniciar sesión.")
        println("\n¿Qué quieres hacer?")
        println("1. Regístrate ")
        println("2. Iniciar sesión ")
        println("3. Salir de la app ")
        println("\nPor favor, selecciona la acción a realizar: ")

        when (readln().toInt()) {
            1 -> {
                registerUser()
            }
            2 -> {
                println("Para iniciar sesión, primero debes crear una cuenta.")
                initMenu()
            }
            3 -> {
                println("¡Gracias por visitarnos, vuelve pronto!")
            }
            else -> {
                print("Por favor, selecciona una operación válida")
                initMenu()
            }
        }
    }
}
