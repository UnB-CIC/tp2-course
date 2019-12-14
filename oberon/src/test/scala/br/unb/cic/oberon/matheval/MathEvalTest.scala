package br.unb.cic.oberon

import org.scalatest.FunSuite

import br.unb.cic.oberon.matheval._

class MathEvalTest extends FunSuite {

  test("Evaluation of an Int10 is 10") {
    val int10 = new IntValue(10)

    val v = new MathEval()

    int10.accept(v) 

    assert(10 == v.getValue())
  }

  test("Evaluation of an Add(Int(5), Int(6)) is 11") {
    val int5 = new IntValue(5)
    val int6 = new IntValue(6)

    val add = new AddExp(int5, int6)
    
    val v = new MathEval()

    add.accept(v) 

    assert(11 == v.getValue())
  }
}
