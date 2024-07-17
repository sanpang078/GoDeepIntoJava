package com.scala.implicits

import com.scala.implicits.Implicits.say

//import com.scala.implicits.Implicits.ExpandA

class ClosedA {
  def greet() = {
    println("hello , i am ClosedA.")
  }

}

class ExpandA() {
      def say() = {
        println("hello , i am from ExpandA.")
      }
    }
object Implicits {
//1.隐式类实现隐式转换
//  implicit class ExpandA(closedA: ClosedA) {
//    def say() = {
//      println("hello , i am from ClosedB.")
//    }
//  }

  //2.隐式方法实现隐式转换
  implicit def say(closedA: ClosedA): ExpandA = { new ExpandA() }
}

object Test {
  def main(args: Array[String]): Unit = {
    val a = new ClosedA()
    a.greet()
    a.say()
  }
}