package br.unb.cic.oberon

import org.scalatest.FunSuite

class WhileStatementTest extends FunSuite {

  test("while updating a variable from 0 to 10") {
    ExecutionContext.initContext()

    val init = new Assignment("x", IntValue(0))
    val expInc = new AddExp(VarRef("x"), IntValue(1))
    val expLt  = new LtExp(VarRef("x"), IntValue(10))
    val assignment = new Assignment("x", expInc) 
    val whileStmt = new WhileStmt(expLt, assignment)

    init.execute()

    assert(IntValue(0) == VarRef("x").eval())

    whileStmt.execute()

    assert(IntValue(10) == VarRef("x").eval())
  }

  test("while without any execution... x should be 10") {
    ExecutionContext.initContext()

    val init = new Assignment("x", IntValue(10))
    val expInc = new AddExp(VarRef("x"), IntValue(1))
    val expLt  = new LtExp(VarRef("x"), IntValue(10))
    val assignment = new Assignment("x", expInc) 
    val whileStmt = new WhileStmt(expLt, assignment)

    init.execute()

    assert(IntValue(10) == VarRef("x").eval())

    whileStmt.execute()

    assert(IntValue(10) == VarRef("x").eval())
  }

   test("while with an infinite loop") {
    ExecutionContext.initContext()

    val init = new Assignment("x", IntValue(0))
    val expInc = new AddExp(VarRef("x"), IntValue(-1))
    val expLt  = new LtExp(VarRef("x"), IntValue(10))
    val assignment = new Assignment("x", expInc) 
    val whileStmt = new WhileStmt(expLt, assignment)

    init.execute()

    assert(IntValue(0) == VarRef("x").eval())

    assertThrows[java.lang.StackOverflowError] {
      whileStmt.execute()
    }
  }



}
