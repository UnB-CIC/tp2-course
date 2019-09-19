package br.unb.cic.oberon

abstract class Expression {
  def eval(): Value	 
}

trait Value extends Expression {
  type T
  val value: T
  
  override def eval(): Value = this
}

case class IntValue(v: Integer) extends Value {
   type T = Integer
   val value = v
}

case class BoolValue(v: Boolean) extends Value {
   type T = Boolean
   val value = v
}

case class AddExp(val lhs: Expression, val rhs: Expression) extends Expression {
  override def eval(): Value = {
    val l = lhs.eval().asInstanceOf[IntValue]
    val r = rhs.eval().asInstanceOf[IntValue]

    return new IntValue(l.value + r.value)
  }
}

// case class SubExp(val lhs: Expression, val rhs: Expression) extends Expression
// case class MulExp(val lhs: Expression, val rhs: Expression) extends Expression
// case class DivExp(val lhs: Expression, val rhs: Expression) extends Expression

// case class AndExp(val lhs: Expression, val rhs: Expression) extends Expression
// case class OrExp (val lhs: Expression, val rhs: Expression) extends Expression
// case class NotExp(val exp: Expression) extends Expression 

// case class EqExp (val lhs: Expression, val rhs: Expression) extends Expression
// case class NeqExp(val lhs: Expression, val rhs: Expression) extends Expression 

