package product

import kotlin.concurrent.thread

data class Producto(
    val id: Int,
    val nombre: String,
    var precio: Double,
    var categoria: String,
    var stock: Int)

class Inventario {

    companion object{
        private var siguienteId = 0
    }
    private val inventario = mutableListOf<Producto>()

    fun agregarProducto(nombre: String,precio: Double,categoria: String,stock: Int) {
        val producto = Producto(++siguienteId, nombre, precio , categoria , stock)
        inventario.add(producto)
    }

    //funcion lambda
    fun eliminarProducto(id: Int) {
        inventario.removeIf { it.id == id }
        mostrarInventario()
    }

    fun buscarProductoPorId(id: Int): Producto? {
        return inventario.find { it.id == id }

    }

    fun buscarProductoPorNombre(nombre: String): Producto? {
        return inventario.find { it.nombre == nombre }
    }

    //threading
    fun actualizarStock(id: Int, cantidad: Int) {
        thread {
            inventario.find { it.id == id }?.let { producto ->
                producto.stock += cantidad
            }
        }

    }

    fun mostrarInventario() {
        println("Inventario:")
        for (producto in inventario) {
            println("* SKU ${producto.id}: " +
                    "Nombre: ${producto.nombre} " +
                    "Precio: ${producto.precio} " +
                    "Categoria: ${producto.categoria}" +
                    "(${producto.stock} unidades)")
        }
    }

    fun filtrarPorStock(minimo: Int): List<Producto> {
        return inventario.filter { it.stock >= minimo }
    }
}






