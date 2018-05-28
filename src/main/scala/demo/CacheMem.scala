package demo

trait CacheMem {
  protected var map = scala.collection.mutable.Map[Any, Any]()
  protected var MAXSIZE = 4

  def insert(key : Any, value: Any) : Unit
  def get(key : Any): Any = {
    return map.getOrElse(key, null)
  }

  def remove(key : Any): Boolean = {
    if(map.keySet.exists(_ == key) == true) {
      map -= (key, get(key))
      return true
    }
    return false
  }
}

class LRU extends CacheMem {
  var k : Any = null
  var v : Any = null

  def insert(key: Any, value: Any): Unit = {
    if(map.size < MAXSIZE) {
      map.put(key, value)
    }
    else {
      if(map.exists(_ == (key,value)) == false) {
        //println(k +  " "  +  v + "Removed")
        map -= (k,v)
        map.put(key,value)
      }
    }
    k = key
    v = value
    //println(k +  " "  +  v + "Last inserted")
  }
}

class MFU extends CacheMem {
  var freq = scala.collection.mutable.Map[Any, Int]().withDefaultValue(0)

  def insert(key: Any, value: Any): Unit = {
    if(map.size < MAXSIZE) {
      map.put(key, value)
    }
    else {
      if (map.exists(_ == (key, value)) == false) {
        val k = freq.maxBy((_._2))._1
        map -= (k, get(k))
        map.put(key,value)
      }
    }
    freq(key) += 1
  }
}

class FIFO extends CacheMem {
  private var q = scala.collection.mutable.Queue[Any]()

  def insert(key: Any, value: Any): Unit = {
    if(map.size < MAXSIZE) {
      map.put(key, value)
    }
    else {
      if(map.exists(_ == (key,value)) == false) {
        val next = q.dequeue()
        //ßprintln(next + " " + get(next))
        map -= (next, get(next))
        map.put(key,value)
      }
    }
    q.enqueue(key)
  }
}