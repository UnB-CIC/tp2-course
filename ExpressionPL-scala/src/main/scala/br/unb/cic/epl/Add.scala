package br.unb.cic.epl


package object Add {

  trait AbstractAdd extends Core.Expression {
    type T <: Core.Expression

    // lhs and rhs sao do tipo T, que tem como
    // base o tipo Core.Expression
    var lhs: T = _
    var rhs: T = _

    override def print(): String = "(" + lhs.print() + "+" + rhs.print() + ")" 
  }

  class Add(l: Core.Expression, r: Core.Expression) extends AbstractAdd {
    type T = Core.Expression

    lhs = l
    rhs = r
  }

}
