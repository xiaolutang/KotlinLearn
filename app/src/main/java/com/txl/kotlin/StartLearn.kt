package com.txl.kotlin

import android.support.constraint.solver.widgets.Rectangle
import java.util.*
/**
 * Copyright (c) 2018, 唐小陆 All rights reserved.
 * author：txl
 * date：2018/11/24
 * description：
 */

/**
 * 定义函数
 * 参数定义 -- 参数名：参数类型
 * 返回值定义括号后 ：+返回值类型
 * */

fun sum(a:Int, b:Int):Int{
    return a+b
}

/**
 * 将表达式作为函数体、返回值类型自动推断的函数
 * */
fun sum1(a:Int, b:Int) = a+b

/**
 * 函数返回无意义的值 感觉有点像无返回值
 * */
fun printSum(a:Int, b:Int):Unit{
    println("sum of $a and $b is ${a + b}")
}

/**
 * 返回Unit值可以省略
 * */
fun printSum1(a:Int, b:Int){
    println("sum of $a and $b is ${a + b}")
}

/**
 * 定义变量
 * val 为只读变量，只能赋值一次
 * var 可以重新辅助
 * */
fun createVariable(){
    val a: Int = 1  // 立即赋值
    val b = 2   // 自动推断出 `Int` 类型
    val c: Int  // 如果没有初始值类型不能省略
    c = 3       // 明确赋值


    var x = 5 // 自动推断出 `Int` 类型
    x += 1
}

/**
 * 创建顶层变量
 * */
val PI = 3.14
var x = 0

fun incrementX() {
    x += 1
}

/**
 * 使用字符串模板
 * */
var a = 1
// 模板中的简单名称：
fun testString(){
    val s1 = "a is $a" //字符串中使用$变量名 获取变量值
    a = 2
// 模板中的任意表达式：
    val s2 = "${s1.replace("is", "was")}, but now is $a" //$后节{}，括号里面是表达式
}

/**
 * 使用条件表达式
 * */
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

/**
 * 使用可空值及null检测
 * 当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空
 * 这里返回值可以为空，在Int后加?
 * */
fun parseInt(str:String):Int?{
   return Integer.parseInt(str)
}

/**
 * 使用返回可空值的函数
 * */
fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)
    // 直接使用 `x * y` 会导致编译错误，因为他们可能为 null
    if (x != null && y != null) {
        // 在空检测后，x 与 y 会自动转换为非空值（non-nullable）
        println(x * y)
    }
    else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

/**
 * 使用类型检测及自动类型转换
 * is 运算符检测一个表达式是否某类型的一个实例。 如果一个不可变的局部变量或属性已经判断出为某类型，
 * 那么检测后的分支中可以直接当作该类型使用，无需显式转换
 * */
fun getStringLength(obj:Any):Int?{
    if (obj is String){
        return obj.length
    }
    return null
}

/**
 * for循环
 * */
fun testFor(){
    val items = listOf("apple", "banana", "kiwifruit") // 创建一个列表
    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

/**
 * while循环
 * */
fun testWhile(){
    val items = listOf("apple", "banana", "kiwifruit")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

/**
 * when表达式
 * 感觉像 java switch
 * */
fun describe(obj: Any): String =
        when (obj) {
            1          -> "One"
            "Hello"    -> "Greeting"
            is Long    -> "Long"
            !is String -> "Not a string"
            else       -> "Unknown"
        }

/**
 *使用区间（range）
 * */
fun testRange(){
//    使用 in 运算符来检测某个数字是否在指定区间内：
    val x = 10
    val y = 9
    if (x in 1..y+1) {
        println("fits in range")
    }
//    检测某个数字是否在指定区间外
    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }
    //区间迭代:
    for (x in 1..5) {
        print(x)
    }
//    数列迭代 step每一步加2
    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    // 做递减操作，每次减3
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
//    对集合进行迭代:
    val items = listOf("a", "b", "c")
    for (item in items) {
        println(item)
    }
//    使用 in 运算符来判断集合内是否包含某实例
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
//    使用 lambda 表达式来过滤（filter）与映射（map）集合
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}

/**
 * 创建基本类及其实例
 * */
fun createObj(){
    var friut = Friut() //不需要使用new 关键字
//    val rectangle = Rectangle(5.0, 2.0) // 不需要“new”关键字
//    val triangle = Triangle(3.0, 4.0, 5.0)
}

class Friut{}