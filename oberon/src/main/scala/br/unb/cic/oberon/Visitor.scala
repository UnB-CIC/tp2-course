package br.unb.cic.oberon

trait Visitor {
  type T

  def getValue() : T

  def visit(v : IntValue) : Unit
  def visit(v : BoolValue) : Unit 
  def visit(e : AddExp) : Unit 
  def visit(e : AndExp)  : Unit
  def visit(e : LtExp)  : Unit
}
