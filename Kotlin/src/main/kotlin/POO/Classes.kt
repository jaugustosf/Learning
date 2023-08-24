package POO

fun main() {
    val person1 = Person()
    person1.name = "João"
    person1.age = 20
    person1.sex = "Masculino"

    val person2 = Person()
    person2.name = "Paulo"
    person2.age = 22
    person2.sex = "Masculino"

    person1.Print()
    person2.Print()

    person1.UpdateName("August")
    person1.Print()
}

class Person{
    var name: String = ""
    var age: Int = 0
    var sex: String = ""

    fun Print(){
        println(name)
        println(age)
        println(sex)
    }

    fun UpdateName(NewName: String){
        name = NewName
    }
}