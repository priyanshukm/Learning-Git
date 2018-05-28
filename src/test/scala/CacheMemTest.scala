package demo

import org.scalatest.FunSuite


class CacheMemTest extends FunSuite {

  test("LRU") {
    var obj = new LRU
    obj.insert("Priyanshu", "intern")
    obj.insert("Tanay", "Mentor")
    obj.insert("Varun", "Proj Leader")
    obj.insert("Shrishti", "FT")
    obj.insert("Parin", "FT")

    assert(obj.get("Priyanshu") == "intern")
    assert(obj.get("Tanay") == "Mentor")
    assert(obj.get("Varun") == "Proj Leader")
    assert(obj.get("Shrishti") == null)
    assert(obj.get("Parin") == "FT")}

  test("MFU") {
    var obj = new MFU
    obj.insert("Priyanshu", "intern")
    obj.insert("Priyanshu", "intern")
    obj.insert("Tanay", "Mentor")
    obj.insert("Varun", "Proj Leader")
    obj.insert("Shrishti", "FT")
    obj.insert("Parin", "FT")

    assert(obj.get("Priyanshu") == null)
    assert(obj.get("Tanay") == "Mentor")
    assert(obj.get("Varun") == "Proj Leader")
    assert(obj.get("Shrishti") == "FT")
    assert(obj.get("Parin") == "FT")}

  test("FIFO") {
    var obj = new FIFO
    obj.insert("Priyanshu", "intern")
    obj.insert("Tanay", "Mentor")
    obj.insert("Varun", "Proj Leader")
    obj.insert("Shrishti", "FT")
    obj.insert("Parin", "FT")

    assert(obj.get("Priyanshu") == null)
    assert(obj.get("Tanay") == "Mentor")
    assert(obj.get("Varun") == "Proj Leader")
    assert(obj.get("Shrishti") == "FT")
    assert(obj.get("Parin") == "FT")}

}
