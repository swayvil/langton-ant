package main.scala.swayvil.langtonant

import swayvil.langtonant.Matrix
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.Success
import scala.util.Failure
import scala.concurrent.duration.Duration
import swayvil.langtonant.Application.GUIApplication
import scala.swing.MainFrame
import swayvil.langtonant.gui.GraphicMatrix
import scala.swing.Panel

class Game() {
  var turn: Int = 0
  var speed: Int = 1
  val turnTime: Long = 2 // ms
  //var gui: CompositeGUI = null
  var graphicMatrix: Panel = null
  var graphicTurn: Panel = null
  var isRunning: Boolean = true
  val matrixSize: Int = 80
  var m: Matrix = new Matrix(matrixSize)
  var ant: Ant = new Ant(m)

  def nextTurn() {
    turn += 1
    if (!ant.move()) {
      isRunning = false
    }
    else {
      val f: Future[Int] = Future {
        Thread.sleep(turnTime)
        0
      }

      f onComplete {
        case Success(v) => {
          if (isRunning) {
            nextTurn()
            graphicMatrix.repaint()
            graphicTurn.repaint()
          }
        }
        case Failure(v) => { println("FAILURE") }
      }
    }
  }

  def pauseOrResume() {
    if (speed > 0)
      speed = 0 // pause
    else
      speed = 1 // resume
  }
}