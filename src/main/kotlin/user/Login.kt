package user

import car.addToCar
import product.Inventario

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

                        val inventario = Inventario()

                        inventario.agregarProducto("Producto 1", 10.10, "cat1", 20)
                        inventario.agregarProducto("Producto 2", 5.50, "cat2", 10)
                        inventario.agregarProducto("Producto 3", 4.40, "cat3", 5)
                        inventario.agregarProducto("Producto 4", 2.20, "cat4", 0)

                        println("Por favor presiona 1 si quieres entrar al sistema de Inventario " +
                                "o 2 si quieres ir " +
                                "directamente al Carrito de Compra")
                        var verificacion = readLine()?.toIntOrNull()
                        if (verificacion != null) {
                            if (verificacion < 1 || verificacion > 2) {

                                println("No es una respuesta valida elige otra vez")
                                verificacion = readLine()?.toIntOrNull()
                            }
                        }
                        while (verificacion == 1) {
                            println("Bienvenid@ al Sistema del Inventario")
                            println("Selecciona una acción:")
                            println("1. Agregar un producto")
                            println("2. Eliminar un producto")
                            println("3. Buscar un producto por ID")
                            println("4. Buscar un producto por nombre")
                            println("5. Actualizar el stock de un producto")
                            println("6. Mostrar el inventario")
                            println("7. Filtrar productos por stock mínimo")
                            println("8. Salir")

                            val opcion = readLine()?.toIntOrNull()

                            when (opcion) {
                                1 -> {
                                    println("Ingrese el nombre del producto:")
                                    val nombre = readLine() ?: ""
                                    println("Ingrese el precio del producto:")
                                    val precio = readLine()?.toDoubleOrNull() ?: 0.0
                                    println("Ingrese la categoría del producto:")
                                    val categoria = readLine() ?: ""
                                    println("Ingrese el stock del producto:")
                                    val stock = readLine()?.toIntOrNull() ?: 0
                                    inventario.agregarProducto(nombre, precio, categoria, stock)
                                    println("Producto agregado correctamente.")
                                }

                                2 -> {
                                    println("Ingrese el ID del producto a eliminar:")
                                    val id = readLine()?.toIntOrNull() ?: 0
                                    inventario.eliminarProducto(id)
                                }

                                3 -> {
                                    println("Ingrese el ID del producto a buscar:")
                                    val id = readLine()?.toIntOrNull() ?: 0
                                    val producto = inventario.buscarProductoPorId(id)
                                    if (producto == null) {
                                        println("Producto no encontrado.")
                                    } else {
                                        println("Producto encontrado: ${producto.nombre} - Precio: ${producto.precio} - Categoría: ${producto.categoria} - Stock: ${producto.stock}")
                                    }
                                }

                                4 -> {
                                    println("Ingrese el nombre del producto a buscar:")
                                    val nombre = readLine() ?: ""
                                    val producto = inventario.buscarProductoPorNombre(nombre)
                                    if (producto == null) {
                                        println("Producto no encontrado.")
                                    } else {
                                        println("Producto encontrado: ${producto.nombre} - Precio: ${producto.precio} - Categoría: ${producto.categoria} - Stock: ${producto.stock}")
                                    }
                                }

                                5 -> {
                                    println("Ingrese el ID del producto a actualizar:")
                                    val id = readLine()?.toIntOrNull() ?: 0
                                    println("Ingrese la cantidad de stock a agregar (si desea restar, ingrese un número negativo):")
                                    val cantidad = readLine()?.toIntOrNull() ?: 0
                                    inventario.actualizarStock(id, cantidad)
                                    println("Stock actualizado correctamente.")
                                }

                                6 -> {
                                    inventario.mostrarInventario()
                                }

                                7 -> {
                                    println("Ingrese el stock mínimo:")
                                    val minStock = readLine()?.toInt() ?: 0
                                    val productosFiltrados = inventario.filtrarPorStock(minStock)
                                    if (productosFiltrados.isEmpty()) {
                                        println("No se encontraron productos con un stock mínimo de $minStock unidades.")
                                    } else {
                                        println("Productos con un stock mínimo de $minStock unidades:")
                                        productosFiltrados.forEach { producto ->
                                            println(
                                                "* SKU ${producto.id}: " +
                                                        "Nombre: ${producto.nombre} " +
                                                        "Precio: ${producto.precio} " +
                                                        "Categoria: ${producto.categoria}" +
                                                        "(${producto.stock} unidades)"
                                            )
                                        }
                                    }
                                }

                                8 -> {
                                    println("Hasta luego! " +
                                            "Saliendo del Sistema del Inventario" +
                                            "y entrando al Carrito de Compra")
                                    verificacion = 2

                                }
                            }
                        }
                        if (verificacion == 2) {
                            println("Bienvenido al Carrito de Compra")
                            addToCar().agregaralCarro()
                        }
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
