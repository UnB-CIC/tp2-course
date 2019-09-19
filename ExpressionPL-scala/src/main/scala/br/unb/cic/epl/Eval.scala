package br.unb.cic.epl


/**
  * Componente que modulariza a feature eval. 
  */ 
package object Eval {

  trait Expression extends Core.Expression {
    def eval(): Integer 
  }

  trait Literal extends Core.Literal with Expression {
    override def eval(): Integer = value
  }

}
