package swayvil.langtonant.gui

import java.awt.{ Graphics2D, BasicStroke }
import java.awt.geom._ // Rectangle2D

class GraphicMatrix extends GUI {
  def onPaint(g: Graphics2D) {
    g.setColor(black)
    g.setStroke(new BasicStroke(blockMargin))
    g.draw(new Rectangle2D.Double(0.0, 0.0, blockSize, blockSize))
  }
}