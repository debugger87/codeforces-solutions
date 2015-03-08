
/**
 * Created by yangchaozhong on 3/8/15.
 */
object CF1B extends App {
  import java.io.{PrintWriter}
  import java.util.{Scanner}


  val in = new Scanner(System.in)
  val out = new PrintWriter(System.out)

  def nextInt = in.nextInt
  def nextLong = in.nextLong
  def nextDouble = in.nextDouble
  def nextString = in.next

  def isAType(s: String) = {
    s.matches("R\\d+C\\d+")
  }

  def transform(s: String) = {
    if (s.matches("[A-Z]+")) {
      var res = 0
      val rs = s.reverse
      (0 to (rs.length - 1)).foreach { i =>
        res += (rs.charAt(i) - 'A' + 1) * Math.pow(26, i).toInt
      }
      res
    } else {
      var res = ""

      var n = s.toInt
      while (n > 0) {
        var m = n % 26
        if (m == 0) m = 26
        res += (m + 64).toChar
        n = (n - m) / 26
      }

      res.reverse
    }
  }

  def solve = {
    val n = nextInt
    (1 to n).foreach { x =>
      var s = nextString
      if (isAType(s)) {
        s = s.replace("R", "")
        s = s.replace("C", " ")
        val arr = s.split(" ")
        val row = arr(0)
        val column = arr(1)

        out.println(s"${transform(column)}$row")
      } else {
        val row = s.filter(c => c >= '0' && c <= '9').mkString("")
        val column = s.filter(c => c >= 'A' && c <= 'Z').mkString("")
        out.println(s"R${row}C${transform(column)}")
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
