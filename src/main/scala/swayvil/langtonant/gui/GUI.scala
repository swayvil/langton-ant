/*--
2017 swayvil
https://github.com/swayvil/langton-ant
++*/

package swayvil.langtonant.gui

import main.scala.swayvil.langtonant.Game
import scala.swing.Panel
import java.awt.Color
import java.awt.Graphics2D

trait GUI {
  val black = new Color(0, 0, 0)
  val red = new Color(255, 0, 0)
  val white = new Color(255, 255, 255)
  val squareSize = 10
  val blockMargin = 1f

  def paint(g: Graphics2D)
  def repaint()
}