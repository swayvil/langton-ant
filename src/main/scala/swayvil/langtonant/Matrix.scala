/*--
2017 swayvil
https://github.com/swayvil/langton-ant
++*/

package swayvil.langtonant

class Square(var x: Int, var y: Int) {
  var isWhite: Boolean = true
  var isAnt: Boolean = false
}

class Matrix(var size: Int) {
  var matrix = Array.tabulate[Square](size, size) { (i, j) => new Square(i, j) }

  // To debug
  def printMatrix {
    matrix.foreach { (row: Array[Square]) => row.foreach { (square: Square) => print(square.x + "-" + square.y + " ") }; println }
  }
}