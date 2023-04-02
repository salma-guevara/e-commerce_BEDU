package car
import product.*

class shoppingCar {

    private var productos : MutableList<Producto> = mutableListOf()


    fun agregarProducto(articulo: Producto){
        productos?.add(articulo)
    }

    fun verProductos(): MutableList<Producto>? {
        return productos
    }

    fun eliminarProducto(index:Int){
        productos?.removeAt(index)
    }
}