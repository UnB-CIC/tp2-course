package br.unb.cic.oberon.pp

import br.unb.cic.oberon._

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

class PrettyPrinterTest extends FunSuite with BeforeAndAfter {

  var pp : Visitor = _

  before {
    pp = new PrettyPrinter()
  }

  test("pretty printing IntValue(10) should lead to \"10\"") {
    val int10 = new IntValue(10)
    int10.accept(pp)
    assert("10" == pp.getValue())
  }

  test("pretty printing Add(10, 20) should lead to \"(10 + 20)\"") {
    val int10 = new IntValue(10)
    val int20 = new IntValue(20)

    val add = new AddExp(int10, int20)

    add.accept(pp)
    assert("(10 + 20)" == pp.getValue())
  }

  test("pretty printing Add(10, Add(10, 20)) should lead to \"(10 + (10 + 20))\"") {
    val int10 = new IntValue(10)
    val int20 = new IntValue(20)

    val add1 = new AddExp(int10, int20)
    val add2 = new AddExp(int10, add1) 

    add2.accept(pp)
    assert("(10 + (10 + 20))" == pp.getValue())
  }

  test("pretty printing Sub(10, 20) should lead to \"(10 - 20)\"") {
    val int10 = new IntValue(10)
    val int20 = new IntValue(20)

    val sub = new SubExp(int10, int20)

    sub.accept(pp)
    assert("(10 - 20)" == pp.getValue())
  }

  test("pretty printing Sub(10, Sub(10, 20)) should lead to \"(10 - (10 - 20))\"") {
    val int10 = new IntValue(10)
    val int20 = new IntValue(20)

    val sub1 = new SubExp(int10, int20)
    val sub2 = new SubExp(int10, sub1) 

    sub2.accept(pp)
    assert("(10 - (10 - 20))" == pp.getValue())
  }


}
