package br.unb.cic.oberon.parser

import br.unb.cic.oberon.{Assignment, Block, Expression, GtExp, IfThen, IfThenElse, Statement, WhileStmt}

class StatementParser extends ExpressionParser {


  def block: Parser[Block] = repsep(statement, ";")^^ {
    case (b) => Block(b)
  }

  def assignStatement: Parser[Assignment] = name ~ ":=" ~ (expression | integer | boolTrue | boolFalse) ^^ {
    case (n ~ ":=" ~ e) => Assignment(n, e)
  }

  def whileStatement: Parser[WhileStmt] = "WHILE" ~ condition ~ "DO" ~ block~ "END" ^^ {
    case ("WHILE" ~ con ~ "DO" ~ cod ~ "END") => WhileStmt(con, cod)
  }

  def ifThenStatement: Parser[IfThen] = "IF" ~ condition ~ "THEN" ~ block~ "END" ^^ {
    case ("IF" ~ b ~ "THEN" ~ c ~ "END") => IfThen(b, c)
  }

  def ifThenElseStatement: Parser[IfThenElse] = "IF" ~ condition ~ "THEN" ~ block~ "ELSE" ~ block~ "END" ^^ {
    case ("IF" ~ b ~ "THEN" ~ c1 ~ "ELSE" ~ c2 ~ "END") => IfThenElse(b, c1, c2)
  }

  def condition = (and | greaterThan | lessThan | variable | boolTrue | boolFalse)

  def statement: Parser[Statement] = (whileStatement | assignStatement | ifThenStatement | ifThenElseStatement)

}
