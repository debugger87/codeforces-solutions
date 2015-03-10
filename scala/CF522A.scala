/**
 * Created by yangchaozhong on 3/10/15.
 */
object CF522A extends App {
  import scala.collection.mutable.{HashMap, HashSet}
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

    val graph = HashMap[String, HashSet[String]]()
    (1 to n).foreach { i =>
      val toName = nextString.toLowerCase
      val edge = nextString
      val fromName = nextString.toLowerCase
      if (graph.contains(fromName)) {
        graph(fromName) += toName
      } else {
        graph += (fromName -> HashSet(toName))
      }
    }

    def dfs(node: String): Int = {
      if (!graph.contains(node)) 1 else graph(node).map(dfs(_)).max + 1
    }

    out.println(dfs("Polycarp".toLowerCase))
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
