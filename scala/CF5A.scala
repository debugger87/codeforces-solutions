
/**
 * Created by yangchaozhong on 3/10/15.
 */
object CF5A extends App {
  import scala.collection.mutable
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

    val names = new mutable.HashSet[String]()

    var count = 0
    while (in.hasNext) {
      val s = nextLine
      if (s.startsWith("+")) {
        names += s.substring(1)
      } else if (s.startsWith("-")) {
        names -= s.substring(1)
      } else {
        val arr = s.split(":")
        if (arr.length > 1)
          count += s.split(":")(1).length * names.size
      }
    }

    out.println(count)
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
