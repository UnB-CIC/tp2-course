package br.unb.cic.oberon.parser

import scala.util.parsing.combinator.RegexParsers

object OberonLexer extends RegexParsers {
  override def skipWhitespace = true

  override val whiteSpace = "[ \t\r\f]+".r

  def apply(code: String): Either[OberonError, List[OberonToken]] = {
    parse(tokens, code) match {
      case NoSuccess(msg, next) => Left(OberonLexerError(Location(next.pos.line, next.pos.column), msg))
      case Success(result, next) => Right(result)
    }
  }

  def tokens: Parser[List[OberonToken] {
  }

  private def processTokens(tokens: List[OberonToken]) = {

  }

  def identifierToken: Parser[IDENTIFIER] = positioned {
    "[a-zA-Z_][a-zA-Z0-9_]*".r ^^ { str => IDENTIFIER(str) }
  }

  def intLiteralToken: Parser[INT_LITERAL] = positioned {
    "^-*[0-9]+".r ^^ { num => INT_LITERAL(num)}
  }

  def endToken = positioned {
    "END" ^^ (_ => END())
  }

  def plusToken = positioned {
    "+" ^^ (_ => PLUS())
  }

  def assignToken = positioned {
    ":=" ^^ (_ => ASSIGN())
  }

  def whileToken: Parser[WHILE] = positioned {
    "WHILE" ^^ (_ => WHILE())
  }

  def doToken: Parser[DO] = positioned {
    "DO" ^^ (_ =>  DO())
  }

  def equalsToken = positioned {
    "==" ^^ (_ => EQUALS())
  }

}