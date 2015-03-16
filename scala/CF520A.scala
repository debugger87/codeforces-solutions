import scala.collection.mutable

/**
 * Created by yangchaozhong on 3/16/15.
 */
object CF520A extends App {
  import scala.collection.mutable.HashSet
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
    val line = nextString.toLowerCase

    val set = HashSet[Char]()
    line.foreach { c =>
      set.add(c)
    }

    if (set.size == 26) {
      out.println("YES")
    } else {
      out.println("NO")
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
