package com.scala.obj

class Student(name: String) {
  def say() = {
    println(s"我叫${name}")
  }
}

object Student{
  var school = "家里蹲大学"
  def where() = {
    println(s"我是${school}的")
  }
}

object StudentTest{
  def main(args: Array[String]): Unit = {
    //静态方法
    Student.where()
    //非静态方法
    new Student("三胖").say()
  }
}
