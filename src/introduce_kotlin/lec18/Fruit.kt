package introduce_kotlin.lec18

data class Fruit(
    val id: Long,
    val name: String,
    val factoryPrice: Long,
    val currentPrice: Long,
) {

    fun nullOrValue(): Fruit? =
        this.takeIf {
            listOf(id, name, factoryPrice, currentPrice).any { it != null }
        }

    val isSamePrice: Boolean
        get() = factoryPrice == currentPrice
}