/**
 * Created by yangchaozhong on 3/9/15.
 */
object CF4B extends App {
  import java.io.{PrintWriter}
  import java.util.{Scanner}

  val in = new Scanner(System.in)
  val out = new PrintWriter(System.out)

  def nextInt = in.nextInt
  def nextLong = in.nextLong
  def nextDouble = in.nextDouble
  def nextString = in.next

  def solve = {
    val d = nextInt
    var s = nextInt
    val plan = Array.ofDim[Int](d)
    val min = Array.ofDim[Int](d)
    val max = Array.ofDim[Int](d)
    (1 to d).foreach { i =>
      min(i - 1) = nextInt
      max(i - 1) = nextInt

      plan(i - 1) = min(i - 1)
      s -= min(i - 1)
    }

    if (s < 0) {
      out.println("NO")
    } else if (s == 0){
      out.println("YES")
      out.println(plan.mkString(" "))
    } else {
      var i = 0
      while (i < d && s > 0) {
        val delta = Math.min(max(i) - min(i), s)
        plan(i) += delta
        s -= delta
        i += 1
      }

      if (i >= d && s > 0) {
        out.println("NO")
      } else {
        out.println("YES")
        out.println(plan.mkString(" "))
      }
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
