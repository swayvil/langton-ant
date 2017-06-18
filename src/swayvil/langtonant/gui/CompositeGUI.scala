package swayvil.langtonant.gui

import java.awt.{ Graphics2D }
import scala.collection.mutable.ListBuffer

class CompositeGUI extends GUI {
  var childGUIs: ListBuffer[GUI] = new  ListBuffer[GUI]()
  
  def +=(child: GUI) = { childGUIs += child }
  def -=(child: GUI) = { childGUIs -= child }
  
  def onPaint(g: Graphics2D) = childGUIs foreach { _.onPaint(g) }
} 