fun main() {
    var name = "August"
    println(name.length)
    println(name.uppercase())
    println(name.lowercase())
    println(name[0])
    println(name[2])

    var age = 20
    var msg = "$name tem $age anos. "

    println(msg)

    var email = """
        Hello
        %s
        How
        Are
        You
    """.trimIndent()
    println(email.format("Paulor"))
}