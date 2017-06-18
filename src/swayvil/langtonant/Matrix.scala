class Square(var x: Integer, var y: Integer) {
  var isWhite: Boolean = true
}

class Matrix {
  private val size: Integer = 10
  private var matrix = Array.tabulate[Square](size, size) { (i, j) => new Square(i, j) }

  def printMatrix {
    matrix.foreach { (row: Array[Square]) => row.foreach { (square: Square) => print(square.x + "-" + square.y + " ") } ; println }
  }
}