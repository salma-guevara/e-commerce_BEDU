package user

class User(){
    lateinit var name: String
    lateinit var lastName: String
    lateinit var email: String
    lateinit var password: String

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            //Instancia de la clase User()
            val myUser = User()
            myUser.name = ""
            myUser.lastName = ""
            myUser.email = ""
            myUser.password = ""

        }
    }

}
