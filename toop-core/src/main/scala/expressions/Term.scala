package expressions

import scala.util.parsing.input.{NoPosition, Positional}

/**
 * Created by Александр on 02.03.2015.
 */
trait Term extends Positional {
  val FV : Set[String]
  def productPrefix: String = s"${this.getClass.getSimpleName}$posOrEmpty"

  def posOrEmpty: String = pos match {
    case NoPosition => ""
    case _ => s"[$pos]"
  }
}
