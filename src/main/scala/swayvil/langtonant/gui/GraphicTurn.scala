/*--
2017 swayvil
https://github.com/swayvil/langton-ant
++*/

package swayvil.langtonant.gui

import java.awt.{ Graphics2D }
import main.scala.swayvil.langtonant.Game
import scala.swing.Panel
import java.awt.Dimension

class GraphicTurn(var game: Game) extends Panel with GUI {
  preferredSize = new Dimension(10, 10)

  override def paintComponent(g: Graphics2D) {
    // draw some text
    g.setColor(black)
    g.setFont(font)
    g.drawString(game.turn.toString(), 10, 10)
  }

  override def repaint() {
    super.repaint()
  }
}