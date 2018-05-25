package demo

import org.scalatest.FunSuite

class NewtonSqRootTest extends FunSuite {
  test("Test 1") {
    val result = new NewtonSqRoot
    val eps = 0.0000001
    assert(result.abs(result.calcRoot(1, 9) - 3.0) < eps)
  }
}
