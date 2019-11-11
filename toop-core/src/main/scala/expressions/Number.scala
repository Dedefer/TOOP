package expressions

import scala.util.parsing.input.NoPosition

/**
 * Created by Александр on 05.03.2015.
 */
case class Number(n:Int) extends Term {
  override def productPrefix = s"${this.getClass.getSimpleName}$posOrEmpty"
  
  lazy override val FV = Set[String]()
}
