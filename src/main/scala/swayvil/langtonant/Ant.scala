package main.scala.swayvil.langtonant

import swayvil.langtonant.Matrix

class Ant(var m: Matrix) {
  var x: Int = m.size / 2
  var y: Int = m.size / 2
  var direction: Int = 0 // 0: North, 1: East, 2: South, 3: West

  def move(): Boolean = {
    if (m.matrix(x)(y).isWhite) {
      // use Math.floorMod instead of % which can returns negative rest
      direction = Math.floorMod((direction + 1), 4) // turn 90° right
    } else {
      direction = Math.floorMod((direction - 1), 4) // turn 90° left
    }
    m.matrix(x)(y).isWhite = !m.matrix(x)(y).isWhite // flip the color of the square
    m.matrix(x)(y).isAnt = false
    direction match { // move forward one unit
      case 0 => if (y - 1 >= 0) y -= 1 else return false
      case 1 => if (x + 1 < m.size) x += 1 else return false
      case 2 => if (y + 1 < m.size) y += 1 else return false
      case 3 => if (x - 1 >= 0) x -= 1 else return false
    }
    m.matrix(x)(y).isAnt = true
    return true // ant moved
  }
}