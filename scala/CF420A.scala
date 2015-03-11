
/**
 * Created by yangchaozhong on 3/12/15.
 */
object CF420A extends App {
  import scala.collection.immutable.HashSet
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
    val name = nextString
    val chars = HashSet('A', 'H', 'I', 'M', 'O', 'T', 'U', 'V', 'W', 'X', 'Y')
    val len = name.length
    val half = len / 2
    val sum = (0 to (half - 1)).map(i => Math.abs(name(i) - name(len - 1 - i))).sum
    val count = name.count(!chars.contains(_))
    if (sum == 0 && count == 0)
      out.println("YES")
    else
      out.println("NO")
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
