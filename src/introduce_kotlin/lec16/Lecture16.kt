package introduce_kotlin.lec16

fun main() {
    val anyStr = "abc"
    // c
    println(anyStr.lastChar())
}

fun String.lastChar(): Char {
    return this[this.length - 1]
}

class Person(
    private val firstName: String,
    private val lastName: String,
    val age: Int
) {

    fun nextYearAge(): Int {
        println("멤버 함수")
        return this.age + 1
    }
}

fun Person.nextYearAge(): Int {
    println("멤버 함수")
    return this.age + 1
}

open class Train(
    val name: String = "새마을기차",
    val price: Int = 5_000,
)

fun Train.isExpensive(): Boolean {
    println("Train의 확장함수")
    return this.price >= 10_000
}

class Srt : Train(name = "SRT", 40_000)

fun Srt.isExpensive(): Boolean {
    println("Srt의 확장함수")
    return this.price >= 10_000
}

val String.lastChar: Char
    get() = this[this.length - 1]

inline fun Int.add(other: Int): Int {
    return this + other
}