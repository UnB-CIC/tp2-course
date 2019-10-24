package br.unb.cic.oberon

trait Statement {
  def execute() : Unit
}

case class Void() extends Statement {
  def execute() : Unit = { } 
}


case class IfThen(cond: Expression, block: Statement) extends Statement {
  override def execute() : Unit = {
    val v = cond.eval().asInstanceOf[BoolValue] 
    if(v.value) {
      block.execute()
    }
  }
}


case class IfThenElse(cond: Expression, blockThen: Statement, blockElse: Statement) extends Statement {
  override def execute() : Unit = {
    val v = cond.eval().asInstanceOf[BoolValue] 
    if(v.value) {
      blockThen.execute()
    }
    else {
      blockElse.execute()
    }
  }
}


case class WhileStmt(cond: Expression, block: Statement) extends Statement {
  override def execute() : Unit = {
    val v = cond.eval().asInstanceOf[BoolValue] 
    if(v.value) {
      block.execute()
      this.execute()
    }
    // while(v.value) {
    //   block.execute()
    //   v = cond.eval()
    // }
  }
}

case class Assignment(name: String, exp: Expression) extends Statement {
  override def execute() : Unit = {
    ExecutionContext.setVar(name, exp.eval())
  }
}


case class Block(stmts: List[Statement]) extends Statement {
  override def execute() : Unit = {
    stmts.foreach(s => s.execute())
  }
}

