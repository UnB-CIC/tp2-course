package br.unb.cic.oberon.pp

import br.unb.cic.oberon._

class PrettyPrinter() extends Visitor {
  type T = String

  var res = "" 

  def getValue() = res

  def visit(v : IntValue) {
    res = res + v.value.toString
  }

  def visit(v : BoolValue) {
    res = res + v.value.toString
  }

  def visit(e : AddExp) {
    res = res + "("
    e.lhs.accept(this)
    res = res + " + "
    e.rhs.accept(this)
    res = res +  ")"
  }

  def visit(e : AndExp) {
    res = res + "("
    e.lhs.accept(this)
    res = res + " && "
    e.rhs.accept(this)
    res = res +  ")"
  }

  def visit(e : LtExp) {
    res = res + "("
    e.lhs.accept(this)
    res = res + " < "
    e.rhs.accept(this)
    res = res +  ")"
  }

  def visit(e : GtExp) {
    res = res + "("
    e.lhs.accept(this)
    res = res + " > "
    e.rhs.accept(this)
    res = res +  ")"
  }

  def visit(e : VarRef) {
    res = res + e.name
  }
}
