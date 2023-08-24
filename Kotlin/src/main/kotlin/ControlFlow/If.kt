package ControlFlow

fun main() {
    val a = 1
    val b = 2
    val max = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }
}