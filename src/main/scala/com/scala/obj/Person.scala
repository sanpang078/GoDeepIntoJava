package com.scala.obj

class Person {
  var name = ""
  var age = 0
  override def toString: String = s"$name is $age years old."

  def this(name: String) = {
    this()
    this.name = name
  }

}

object Person {
  def apply(name: String, age: Int) = {
    var p = new Person()
    p.name = name
    p.age = age
    p
  }

}

object PersonTest {
  def main(args: Array[String]): Unit = {

    val joe = new Person("Joe")
    println(joe.toString)

    val p = Person("Fred", 29)
    println(p.toString)

  }
}