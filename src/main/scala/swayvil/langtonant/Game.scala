/*--
2017 swayvil
https://github.com/swayvil/langton-ant
++*/

package main.scala.swayvil.langtonant

import swayvil.langtonant.Matrix
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.Success
import scala.util.Failure
import scala.concurrent.duration.Duration
import swayvil.langtonant.gui.CompositeGUI

class Game() {
  var turn: Int = 0
  val turnTime: Long = 2 // ms
  var gui: CompositeGUI = null
  var isRunning: Boolean = true
  val matrixSize: Int = 80
  var m: Matrix = new Matrix(matrixSize)
  var ant: Ant = new Ant(m)

  def nextTurn() {
    if (!isRunning)
      return

    turn += 1
    if (!ant.move()) {
      isRunning = false
    } else {
      val f: Future[Int] = Future {
        Thread.sleep(turnTime)
        0
      }

      f onComplete {
        case Success(v) => {
          if (isRunning) {
            nextTurn()
            gui.repaint()
          }
        }
        case Failure(v) => { println("FAILURE") }
      }
    }
  }

  def pauseOrResume() {
    isRunning = !isRunning
    if (isRunning)
      nextTurn()
  }
}