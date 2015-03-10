
/**
 * Created by yangchaozhong on 3/10/15.
 */
object CF6A extends App {
  import java.util.{Scanner}
  import java.io.{PrintWriter}

  val in = new Scanner(System.in)
  val out = new PrintWriter(System.out)

  def nextInt = in.nextInt
  def nextLong = in.nextLong
  def nextDouble = in.nextDouble
  def nextString = in.next
  def nextLine = in.nextLine

  def solve = {
    val lines = Array.ofDim[Int](4)

    (0 until 4).foreach { i =>
      lines(i) = nextInt
    }

    val combinations = lines.combinations(3)
    var c1 = 0
    var c2 = 0
    combinations.foreach { arr =>
      val sortedArr = arr.sortWith(_ > _)
      if (sortedArr(1) + sortedArr(2) > sortedArr(0)) {
        c1 += 1
      } else if (sortedArr(1) + sortedArr(2) == sortedArr(0)) {
        c2 += 1
      }
    }

    if (c1 > 0) {
      out.println("TRIANGLE")
    } else if (c2 > 0) {
      out.println("SEGMENT")
    } else {
      out.println("IMPOSSIBLE")
    }
  }

  try {
    solve
  } catch {
    case _: Exception => sys.exit(9999)
  } finally {
    out.flush
    out.close
  }
}
