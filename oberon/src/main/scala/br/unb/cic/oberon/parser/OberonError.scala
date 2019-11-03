package br.unb.cic.oberon.parser

trait OberonError extends Throwable

case class OberonExpressionError(location: Location, msg: String) extends OberonError

case class Location(line: Int, column: Int) {
  override def toString = s"$line:$column"
}