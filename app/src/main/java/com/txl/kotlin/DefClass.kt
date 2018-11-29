package com.txl.kotlin

/**
 *@author TXL
 *description : 类的声明
 * 类声明由类名、类头（指定其类型参数、主构造函数等）以及由花括号包围的类体构成。
 * 类头与类体都是可选的； 如果一个类没有类体，可以省略花括号
 */
class Empty

/**
 * 构造函数
 * 在 Kotlin 中的一个类可以有一个主构造函数以及一个或多个次构造函数。
 * 主构造函数是类头的一部分：它跟在类名（与可选的类型参数）后。
 * 如果主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字
 * */
class Person constructor(firstName:String){}
class Person1 (firstName:String){}//省略constructor关键字

/**
 *主构造函数不能包含任何的代码。初始化的代码可以放到以
 *  init 关键字作为前缀的初始化块（initializer blocks）中
 * */
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }

    init{
        println("我是 $name")
    }
}

/**
 * 请注意，主构造的参数可以在初始化块中使用。它们也可以在类体内声明的属性初始化器中使用
 * */
class Customer(name: String) {
    val customerKey = name.toUpperCase()
}

/**
 * 声明属性，并从主构造函数初始化属性
 * */
class Person2(private var firstName: String, val lastName: String, var age: Int) {
    /**
     * 测试在函数中是否可以使用主构造函数声明的属性
     * */
    fun test(){
        println("my firstName is $firstName")
        println("my lastName is $lastName")
        println("my age is $age")
    }

    fun getFirstName():String{
        return firstName
    }

    fun setFirstName(firstName:String){
        this.firstName = firstName
    }
}

/**
 * 如果类有一个主构造函数，每个次构造函数需要委托给主构造函数， 可以直接委托或者通过别的次构造函数间接委托。
 * 委托到同一个类的另一个构造函数用 this 关键字即可
 * */
class Person3(val name: String) {
    constructor(name: String, parent: Person3) : this(name) {
//        parent.children.add(this)
    }

    constructor(name: String, parent: Person3, children:Person3) : this(name) {
//        parent.children.add(this)
    }
}


fun main(args:Array<String>){
    InitOrderDemo("王二麻子")
    var person2 =Person2("xiaozhang","zhang",18)
    person2.setFirstName("李大牛")
}

