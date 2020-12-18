package com.example.shymko_hw_lessson5_091220


/*

Создать новый проект - FamilyTree.
В нём будет класс Person. У этого класса будут такие поля как:

Имя
Возраст
Мама (тип класс Person)
Папа (тип класс  Person)
Братья и сёстры: (тип массив класса Person)
Количество известных родственников (должен высчитываться автоматически, а не просто быть записан числом!)

В проекте должна быть функция getMe():
Person , которая вернёт объект класса Person, заполненный вашими данными (для тех, кто боится передавать в мои руки данные родственников, они могут быть фейковые). Дерево ваших родственников должно как минимум включать в себя бабушек\дедушек и сестёр\братьев своих, а также родителей\бабушек\дедушек.В итоге у вас должно получиться дерево такого вида (см. на картинку). В таком случае количество родственников  равно 11.

*/
interface Mother{
fun sayHelloMother(): String
}

interface Father{
    fun sayHelloFather(): String
}
interface Me{
    fun sayHelloMe(): String
}
interface SisterBrother{
    fun sayHelloSisterBrother(): String
}


open class Person: Me, Mother,Father,SisterBrother {
    constructor ( name:String, age:Int, mother:Mother, father: Father, sisterbruther:Array<SisterBrother>) {
        var name: String = name
        var age: Int = age
        var mother: Mother = mother
        var father: Father = father
        val sisterbruther: Array<SisterBrother> = sisterbruther

        println("My name is $name, my age is =$age, i have mother =${mother.toString()}, and father = $father, and sisteBruther = $sisterbruther")


    }
    constructor (name: String, age:Int, mother:Mother, father: Father) {
        var name: String = name
        var age: Int = age
        var mother : Mother = mother
        var father: Father=father

        println("My name is $name, my age is =$age, i have mother =${mother}, and father = $father")


    }

    constructor ( name:String , age:Int) {
        var name: String = name
        var age: Int = age

        println("My name is $name, my age is =$age")
    }

    override fun sayHelloMother(): String {
       return "Hello it's Mother"
    }

    override fun sayHelloFather(): String {
        return "Hello it's Father"
    }

    override fun sayHelloMe(): String {
        return "Hello it's Me"
    }

    override fun sayHelloSisterBrother(): String {
        return "Hello it's SisterBrother"
    }


}



fun main() {
    println("Hello from START main_____________")
    val motherOfMother:Mother = Person("motherOfMother",80)
    val fatherOfMother:Father = Person("futherOfMother",80)
    val motherOfFather:Mother = Person("motherOfFather",80)
    val fatherOfFather:Father = Person("futherOfFather",80)
    val sisterOfMyMother:SisterBrother = Person("sisterOfMyMother",49, motherOfMother, fatherOfMother)
    val arrSisterBrother = arrayOf(sisterOfMyMother)
    val mother= Person("Muther",53, motherOfMother,fatherOfMother,arrSisterBrother)
    val father:Father = Person("Father", 53,motherOfFather,fatherOfFather)
    val mySister1 :SisterBrother = Person("mySister1",15, mother, father)
    val mySister2 :SisterBrother = Person("mySister2",2, mother, father)
    val arrMySisterBrother = arrayOf(mySister1,mySister2)
    val me:Me = Person("Me", 29,  mother = mother,father = father,sisterbruther =arrMySisterBrother )


    println("Hello from getMe method = "+getME(me))

    println("Hello from END main______________")
}



fun getME( me:Me) : Person{
    var me:Me =me
    return me as Person
}






