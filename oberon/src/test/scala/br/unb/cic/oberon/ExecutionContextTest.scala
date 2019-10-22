package br.unb.cic.oberon

import org.scalatest.FunSuite

class ExecutionContextTest extends FunSuite {

  test("initContext should make ExecutionContext empty") {
    ExecutionContext.initContext()

    assert(ExecutionContext.isEmpty())
  }

  test("a declared function should be present in the execution context") {
    ExecutionContext.initContext()

    val f = FunctionDeclaration("foo", List.empty, Void())

    ExecutionContext.declareFunction(f)

    println(ExecutionContext.fnDecls.size)
    assert(f == ExecutionContext.lookupFunction(f.name))
  }

  test("notify invoke should increase the heap size") {
    ExecutionContext.initContext()
    assert(ExecutionContext.heap.isEmpty)

    ExecutionContext.notifyInvoke()
    assert(ExecutionContext.heap.size == 1)

    ExecutionContext.notifyInvoke()
    assert(ExecutionContext.heap.size == 2)
  }

  test("notify return should decrease the heap size") {
    ExecutionContext.initContext()
    assert(ExecutionContext.heap.isEmpty)

    ExecutionContext.notifyInvoke()
    assert(ExecutionContext.heap.size == 1)

    ExecutionContext.notifyInvoke()
    assert(ExecutionContext.heap.size == 2)

    ExecutionContext.notifyReturn()
    assert(ExecutionContext.heap.size == 1)
  }

  test("we should be able to add new variables to global using setGlobal") {
    ExecutionContext.initContext()
    assert(ExecutionContext.heap.isEmpty)

    ExecutionContext.setGlobal("x", IntValue(10))
    ExecutionContext.setGlobal("y", IntValue(5))
    ExecutionContext.setGlobal("z", IntValue(1))


    assert(3 == ExecutionContext.global.size)
    assert(IntValue(10) == ExecutionContext.lookup("x"))
  }

  test("we should be able to add new variables to locals using setLocal") {
    ExecutionContext.initContext()
    assert(ExecutionContext.heap.isEmpty)

    ExecutionContext.setLocal("x", IntValue(10))
    ExecutionContext.setLocal("y", IntValue(5))
    ExecutionContext.setLocal("z", IntValue(1))


    assert(3 == ExecutionContext.heap.top.size)
    assert(IntValue(10) == ExecutionContext.lookup("x"))
 
  }

}
