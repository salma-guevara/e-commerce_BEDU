package product

import kotlin.properties.Delegates

abstract class Product {

    lateinit var name : String
    abstract var price : Double
    lateinit var description: String




}