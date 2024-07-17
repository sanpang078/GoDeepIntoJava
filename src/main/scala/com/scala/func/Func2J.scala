package com.scala.func

class Func2J {
    def action(site: String,func: String => Unit) = {
      func(site)
    }
}

object Func2JTest {
  def main(args: Array[String]): Unit = {
    val f = new Func2J()
    f.action("三胖", (s: String) => {println(s)})
  }
}
