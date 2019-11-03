package br.unb.cic.oberon.parser

import br.unb.cic.oberon.Expression

import scala.util.parsing.input.CharSequenceReader

object OberonParser extends StatementParser {
  def parse(code: CharSequence): Object  = {
    apply(new CharSequenceReader(code))
  }

  def apply(reader: CharSequenceReader)= {
    program(reader) match {
      case NoSuccess(msg, next) => throw new OberonExpressionError(Location(next.pos.line, next.pos.column), msg)
      case Success(result, _) => result
    }
  }

  def program(reader: CharSequenceReader)= {
    phrase(statement | expression)(reader)
  }
}
