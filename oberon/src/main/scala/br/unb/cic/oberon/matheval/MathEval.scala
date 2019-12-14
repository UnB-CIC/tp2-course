package br.unb.cic.oberon.matheval

import br.unb.cic.oberon._

class MathEval() extends Visitor {
  type T = Integer

  var res = 0

  def getValue() = res

  def visit(v : IntValue) {
    res = res + v.value
  }

  def visit(v : BoolValue) {

    if(v.value)
    res = 1 //set 1 as True
	 else
	 res = 0 //set 0 as False
  }

  def visit(e : AddExp) {
    res = 
    e.lhs.accept(this)
    e.rhs.accept(this) 
  }

 def visit(e : AndExp) {
    e.lhs.accept(this)
    e.rhs.accept(this) 
    res = res + e.lhs.value + e.rhs.value
  }



}
