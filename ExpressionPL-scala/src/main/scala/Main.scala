
import br.unb.cic.epl._


trait HelloWorld {
  def sayHello(): Unit = { println("Hello TP2") }
}

object Main extends App {
  val lit100 = new Core.Literal(100) with Eval.Literal with HelloWorld
  val lit200 = new Core.Literal(200) with Eval.Literal
  val add    = new AddEval.Add(lit100, lit200)

  println(lit100.print())
  println(lit200.print())

  println(lit100.eval() + lit200.eval())

  println(lit100.sayHello())

  println(add.print())
  println(add.eval())
}
