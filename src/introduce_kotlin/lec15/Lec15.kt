package introduce_kotlin.lec15

fun main() {
    val array = arrayOf(100, 200)
    array.plus(300)

    // index 를 순회
    for (i in array.indices) {
        println("$i - $array[i]")
    }

    // index 와 value를 한꺼번에 받는 방법
    for ((idx, value) in array.withIndex()) {
        println("$idx - $value")
    }
}