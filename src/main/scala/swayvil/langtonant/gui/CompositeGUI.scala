/*--
2017 swayvil
https://github.com/swayvil/langton-ant
++*/

package swayvil.langtonant.gui

import java.awt.{ Graphics2D }
import scala.collection.mutable.ListBuffer
import main.scala.swayvil.langtonant.Game
import scala.swing.Panel

class CompositeGUI() extends GUI {
  var childGUIs: ListBuffer[Panel] = new  ListBuffer[Panel]()
  
  def +=(child: Panel) = { childGUIs += child }
  def -=(child: Panel) = { childGUIs -= child }
  
  def paint(g: Graphics2D) = childGUIs foreach { _.paint(g) }
  def repaint() = childGUIs foreach { _.repaint() }
} 