package introduce_kotlin

fun main() {
    val person = Person()
    print(person.name)
}

class Person(
    name: String = "1",
    var age: Int
) {

    val name: String = name
        get() = field.uppercase()

    init {
        if (age >= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
        println("init block")
    }

    // 부생성자 1
    constructor(name: String): this(name, -1) {
        println("sub 1 init")
    }

    // 부생성자 2
    constructor(): this("홍길동") {
        println("let's go ~~")
    }

    fun isAdult(): Boolean {
        return this.age >= 20
    }
}

class Person2 {
    fun make(): Unit {
        print("go")
    }
}
