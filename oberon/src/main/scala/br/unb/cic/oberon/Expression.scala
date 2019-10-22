package br.unb.cic.oberon

trait Type

case class TInt() extends Type
case class TBool() extends Type
case class TError() extends Type

abstract class Expression {
  def computeType() : Type 
  def typeCheck() : Boolean
  def eval(): Value
  def accept(v : Visitor) : Unit 
}

trait Value extends Expression {
  type T
  val value: T

  override def typeCheck(): Boolean = true

  override def eval(): Value = this
}

case class IntValue(v: Integer) extends Value {
  type T = Integer
  val value = v

  override def computeType() : Type = TInt()

  def accept(v : Visitor) {
    v.visit(this) 
  }
}

case class BoolValue(v: Boolean) extends Value {
  type T = Boolean
  val value = v

  override def computeType() : Type = TBool()

  def accept(v : Visitor) {
    v.visit(this) 
  }

}

case class AddExp(val lhs: Expression, val rhs: Expression) extends Expression {
  override def typeCheck() : Boolean = lhs.computeType() == TInt() && rhs.computeType() == TInt()

  override def computeType() : Type = if(lhs.computeType == TInt() && rhs.computeType() == TInt()) TInt() else TError()

  override def eval(): Value = {
    val l = lhs.eval().asInstanceOf[IntValue]
    val r = rhs.eval().asInstanceOf[IntValue]

    return new IntValue(l.value + r.value)
  }

  def accept(v : Visitor) {
    v.visit(this)
  }
}

case class AndExp(val lhs: Expression, val rhs: Expression) extends Expression {
  override def typeCheck() : Boolean = lhs.computeType() == TBool() && rhs.computeType() == TBool()

  override def computeType() : Type = if(lhs.computeType == TBool() && rhs.computeType() == TBool()) TBool() else TError()

  override def eval(): Value = {
    val l = lhs.eval().asInstanceOf[BoolValue]
    val r = rhs.eval().asInstanceOf[BoolValue]

    return new BoolValue(l.value && r.value)
  }

  def accept(v : Visitor) {
    v.visit(this)
  } 
}

case class LtExp(val lhs: Expression, val rhs: Expression) extends Expression {
  override def typeCheck() : Boolean = lhs.computeType() == rhs.computeType()

  override def computeType() : Type = if(typeCheck()) TBool() else TError()

  override def eval(): Value = {
    val l = lhs.eval()
    val r = rhs.eval()

    if(l.computeType() == TInt() && r.computeType() == TInt()) {
      return new BoolValue(l.asInstanceOf[IntValue].value < r.asInstanceOf[IntValue].value)
    }
    return new BoolValue(l.asInstanceOf[IntValue].value < r.asInstanceOf[IntValue].value)
  }

  def accept(v : Visitor) {
    v.visit(this)
  }
}

