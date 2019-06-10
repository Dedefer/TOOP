package expressions

/**
 * Created by Александр on 02.03.2015.
 */
case class MethodUpdate(obj:Term, label:String, method:Term) extends Term
{
  override def toString = "(" + (method match {
    case _:Sigma => obj+"."+label+" <= "+method
    case _ => obj+"."+label+" <= @ this => "+method
  }) + ")"

  lazy override val FV = obj.FV union method.FV
}
