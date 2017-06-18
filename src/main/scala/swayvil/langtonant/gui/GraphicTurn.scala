package swayvil.langtonant.gui

import java.awt.{ Graphics2D }

class GraphicTurn extends GUI {
  def onPaint(g: Graphics2D) {
    // draw some text
    g.setColor(black)
    g.setFont(font)
    g.drawString("Hello World!", windowWidth - 100, 20)
  }
}