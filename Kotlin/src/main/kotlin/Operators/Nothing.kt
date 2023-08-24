package Operators

fun main() {
    //O nothing é algo que nunca termina.
    NeverStop()
}
fun NeverStop(): Nothing{
    while (true) {
        Thread.sleep(1000)
        println("Salve")
    }
}