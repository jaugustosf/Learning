package Operators

fun main() {
    var b: String? = null //"abc"
    val l: Int = if (b != null) b.length else -1
    println(l)

    //Using Elvis operator

    val l2 = b?.length ?: -1
    println(l2)
}