

object Solution {
  /**
   * Given a list of integers, group them around the pivot; print the result on a single line, separating the numbers
   * using spaces.
   *
   * The pivot is the first element of the array.  First print all number less than the pivot, then all numbers equal
   * to the pivot, and then the rest.
   */
  def solve(ar : Array[Int]) = {
    val p = if (ar.length > 0) ar(0) else 0 // Choose a valid pivot if array is empty
    
    def filterToSpaceSeparatedString(ar : Array[Int], pred : Int => Boolean) =
        ar.filter(pred).map(_ + " ").fold("")(_ + _)
    

    println(filterToSpaceSeparatedString(ar, _ < p) +
        filterToSpaceSeparatedString(ar, _ == p) +
        filterToSpaceSeparatedString(ar, _ > p))
  }
  
  def main(args: Array[String]) = {
    if (true) { // set this to true before submitting solution
      val linesIt = io.Source.stdin.getLines()
      val n = linesIt.next().toInt
      val ar = linesIt.next().split(" ").map(_.toInt);
      solve(ar)
    }
    else {
      // Run internal tests and eyeball the output for correctness.
      solve(Array[Int]())
      solve(Array[Int](42))
      solve(Array(-1, 0, 1, 2))
      solve(Array(0, 0, 1, 2))
      solve(Array(1, 0, 1, 2))
      solve(Array(2, 0, 1, 2))
      solve(Array(3, 0, 1, 2))
    }
  }
}
