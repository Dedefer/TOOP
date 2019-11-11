package expressions

/**
 * Created by Александр on 02.03.2015.
 */
case class ObjectFormation(methods:Map[String, Term]) extends Term {
  override def productPrefix = s"${this.getClass.getSimpleName}$posOrEmpty"
  
  lazy override val FV = methods.foldLeft(Set[String]())((a,b) => a union b._2.FV)
}

