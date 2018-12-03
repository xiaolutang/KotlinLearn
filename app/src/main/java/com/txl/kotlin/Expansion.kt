package com.txl.kotlin

/**
 *@author TXL
 *description :扩展
 * Kotlin 同 C# 与 Gosu 类似，能够扩展一个类的新功能而无需继承该类或使用像装饰者这样的任何类型的设
 * 计模式。 这通过叫做 扩展 的特殊声明完成。Kotlin 支持 扩展函数 与 扩展属性。
 */

/**
 * 扩展函数
 * 声明一个扩展函数，我们需要用一个 接收者类型 也就是被扩展的类型来作为他的前缀。
 * 下面代码为 MutableList<Int> 添加一个swap 函数：
 * */
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // “this”对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}

/**
 * 如果一个类定义有一个成员函数与一个扩展函数，而这两个函数又有相同的接收者类型、相同的名字，
 * 都适用给定的参数，这种情况总是取成员函数。 例如：
 * */
class CC {
    fun foo() { println("member") }
}

fun CC.foo() { println("extension") }