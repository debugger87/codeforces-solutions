/**
 * Created by yangchaozhong on 3/11/15.
 */
object CF522B extends App {
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
    val n = nextInt
    val w = Array.ofDim[Int](n)
    val h = Array.ofDim[Int](n)

    var sumW = 0
    var maxH = 0
    (0 until n).foreach { i =>
      w(i) = nextInt
      h(i) = nextInt
      sumW += w(i)
      if (h(i) > maxH)
        maxH = h(i)
    }

    var secondH = 0
    var maxTimes = 0
    h.foreach { x =>
      if (x > secondH && x != maxH) {
        secondH = x
      }

      if (x == maxH)
        maxTimes += 1
    }

    if (maxTimes > 1)
      secondH = maxH

    val res = (0 until n).map { i =>
      val width = sumW - w(i)
      if (h(i) == maxH) {
        width * secondH
      } else {
        width * maxH
      }
    }.mkString(" ")

    out.println(res)
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
