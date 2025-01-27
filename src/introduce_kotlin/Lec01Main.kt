package introduce_kotlin

import java.io.BufferedReader
import java.io.FileReader

fun main() {

    var number1: Long = 1L
    number1 = 15L
    val number2: Long = 1_000L
    val integerValue = number2.toInt()

    println(number1)

    val test = test(null);
    println(test)
    lec2()
    repeat("Hello", 4, false)
    printNameAndGender(name = "기우", gender = "남")

    val arrayData = arrayOf("1", "2")
    val listData = listOf("1", "2")
    printAll(*arrayData)
    printAll()
}

fun test(str: String?): Boolean {
    val plus = str.plus("123")

    System.out.println("df" + "df")
    val v1: String = "1"
    val v2: String = "1"
    println(v1 === v2)

    println(plus)

    val number1: Int? = 10
    val number2: Long = number1?.toLong() ?: 10L

    var plusedNumber: Long = number1?.toLong() ?: (10L + number2)

    val totalMoney: Money = Money(1000) + Money(1500)
    // Money(amount=2500)
    println(totalMoney)

    listOf("1", "2").forEach { read ->
        run {
            println(read)
        }
    }

    return plus.startsWith("dd")
}

fun judgeNumber2(number: Int): String {
    return when {
        number == 0 -> {
            "주어진 숫자는 0입니다."
        }
        number % 2 == 0 -> {
            "주어진 숫자는 짝수입니다."
        }
        else -> "주어진 숫자는 홀수입니다."
    }
}

data class Money(
    val amount: Long
) {

    operator fun plus(other: Money): Money {
        return Money(this.amount + other.amount)
    }
}

fun lec2() {
    for (i in 1..3) {
        println("숫자는 $i 입니다.")
    }
}

fun parseIntOrThrow(value: String): Int {
    try {
        return value.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${value}는 숫자가 아닙니다.")
    }
}

fun parseIntOrThrow2(value: String): Int? {
    return try {
        return value.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

fun readFile(path: String) {
    BufferedReader(FileReader(path)).use { reader -> {
        println(reader.readLine())
    }}
}

fun max(a: Int, b: Int): Int = if (a > b) a else b

fun repeat(
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            println(str.plus(1L))
        }
    }
}

fun printNameAndGender(name: String, gender: String) {
    println("이름 $name / 성별 $gender")
}

fun printAll(vararg strings: String) {
    for (string in strings) {
        print(string)
    }
}