package introduce_kotlin.lec12

fun main() {
    val newBaby = Person.newBaby("new1")
    Person.log("value")

    println(Singleton.a)
    Singleton.a += 1;
    println(Singleton.a)
}

class Person private constructor(
    var name: String,
    var age: Int
){

    companion object Factory : Log {
        private const val MIN_AGE = 1

        @JvmStatic
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log(value: String) {
            print(value)
        }
    }
}

object Singleton {
    var a: Int = 0
}
