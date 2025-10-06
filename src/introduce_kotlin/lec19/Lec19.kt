package introduce_kotlin.lec19

import introduce_kotlin.lec18.Fruit
import introduce_kotlin.lec19.a.printHelloWorld as printHelloWorldA
import introduce_kotlin.lec19.b.printHelloWorld as printHelloWorldB

fun main() {
    // as import
    printHelloWorldA()
    printHelloWorldB()

    // 구조분해
    val person = Person("이기우", 10)
    val (name, age) = person
    println("이름은 $name, 나이는 $age 이다.")

    val numbers = listOf(1, 2, 3)
    // break
    run {
        numbers.map { it + 1 }
            .forEach {
                if (it == 2) return@run
                println(it)
            }
    }
    // continue
    numbers.map { it + 1 }
        .forEach {
            if (it == 2) return@forEach
            println(it)
        }

    abc@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 2) {
                break@abc
            }
            print("i = $i j = $j")
        }
    }

    val lecture = Lecture(10, "ha")
    val copy = lecture.copy(name = "dd")
}

// 구조분해
class Person(
    val name: String,
    val age: Int
) {
    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): Int {
        return this.age
    }
}

data class Lecture(
    val number: Int,
    val name: String
)

// with type alias
typealias FruitFilter = (Fruit) -> Boolean

fun filterFruit(fruits: List<Fruit>, filter: (Fruit) -> Boolean) {
}

fun filterFruitWithTypeAlias(fruits: List<Fruit>, filter: FruitFilter) {
}

data class UltraSuperGuardianTribe(
    val name: String
)

typealias UltraSuperCollection = Map<String, UltraSuperGuardianTribe>

fun getPersonOfNullIf(person: Person): Person? {
    return person.takeIf { it.age > 10 }
}

fun getPersonOfNullUnless(person: Person): Person? {
    return person.takeUnless { it.age <= 10 }
}