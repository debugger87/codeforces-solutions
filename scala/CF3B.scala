import scala.util.control.Breaks._

/**
 * Created by yangchaozhong on 3/8/15.
 */
object CF3B extends App {
  import java.io.{PrintWriter}
  import java.util.{Scanner}

  val in = new Scanner(System.in)
  val out = new PrintWriter(System.out)

  def nextInt = in.nextInt
  def nextLong = in.nextLong
  def nextDouble = in.nextDouble
  def nextString = in.next

  def solve = {
    val n = nextInt
    val v = nextInt

    val ol = (1 to n).map { i =>
      (i, nextInt, nextInt)
    }.sortWith { (x, y) =>
      if (x._2 != y._2)
        x._2 < y._2
      else if (x._2 == 1)
        x._3 < y._3
      else
        x._3 > y._3
    }.toList

    val l = (0, 0, 0) :: ol

    var MAX = 0
    var w1 = 0
    var v1 = 0
    var MAXi = 1
    var j = 1
    (1 to n).foreach { i =>
      w1 += l(i)._2
      v1 += l(i)._3

      while (w1 > v) {
        w1 -= l(j)._2
        v1 -= l(j)._3
        j += 1
      }

      if (v1 > MAX) {
        MAX = v1
        MAXi = j
      }
    }
    out.println(MAX)

    w1 = 0
    v1 = 0

    try {
      (MAXi to n).foreach { j =>
        w1 += l(j)._2
        v1 += l(j)._3
        if (w1 > v) break
        if (j == MAXi)
          out.print(l(j)._1)
        else
          out.print(" " + l(j)._1)
      }
    } catch {
      case _ =>
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