package ControlFlow

fun main() {
    val input = "F"
    when (input) {
        "M" -> println("Masculino")
        "F" -> println("Feminino")
        else -> {
            println("Indefinido")
        }
    }
    println("Gênero de entrada: $input")
}