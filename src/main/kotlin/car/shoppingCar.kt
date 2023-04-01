package car

import product.Product

class shoppingCar {

    private var productos : MutableList<Product> = mutableListOf()


    fun agregarProducto(articulo: Product){
        productos?.add(articulo)
    }

    fun verProductos(): MutableList<Product>? {
        return productos
    }

    fun eliminarProducto(index:Int){
        productos?.removeAt(index)
    }
}