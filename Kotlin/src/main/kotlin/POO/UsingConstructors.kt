package POO

fun main() {
    val User1 = User("João", 20, "Masculino")

    val User2 = User("Paulo", 22, "Masculino")

    User1.Print()
    User2.Print()

    User1.UpdateName("August")
    User1.Print()
}

class User(var name: String = "", var age: Int = 0, var sex: String = ""){
    fun Print(){
        println(name)
        println(age)
        println(sex)
    }

    fun UpdateName(NewName: String){
        name = NewName
    }
}