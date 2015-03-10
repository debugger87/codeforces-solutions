/**
 * Created by yangchaozhong on 3/10/15.
 */
object CF5B extends App {
  import scala.collection.mutable.ArrayBuffer
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
    val lines = ArrayBuffer[String]()
    var maxLength = 0
    while (in.hasNextLine) {
      val s = nextLine
      lines += s
      maxLength = if (s.length > maxLength) s.length else maxLength
    }

    val startAndEnd = (1 to (maxLength + 2)).map(x => "*").mkString("")
    out.println(startAndEnd)

    var isLeft = true
    lines.foreach { line =>
      if (line.length > 0) {
        var leftLen = (maxLength - line.length) / 2
        var rightLen = maxLength - line.length - leftLen

        if (leftLen != rightLen) {
          if (!isLeft) {
            val temp = leftLen
            leftLen = rightLen
            rightLen = temp
          }

          isLeft = !isLeft
        }
        val left = (1 to leftLen).map(x => " ").mkString("")
        val right = (1 to rightLen).map(x => " ").mkString("")
        out.println(s"*${left}${line}${right}*")
      } else {
        out.println(s"*${(1 to maxLength).map(x => " ").mkString("")}*")
      }
    }

    out.println(startAndEnd)
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
