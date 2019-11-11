package cli

import java.io.File

import scala.concurrent.{Future, TimeoutException}
import scala.io.Source
import scala.util.Failure
import expressions.{Parser, Semantic}

object Main {
  def main(args: Array[String]): Unit = {
//    val parser = new scopt.OptionParser[Config]("sigmac") {
//      head("sigmac", "0.1.1")
//
//      arg[File]("<file>")
//        .unbounded()
//        .required()
//        .validate(x =>
//          if (x.exists) success
//          else failure("File does not exist"))
//        .validate(x => {
//          val arr = x.getName.split('.')
//          if (arr.length > 1)
//            if (arr(arr.length - 1) == "sigma") success
//            else failure("Not a valid file extension")
//          else failure("Not a valid filename")
//        })
//        .action((x, c) => c.copy(files = c.files :+ x))
//        .text("Sigma script")
//
//      help("help").text("prints the usage text")
//    }
//
//    parser.parse(args, Config()) match {
//      case Some(config) => {
//        val content = Source.fromFile(config.files(0)).mkString
//        val result = Parser.parse(content).map(_.getPos)
////          .map(Semantic.eval)
//        result.fold(err => println(Console.RED + err + Console.RESET), res => println(res))
//      }
//
//      case None => println("No arguments given")
//    }

    val content =
      """
        |(
        |  [
        |    x = @ this => 0,
        |    move = @ this => \ dx => this.x := this.x + dx
        |  ].move (1 + 2)
        |).x
        |
      """.stripMargin
//      "([m = @ this => \\ x => x]).m [x = @ this => 1]"
    print(s"content:\n'${content}'\n\n")


    val parsed = Parser.parse(content)


    val meta_presentation = parsed.map(_.toString).fold(err => Console.RED + err + Console.RESET, res => res)
    print(s"meta presentation:\n${meta_presentation}\n\n")


    val processed = parsed.map(Semantic.eval).fold(err => Console.RED + err + Console.RESET, res => res)
    print(s"processed:\n${processed}\n\n")

  }
}
