package introduce_kotlin.lec15

fun main() {

    // 불변 List 생성
    val numbers = listOf(100, 200)

    // 가변 List 생성
    val mutableNumbers = mutableListOf(100, 200)

    // 빈 List 생성
    val intNumbers = emptyList<Int>()

    // 빈 List 타입 추론으로 생성
    printNumbers(emptyList())

    println(numbers[0])

    for (i in numbers.indices) {
        println("$i ${numbers[i]}")
    }

    for (number in numbers) {
        println(number)
    }

    for ((idx, value) in numbers.withIndex()) {
        println("$idx - $value")
    }

    val sets = setOf("100", "139")

    for (set in sets) {
        println("set in value is $set")
    }

    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "MONDAY"
    oldMap[2] = "TUESDAY"

    mapOf(
        1 to "MONDAY",
        2 to "TUESDAY"
    )

    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for (value in oldMap.values) {
        println(value)
    }

    for ((key, value) in oldMap.entries) {
        println(key)
        println(value)
    }
}

private fun printNumbers(numbers: List<Int>) {
    numbers.forEach {number -> println(number) }
}