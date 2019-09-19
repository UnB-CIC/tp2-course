package br.unb.cic.epl 

/** 
  * A definicao de um componente com os elementos 
  * comuns a todos os produtos da linha de produtos. 
  */ 
package object Core {

  trait Expression {
    def print(): String
  }

  class Literal(val value: Integer) extends Expression {
    override def print() : String = value.toString
  }

}
