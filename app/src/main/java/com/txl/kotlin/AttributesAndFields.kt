package com.txl.kotlin

/**
 *@author TXL
 *description :属性与字段
 */

/**
 * 声明属性
 * Kotlin的类可以有属性。 属性可以用关键字var 声明为可变的，否则使用只读关键字val
 * */
class Address {
    var name: String = ""
    var street: String = ""
    var city: String = ""
    var state: String? = null
    var zip: String = ""

    /**
     * 属性的使用
     * */
    fun copyAddress(address: Address): Address {
        val result = Address() // Kotlin 中没有“new”关键字
        result.name = address.name // 将调用访问器
        result.street = address.street
        return result
    }
}


/**
 * 幕后字段
 * 在 Kotlin 类中不能直接声明字段。然而，当一个属性需要一个幕后字段时，Kotlin 会自动提供。
 * 这个幕后字段可以使用field标识符在访问器中引用
 * fixme 不是太懂
 * */
var counter = 0 // 注意：这个初始器直接为幕后字段赋值
    set(value) {
        if (value >= 0) field = value
    }

/**
 * 延迟初始化属性与变量
一般地，属性声明为非空类型必须在构造函数中初始化。 然而，这经常不方便。例如：属性可以通过依赖注入来初始化， 或者在单元测试的 setup 方法中初始化。 这种情况下，你不能在构造函数内提供一个非空初始器。 但你仍然想在类体中引用该属性时避免空检查。

为处理这种情况，你可以用 lateinit 修饰符标记该属性
 * */
//public class MyTest {
//    lateinit var subject: TestSubject
//
//    @SetUp fun setup() {
//        subject = TestSubject()
//    }
//
//    @Test fun test() {
//        subject.method()  // 直接解引用
//    }
//}

