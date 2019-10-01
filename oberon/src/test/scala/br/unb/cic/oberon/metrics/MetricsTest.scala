package br.unb.cic.oberon

import org.scalatest.FunSuite

import br.unb.cic.oberon.metrics._

class MetricsTest extends FunSuite {

  test("Metrics of an int value is allways 1") {
    val int10 = new IntValue(10)

    val v = new Metrics()

    int10.accept(v) 

    assert(1 == v.getValue())
  }

  test("Metrics of an Add(VI(5), Add(VI(3), V4(4))) is 5") {
    val int5 = new IntValue(5)
    val int3 = new IntValue(3)
    val int4 = new IntValue(4)

    val s1 = new AddExp(int3, int4)
    val s2 = new AddExp(int5, s1)

    val v = new Metrics()

    s2.accept(v) 

    assert(5 == v.getValue())
  }
}
