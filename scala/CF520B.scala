/**
 * Created by yangchaozhong on 3/16/15.
 */
object CF520B extends App {
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
    val m = nextInt

    if (n >= m) {
      out.println(n - m)
    } else {

      def dfs(x: Int): Int = {
        if (x == n) 0
        else if (x < n) {
          n - x
        } else {
          if (x % 2 == 0) {
            dfs(x / 2) + 1
          } else {
            dfs(x + 1) + 1
          }
        }
      }

      out.println(dfs(m))
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
