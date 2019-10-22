package br.unb.cic.oberon

trait Statement {
  def execute() : Unit
}

case class Void() extends Statement {
  def execute() : Unit = { } 
}




