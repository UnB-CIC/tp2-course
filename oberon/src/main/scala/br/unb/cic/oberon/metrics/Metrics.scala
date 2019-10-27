package br.unb.cic.oberon.metrics

import br.unb.cic.oberon._

class Metrics() extends Visitor {
  type T = Integer

  var res = 0 

  def getValue() = res

  def visit(v : IntValue) {
    res = res + 1
  }

  def visit(v : BoolValue) {
    res = res + 1
  }

  def visit(e : AddExp) {
    res = res + 1
    e.lhs.accept(this)
    e.rhs.accept(this) 
  }

  def visit(e : AndExp) {
    res = res + 1
    e.lhs.accept(this)
    e.rhs.accept(this)
  }

  def visit(e : LtExp) {
    res = res + 1
    e.lhs.accept(this)
    e.rhs.accept(this)
  }

  def visit(e : GtExp) {
    res = res + 1
    e.lhs.accept(this)
    e.rhs.accept(this)
  }

  def visit(e : VarRef) {
    res = res + 1
  }
}
