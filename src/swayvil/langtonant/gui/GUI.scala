package swayvil.langtonant.gui

import java.awt.{ Graphics2D, Color, Font }
import java.awt.{ Color => AWTColor }

trait GUI {
  val black = new AWTColor(0, 0, 0)
  val font = new Font("Batang", Font.PLAIN, 10)
  val windowWidth = 350
  val windowHeight = 400
  val white = new AWTColor(255, 255, 255)
  val blockSize = 20.0
  val blockMargin = 2f

  def onPaint(g: Graphics2D)
}