/*--
2017 swayvil
https://github.com/swayvil/langton-ant
++*/

package swayvil.langtonant

import swing._
import event._
import java.awt.{ Graphics2D }
import event.Key._
import swayvil.langtonant.gui.GraphicMatrix
import swayvil.langtonant.gui.GraphicTurn
import main.scala.swayvil.langtonant.Game
import swayvil.langtonant.gui.GUI
import swayvil.langtonant.gui.CompositeGUI

object Application {
  def main(args: Array[String]) = {
    var game: Game = new Game()
    var guiApp = new GUIApplication(game)
    guiApp.main(args)

    game.gui = guiApp.gui
    game.nextTurn()
  }

  class GUIApplication(var game: Game) extends SimpleSwingApplication with GUI {
    var gui: CompositeGUI = new CompositeGUI()

    def onKeyPress(keyCode: Value) = keyCode match {
      case Key.Enter => game.pauseOrResume()
    }

    def paint(g: Graphics2D) {
      top.repaint()
    }

    def repaint() {
      top.repaint()
    }

    def onPaint(g: Graphics2D) {
      top.repaint()
    }

    var graphicMatrix: Panel = new GraphicMatrix(game.m)
    var graphicTurn: Panel = new GraphicTurn(game)
    gui.+=(graphicMatrix)
    gui.+=(graphicTurn)

    def top = new MainFrame {
      title = "Langton\'s ant"
      contents = new BoxPanel(Orientation.Vertical) {
        gui.childGUIs foreach { contents += _ }

        var windowWidth = game.matrixSize * squareSize
        var windowHeight = game.matrixSize * squareSize

        preferredSize = new Dimension(windowWidth, windowHeight)
        focusable = true

        listenTo(keys)
        reactions += {
          case KeyPressed(_, key, _, _) =>
            onKeyPress(key)
        }

        override def paint(g: Graphics2D) {
          g setColor white
          g fillRect (0, 0, windowWidth, windowHeight)
          gui.paint(g)
        }
      }
    }
  }
}