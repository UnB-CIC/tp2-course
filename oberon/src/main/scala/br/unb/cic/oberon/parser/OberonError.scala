package br.unb.cic.oberon.parser

trait OberonError

case class OberonLexerError(location: Location, msg: String) extends OberonError
case class OberonParserError(location: Location, msg: String) extends OberonError

case class Location(line: Int, column: Int) {
  override def toString = s"$line:$column"
}