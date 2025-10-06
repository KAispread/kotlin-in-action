package introduce_kotlin.lec20

import introduce_kotlin.lec19.Person

fun main() {
    // let use case 1
    val strings = listOf("APPLE", "CAR")
    strings.map { it.length }
        .filter { it > 3 }
        .let { lengths -> println(lengths) }
    // let use case 2
    val str: String? = strings?.toString()
    val length = str?.let {
        println(it.uppercase())
        it.length
    }
    // let use case 3
    val numbers = listOf("one", "two", "three", "four")
    val modifiedFirstItem = numbers.first()
        .let { firstItem ->
            if (firstItem.length >= 5) firstItem else "!$firstItem"
        }.uppercase()

    // run use case 1
    val personRepository = PersonRepository()
    val person = Person("이기우", 10).run(personRepository::save)

    // also
    val numbersMutable = mutableListOf("one", "two", "three")
    print("four 추가 이전 지금 값 : $numbersMutable")
    numbersMutable.add("four")

    mutableListOf("one", "two", "three")
        .also { print("four 추가 이전 지금 값 : $numbersMutable") }
        .add("four")
}

class PersonRepository {
    fun save(person: Person): Person {
        return person
    }
}

class PersonDto(
    name: String,
    age: Int
)

fun printPerson(person: Person?) {
    person?.let { p ->
        println(p.name)
        println(p.age)
    }
    if (person != null) {
        println(person.name)
        println(person.age)
    }

    val value1: Int? = person?.let {
        it.age
    }
    val value2: Int? = person?.run {
        this.age
    }
    val value3: Person? = person?.also {
        it.age
    }
    val value4: Person? = person?.apply {
        this.age
    }
    with(person) {
        print(this?.age)
        print(this?.name)
    }
}

fun createPerson(
    name: String,
    age: Int
): Person {
    return Person(
        name = name,
        age = 10
    ).apply {
        name.first()
    }
}

fun convertToDto(person: Person): PersonDto {
    return with(person) {
        PersonDto(
            name = name,
            age = age
        )
    }
}