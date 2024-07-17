package com.scala.implicits

class User(id: Long) {

}
object Conversion {
  def findUserById(id: Long): Option[User] = {
    Option(new User(id))
  }

  def main(args: Array[String]): Unit = {
    val id: Int = 42
    findUserById(id)
  }

}
