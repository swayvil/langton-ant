/*--
2017 swayvil
https://github.com/swayvil/langton-ant
++*/

package swayvil.langtonant.gui

import java.awt.{ Graphics2D, BasicStroke }
import java.awt.geom._ // Rectangle2D
import swayvil.langtonant.Matrix
import swayvil.langtonant.Square
import main.scala.swayvil.langtonant.Game
import scala.swing.Panel
import java.awt.Color
import java.awt.Dimension

class GraphicMatrix(var game: Game) extends Panel with GUI {
  preferredSize = new Dimension(game.matrixSize * squareSize, game.matrixSize * squareSize)

  override def paintComponent(g: Graphics2D) {
    game.m.matrix.foreach { (row: Array[Square]) => row.foreach { (square: Square) => drawSquare(g, square.x, square.y) } }
  }

  override def repaint() {
    super.repaint()
  }

  def drawSquare(g: Graphics2D, x: Int, y: Int) {
    var rec = new Rectangle2D.Double(squareSize * x, squareSize * y, squareSize, squareSize)
    if (game.m.matrix(x)(y).isWhite)
      g.setColor(white)
    else
      g.setColor(black)
    if (game.m.matrix(x)(y).isAnt)
      g.setColor(red)
    g.fill(new Rectangle2D.Double(squareSize * x, squareSize * y, squareSize, squareSize))
    g.setColor(black)
    g.draw(new Rectangle2D.Double(squareSize * x, squareSize * y, squareSize, squareSize))
  }
}