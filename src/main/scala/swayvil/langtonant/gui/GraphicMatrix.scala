/*--
2017 swayvil
https://github.com/swayvil/langton-ant
++*/

package swayvil.langtonant.gui

import java.awt.{ Graphics2D, BasicStroke }
import java.awt.geom._ // Rectangle2D
import swayvil.langtonant.Matrix
import swayvil.langtonant.Square
import scala.swing.Panel
import java.awt.Color
import java.awt.Dimension

class GraphicMatrix(private var m: Matrix) extends Panel with GUI {
  preferredSize = new Dimension(m.size * squareSize, m.size * squareSize)

  override def paintComponent(g: Graphics2D) {
    m.matrix.foreach { (row: Array[Square]) => row.foreach { (square: Square) => drawSquare(g, square.x, square.y) } }
  }

  override def repaint() {
    super.repaint()
  }

  private def drawSquare(g: Graphics2D, x: Int, y: Int) {
    var rec = new Rectangle2D.Double(squareSize * x, squareSize * y, squareSize, squareSize)
    if (m.matrix(x)(y).isWhite)
      g.setColor(white)
    else
      g.setColor(black)
    if (m.matrix(x)(y).isAnt)
      g.setColor(red)
    g.fill(new Rectangle2D.Double(squareSize * x, squareSize * y, squareSize, squareSize))
    g.setColor(black)
    g.draw(new Rectangle2D.Double(squareSize * x, squareSize * y, squareSize, squareSize))
  }
}