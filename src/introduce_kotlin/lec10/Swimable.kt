package introduce_kotlin.lec10

interface Swimable {

    val swimAbility: Int

    fun act() {
        println(swimAbility)
        println("어푸어푸")
    }
}