fun main() {
    val name1 = "Saleh"
    val name2 = "Jamila"
    val name3 = "Saleh"
    val name4 = String("Saleh".toCharArray())

    println("Nome1 é igual a nome2? ${name1 == name2}")
    println("Nome1 é igual a nome3? ${name1 == name3}")
    println("Nome1 é igual a nome4? ${name1 == name4}")
    println("O endereço de memoria Nome1 é igual ao nome3? ${name1 === name3}")
    println("O endereço de memoria Nome1 é igual ao nome4? ${name1 === name4}")
}
