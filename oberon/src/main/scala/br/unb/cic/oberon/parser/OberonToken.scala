package br.unb.cic.oberon.parser

import scala.util.parsing.input.Positional

trait OberonToken extends Positional

case class IDENTIFIER(str: String) extends OberonToken
case class  INT_LITERAL(str: String) extends OberonToken
case class PLUS() extends OberonToken
case class ASSIGN() extends OberonToken
case class EQUALS() extends OberonToken
case class WHILE() extends OberonToken
case class DO() extends OberonToken
case class END() extends OberonToken

