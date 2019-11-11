import expressions.Parser
import scala.util.parsing.input.{NoPosition => Pos}

def parse(str: String) =
  Parser.parse(str).get

val str2 =
  """
    |(
    |  [
    |    x = @ this => 0,
    |    move = @ this => \ dx => this.x := this.x + dx
    |  ].move 5
    |).x
    |
  """.stripMargin


val term = parse(str2)

//trait A {
//  def m = "aaaaa"
//}

//case class B() extends A
//
//B().m
term.getPos

//println(a)