package introduce_kotlin.lec17

import introduce_kotlin.printAll

fun main() {
    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_200),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박", 10_000)
    )

    // Lambda 를 만드는 방법 1
    val isApple = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }
    val isAppleWithType: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    // Lambda 를 만드는 방법 2
    val isApple2 = { fruit: Fruit -> fruit.name == "사과"}
    val isApple2WithType: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과"}

    // Lambda 를 호출하는 방법1
    isApple(fruits[0])
    // Lambda 를 호출하는 방법2
    isApple2.invoke(fruits[0])

    filterFruits(fruits) { it.name == "사과"}
        .forEach { fruit -> println(fruit) }
}

fun filterFruits(
    fruits: List<Fruit>,
    fruitFilter: (Fruit) -> Boolean
): List<Fruit> {
    return fruits.filter(fruitFilter).toMutableList()
}