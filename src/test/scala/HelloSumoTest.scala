package demo

import org.scalatest.FunSuite

class HelloSumoTest extends FunSuite {

  test("sayHello to Pk works correctly") {
    val hello = new HelloSumo
    assert(hello.sayHello("Pk") == "Hey, Pk")
    assert(hello.sayHello("Tanay") == "Hey, Tanay")
  }

  test("sayHello to Priyanshu works correctly") {
    val hello = new HelloSumo
    assert(hello.sayHello("Priyanshu") == "Hey, Priyanshu")
  }
}
