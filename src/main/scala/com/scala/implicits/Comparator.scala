package com.scala.implicits

import sun.tools.jar.Main

trait Comparator[A]{
  def compare(x: A, y: A): Int

}

object Comparator {
  implicit object IntComparator extends Comparator[Int] {
    override def compare(x: Int, y: Int): Int = Integer.compare(x, y)
  }
  implicit object StringComparator extends Comparator[String] {
    override def compare(x: String, y: String): Int = x.compareTo(y)
  }
}

object AppMain {
  def max[A](x: A, y: A)(implicit comparator: Comparator[A]): A =
    if (comparator.compare(x, y) >= 0) x else y
  def main(args: Array[String]): Unit = {
    println(max(10, 6))
    println(max("hello", "world"))
  }
}


