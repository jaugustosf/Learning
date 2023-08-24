package Operators

fun main() {
    var name = "August"           //Nome normal
    println(name.length)

    var name2: String? = "August" //
    println(name2?.length)

    var name3: String? = null     //Caso a variavel seja nula, a variavel podera retornar o null do sistema.
    println(name3?.length)
    //OU

    if(name2 != null){
        println(name2.length)
    }
}