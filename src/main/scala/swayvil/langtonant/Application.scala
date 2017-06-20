package swayvil.langtonant

import swing._
import event._
import java.awt.{ Graphics2D }
import event.Key._
import swayvil.langtonant.gui.GraphicMatrix
import swayvil.langtonant.gui.GraphicTurn
import main.scala.swayvil.langtonant.Game
import swayvil.langtonant.gui.GUI

object Application {
  def main(args: Array[String]) = {
    var game: Game = new Game()
    var guiApp = new GUIApplication(game)
    guiApp.main(args)

    game.graphicMatrix = guiApp.graphicMatrix
    game.graphicTurn = guiApp.graphicTurn
    game.nextTurn()
  }

  class GUIApplication(var game: Game) extends SimpleSwingApplication with GUI {
    //var gui: CompositeGUI = new CompositeGUI(game)

    //def onKeyPress(keyCode: Value) = keyCode match {
    //case Key.Enter => game.pauseOrResume()
    //}

    def onPaint(g: Graphics2D) {
      top.repaint()
    }

    var graphicMatrix: Panel = new GraphicMatrix(game)
    var graphicTurn: Panel = new GraphicTurn(game)
    //var graphicAnt: Panel = new GraphicAnt(game)

    def top = new MainFrame {
      title = "Langton\'s ant"
      contents = new BoxPanel(Orientation.Vertical) {
        contents += graphicMatrix
        contents += graphicTurn
        //contents += graphicAnt
        //gui.childGUIs += graphicMatrix
        //gui.childGUIs += graphicTurn
        //gui.childGUIs += graphicAnt

        var windowWidth = game.matrixSize * squareSize
        var windowHeight = game.matrixSize * squareSize + matrixTop

        preferredSize = new Dimension(windowWidth, windowHeight)
        focusable = true

        listenTo(keys)
        //reactions += {
        //case KeyPressed(_, key, _, _) =>
        //onKeyPress(key)
        //repaint
        //}

        override def paint(g: Graphics2D) {
          g setColor white
          g fillRect (0, 0, windowWidth, windowHeight)
          graphicMatrix.paint(g)
          graphicTurn.paint(g)
          //graphicAnt.paint(g)
          //gui.onPaint(g)
        }
      }
    }
  }
}