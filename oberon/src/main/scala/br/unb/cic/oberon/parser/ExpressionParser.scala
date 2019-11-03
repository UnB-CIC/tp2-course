package br.unb.cic.oberon.parser

import br.unb.cic.oberon.{AddExp, AndExp, BoolValue, Expression, GtExp, IntValue, LtExp, VarRef}

import scala.util.parsing.combinator.RegexParsers


class ExpressionParser extends RegexParsers{

  def reservedWord = ("TRUE" | "FALSE" | "WHILE" | "DO" | "END" | "IF" | "THEN" | "ELSE" )

  def integer: Parser[IntValue] = {
    """-?\d+""".r ^^ { s => new IntValue(s.toInt) }
  }

  def boolTrue: Parser[BoolValue] = {
    "TRUE"  ^^ { _ => new BoolValue(true) }
  }

  def boolFalse: Parser[BoolValue] = {
    "FALSE" ^^ { _ => new BoolValue(false) }
  }

  def name: Parser[String] =  {
    not(reservedWord) ~> "[a-zA-Z_][a-zA-Z0-9_]*".r ^^ { n => n}
  }

  def variable: Parser[VarRef] = {
    name ^^ { s => VarRef(s) }
  }

  def add:  Parser[AddExp] =  operand ~ "+" ~ expression  ^^ {
    case (l ~ "+" ~ r) => AddExp(l, r)
  }

  def and:  Parser[AndExp] =  operand ~ "&" ~ expression ^^ {
    case (l ~ "&" ~ r) => AndExp(l, r)
  }

  def lessThan:  Parser[LtExp] =  operand ~ "<=" ~ expression ^^ {
    case (l ~ "<=" ~ r) => LtExp(l, r)
  }

  def greaterThan:  Parser[GtExp] =  operand ~ ">=" ~ expression  ^^ {
    case (l ~ ">=" ~ r) => GtExp(l, r)
  }

  def parenthesizedExpression = "(" ~> expression <~ ")"

  def  operand: Parser[Expression] = ( integer | variable | boolFalse | boolTrue | parenthesizedExpression)

  def expression : Parser[Expression] = (add | and | lessThan | greaterThan | operand )
}