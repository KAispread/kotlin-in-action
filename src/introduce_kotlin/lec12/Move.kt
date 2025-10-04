package introduce_kotlin.lec12

fun main() {
    moveSomething(object : Movable {
        override fun move() {
            TODO("Not yet implemented")
        }

        override fun fly() {
            TODO("Not yet implemented")
        }
    })

    logSomething { println("Logging...") }
}

fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}

fun logSomething(logger: Log) {
    logger.log("df")
}