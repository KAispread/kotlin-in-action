package introduce_kotlin.lec14

fun main() {
    val dto1 = PersonDto(name = "이기우",  age = 100)
    val dto2 = PersonDto("이기우", 100)
    println(dto1 == dto2)
}

data class PersonDto(
    val name: String,
    val age: Int
)