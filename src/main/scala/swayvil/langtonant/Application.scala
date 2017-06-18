package swayvil.langtonant

import swing._
import event._
import java.awt.{ Graphics2D }
import event.Key._
import swayvil.langtonant.gui.CompositeGUI
import swayvil.langtonant.gui.GUI
import swayvil.langtonant.gui.GraphicMatrix
import swayvil.langtonant.gui.GraphicTurn

object Application {
  def main(args: Array[String]) = {
    GUIApplication.main(args)

    //val m = new Matrix
    //m.printMatrix
  }

  object GUIApplication extends SimpleSwingApplication {
    var gui: CompositeGUI = new CompositeGUI()

    def onKeyPress(keyCode: Value) = keyCode match {
      case Key.Enter => println("Enter is down")
    }

    def onPaint(g: Graphics2D) {
      gui.onPaint(g)
      // draw a filled and an unfilled Rectangle
      //g.setColor(white)
      //g.fill(new Rectangle2D.Double(0.0, 0.0, blockSize, blockSize))
    }

    def top = new MainFrame {
      title = "Langton\'s ant"
      contents = mainPanel
    }

    def mainPanel = new Panel {
      preferredSize = new Dimension(gui.windowWidth, gui.windowHeight)
      focusable = true
      
      var graphicMatrix: GUI = new GraphicMatrix()
      var graphicTurn: GUI = new GraphicTurn()
      gui.childGUIs += graphicMatrix
      gui.childGUIs += graphicTurn
      
      listenTo(keys)
      reactions += {
        case KeyPressed(_, key, _, _) =>
          onKeyPress(key)
          repaint
      }

      override def paint(g: Graphics2D) {
        g setColor gui.white
        g fillRect (0, 0, size.width, size.height)
        onPaint(g)
      }
    }
  }
}