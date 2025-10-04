package introduce_kotlin.lec11

val g = 3

fun add(a: Int, b: Int): Int {
    return a + b;
}

open class Cat protected constructor(a: Int)

class Car(
    internal val name: String,
    private val owner: String,
    _price: Int
) {

    var price = _price
        private set
}
