package introduce_kotlin.lec18

fun main() {
    val fruits = listOf(
        Fruit(1L, "사과", 1_000, 1_500),
        Fruit(1L, "사과", 1_200, 1_900),
        Fruit(1L, "사과", 1_400, 1_800),
        Fruit(1L, "사과", 1_100, 1_500),
        Fruit(1L, "바나나", 2_000, 2_500),
        Fruit(1L, "바나나", 3_000, 4_500),
        Fruit(1L, "바나나", 2_500, 3_500),
        Fruit(1L, "수박", 5_000, 7_500)
    )

    // filter
    val apples = fruits.filter { it.name == "사과" }
    val applesWithIndexed = fruits.filterIndexed { idx, fruit ->
        println(idx)
        fruit.name == "사과"
    }

    // map
    val applePrices = fruits.filter { it.name == "사과" }
        .map { it.currentPrice }
    val applePricesWithIndex = fruits.filter { it.name == "사과" }
        .mapIndexed { idx, fruit ->
            println(idx)
            fruit.currentPrice
        }
    val applePricesNotNull = fruits.filter { it.name == "사과" }
        .mapNotNull { fruit -> fruit.nullOrValue() }

    // all
    val isAllApple = fruits.all { fruit -> fruit.name == "사과" }

    // none
    val isNoApple = fruits.none { fruit -> fruit.name == "사과" }

    // any
    val isNoExpensiveApple = fruits.any { fruit -> fruit.factoryPrice >= 10_000 }

    // count
    val count = fruits.count()

    // sort
    val sortedBy = fruits.sortedBy { fruit -> fruit.factoryPrice }
    val sortedByDescending = fruits.sortedByDescending { fruit -> fruit.factoryPrice }

    // distinctBy
    val distinctFruitNames = fruits.distinctBy { fruit -> fruit.name }
        .map { fruit -> fruit.name }

    // first
    fruits.first()
    fruits.firstOrNull()

    // last
    fruits.last()
    fruits.lastOrNull()

    // List to Map
    val groupBy1: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
    val groupBy2: Map<String, List<Long>> = fruits.groupBy({ fruit -> fruit.name }, { fruit -> fruit.factoryPrice })

    val associateBy1: Map<Long, Fruit> = fruits.associateBy { fruit -> fruit.id }
    val associateBy2: Map<Long, Long> = fruits.associateBy({ fruit -> fruit.id }, { fruit -> fruit.factoryPrice })

    // Flatten
    val fruitsInList: List<List<Fruit>> = listOf(
        listOf(
            Fruit(1L, "사과", 1_000, 1_500),
            Fruit(1L, "사과", 1_200, 1_900),
            Fruit(1L, "사과", 1_400, 1_800),
            Fruit(1L, "사과", 1_100, 1_500)
        ),
        listOf(
            Fruit(1L, "바나나", 2_000, 2_500),
            Fruit(1L, "바나나", 3_000, 4_500),
            Fruit(1L, "바나나", 2_500, 3_500)
        ),
        listOf(
            Fruit(1L, "수박", 5_000, 7_500)
        )
    )
    fruitsInList.flatMap { list ->
        list.filter { fruit -> fruit.factoryPrice == fruit.currentPrice }
    }
    fruitsInList.flatMap { list -> list.samePriceFilter }
    val flattenList3: List<Fruit> = fruitsInList.flatten()
}

val List<Fruit>.samePriceFilter: List<Fruit>
    get() = this.filter(Fruit::isSamePrice)