package br.unb.cic.oberon.parser

import br.unb.cic.oberon.{AddExp, AndExp, Assignment, Block, BoolValue, GtExp, IfThen, IfThenElse, IntValue, LtExp, VarRef, WhileStmt}
import org.scalatest.FunSuite

class OberonParserTest extends FunSuite {
  test("Parsing sum of two integer literals into AddExp"){
    assert(OberonParser.parse("1 + 2") ==
      AddExp(IntValue(1), IntValue(2)))
  }

  test("Parsing AddExp with parenthesized expressions"){
    assert(OberonParser.parse("(-1 + 10) + 2") ==
      AddExp(AddExp(IntValue(-1), IntValue(10)), IntValue(2)))
  }

  test("Parsing AddExp with variables"){
    assert(OberonParser.parse("(num_batatas + 10) + 2") ==
      AddExp(AddExp(VarRef("num_batatas"), IntValue(10)), IntValue(2)))
  }

  test("Parsing AndExp with BoolValues"){
    assert(OberonParser.parse("TRUE & FALSE") ==
      AndExp(BoolValue(true), BoolValue(false)))
  }

  test("Parsing AndExp with BoolValues and parenthesized expressions"){
    assert(OberonParser.parse("(TRUE & FALSE) & TRUE") ==
      AndExp(AndExp(BoolValue(true), BoolValue(false)), BoolValue(true)))
  }

  test("It throws an error when expression is incomplete"){
    assertThrows[OberonExpressionError] {
      OberonParser.parse("1 + ")
    }
  }

  test("It throws an error with invalid variable name in AddExp"){
    assertThrows[OberonExpressionError] {
      OberonParser.parse("9batata + 2")
    }
  }

  test("Parsing LtExp"){
    assert(OberonParser.parse("(2 + 1) <= 4") ==
      LtExp(AddExp(IntValue(2),  IntValue(1)), IntValue(4)))
  }

  test("Parsing GtExp"){
    assert(OberonParser.parse("2 >= 6") ==
      GtExp(IntValue(2), IntValue(6)))
  }

  test("Parsing Assigment with arithmetic expression"){
    assert(OberonParser.parse("x := 9 + 2 + 5") ==
      Assignment("x", AddExp(IntValue(9), AddExp(IntValue(2), IntValue(5)))))
  }

  test("Parsing Assigment with Boolean Value"){
    assert(OberonParser.parse("x := FALSE") ==
      Assignment("x", BoolValue(false)))
  }

  test("Parsing WhileStmt with single statement"){
    assert(OberonParser.parse("WHILE x >= 3 DO x := 4 END") ==
      WhileStmt(GtExp(VarRef("x"), IntValue(3)), Block(List(Assignment("x", IntValue(4))))))
  }

  test("Parsing WhileStmt with block of statements"){
    assert(OberonParser.parse("WHILE x <= 3 DO x := 0 ; x := 1 END") ==
      WhileStmt(LtExp(VarRef("x"),IntValue(3)), Block(List(Assignment("x", IntValue(0)), Assignment("x", IntValue(1))))))
  }

  test("Parsing IfThen"){
    assert(OberonParser.parse("IF TRUE THEN x := 0 ; x := 1 END") ==
      IfThen(BoolValue(true), Block(List(Assignment("x", IntValue(0)), Assignment("x", IntValue(1))))))
  }

  test("Parsing IfThenElse"){
    assert(OberonParser.parse("IF TRUE & FALSE THEN x := 0 ; x := 1 ELSE x := 4 END") ==
      IfThenElse(AndExp(BoolValue(true), BoolValue(false)),
        Block(List(Assignment("x", IntValue(0)), Assignment("x", IntValue(1)))),
        Block(List(Assignment("x", IntValue(4))))))
  }
}
