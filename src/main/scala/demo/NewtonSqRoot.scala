package demo

class NewtonSqRoot {
  def abs(x: Double): Double = if(x >= 0) x else -x

  def calcRoot(guess: Double, input: Double): Double = {
    if(isGoodGuess(guess, input)) guess
    else calcRoot(improve(guess, input),input)
  }

  def isGoodGuess(guess: Double, input: Double): Boolean = {
    val sq = guess * guess
    val eps = 0.0000001
    if(abs(sq - input) < eps) true
    else false
  }

  def improve(guess: Double, input: Double): Double = {
    val quotient = input/guess
    val mean = (quotient + guess)/2.0
    return mean
  }
}
