package com.txl.kotlin

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 *@author TXL
 *description :类的继承
 * 在 Kotlin 中所有类都有一个共同的超类 Any，这对于没有超类型声明的类是默认超类：
 */
class Example // 从 Any 隐式继承

open class Base(p: Int)

class Derived(p: Int) : Base(p)

/**
 * 如果派生类有一个主构造函数，其基类型可以（并且必须） 用基类的主构造函数参数就地初始化。
 * 如果类没有主构造函数，那么每个次构造函数必须使用 super 关键字初始化其基类型，或委托给另一个构造函数做到这一点。
 * 注意，在这种情况下，不同的次构造函数可以调用基类型的不同的构造函数
 * */

class MyView : View {
    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
}
/**
 * 主构造函数直接调用父类
 * */
class MyView1 (ctx: Context, attrs: AttributeSet?): View(ctx,attrs) {
    init{

    }

}

/**
 * 覆盖方法
 * 我们之前提到过，Kotlin 力求清晰显式。与 Java 不同，Kotlin 对于可覆盖的成员（我们称之为开放）以及
 * 覆盖后的成员需要显式修饰符：
 * 没有被open修饰的类不能被继承，没有被open修饰的方法不能被重写
 * Derived.v() 函数上必须加上 override 修饰符。如果没写，编译器将会报错。 如果函数没有标注 open 如
 * Base.nv()，那么子类中不允许定义相同签名的函数， 不论加不加 override。将 open 修饰符添加到 final 类
 * （即没有 open 的类）的成员上不起作用
 * */
open class BaseA {
    open fun v() {  }
    fun nv() {}
}
class DerivedA() : BaseA() {
    override fun v() { }

}

/**
 * 覆盖属性
 * 属性覆盖与方法覆盖类似；在超类中声明然后在派生类中重新声明的属性必须以 override 开头，并且它们
 * 必须具有兼容的类型。每个声明的属性可以由具有初始化器的属性或者具有 getter 方法的属性覆盖
 * */
open class Foo {
    open val x: Int get() { return 5 }
}

class Bar1 : Foo() {
    override val x: Int=10
}

/**
 * 你也可以用一个 var 属性覆盖一个 val 属性，但反之则不行。这是允许的，因为一个 val 属性本质上
 * 声明了一个 getter 方法，而将其覆盖为 var 只是在子类中额外声明一个 setter 方法
 * fixme 有点不明白
 * */
interface Foo1 {
    val count: Int
}

class Bar2(override val count: Int) : Foo1

class Bar3 : Foo1 {
    override var count: Int = 0
}

open class A {
    open fun f() { print("A") }
    fun a() { print("a") }
}

interface B {
    fun f() { print("B") } // 接口成员默认就是“open”的
    fun b() { print("b") }
}

class C() : A(), B {
    // 编译器要求覆盖 f()：
    override fun f() {
        super<A>.f() // 调用 A.f()
        super<B>.f() // 调用 B.f()
    }
}

/**
 * 伴生对象
 * 与 Java 或 C# 不同，在 Kotlin 中类没有静态方法。在大多数情况下，它建议简单地使用包级函数。
 * 如果你需要写一个可以无需用一个类的实例来调用、但需要访问类内部的函数（例如，工厂方法），你可以把它写成该类内对象
 * 声明中的一员。
 * 更具体地讲，如果在你的类内声明了一个伴生对象， 你就可以使用像在 Java/C# 中调用静态方法相同的语法来调用其成员，只
 * 使用类名作为限定符
 * */