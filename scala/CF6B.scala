import scala.collection.mutable

/**
 * Created by yangchaozhong on 3/10/15.
 */
object CF6B extends App {
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
    val c = nextString.charAt(0)
    val matrix = Array.ofDim[Char](n, m)

    var minX = -1
    var minY = -1
    var maxX = -1
    var maxY = -1

    (0 until n).foreach { i =>
      val s = nextString
      (0 until m).foreach { j =>
        matrix(i)(j) = s.charAt(j)

        if (matrix(i)(j) == c) {
          if (minX == -1 && minY == -1) {
            minX = i
            minY = j
          }

          maxX = i
          maxY = j
        }
      }
    }

    val topLeft = (minX, minY)
    val bottomLeft = (maxX, minY)
    val topRight = (minX, maxY)
    val bottomRight = (maxX, maxY)

    var count = 0

    // top
    if (minX > 0) {
      val set = mutable.HashSet[Char]()
      (minY to maxY).foreach { j =>
        val color = matrix(minX - 1)(j)
        if (color != '.')
          set += color
      }
      count += set.size
    }

    // left
    if (minY > 0) {
      val set = mutable.HashSet[Char]()
      (minX to maxX).foreach { i =>
        val color = matrix(i)(minY - 1)
        if (color != '.')
          set += color
      }

      count += set.size
    }

    // bottom
    if (maxX < n - 1) {
      val set = mutable.HashSet[Char]()
      (minY to maxY).foreach { j =>
        val color = matrix(maxX + 1)(j)
        if (color != '.')
          set += color
      }

      count += set.size
    }

    // right
    if (maxY < m - 1) {
      val set = mutable.HashSet[Char]()
      (minX to maxX).foreach { i =>
        val color = matrix(i)(maxY + 1)
        if (color != '.')
          set += color
      }
      count += set.size
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
