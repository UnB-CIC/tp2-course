package br.unb.cic.oberon

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map
import scala.collection.mutable.Stack

object ExecutionContext {
  val fnDecls = Map[String, FunctionDeclaration]() // function declarations
  val global = Map[String, Expression]()           // global vars
  val heap = Stack[Map[String, Expression]]()      // local vars

  def initContext(): Unit = {
    fnDecls.clear()
    global.clear()
    heap.clear()
  }

  def declareFunction(f : FunctionDeclaration): Unit = {
    fnDecls += (f.name -> f) 
  }

  def setVar(name: String, e: Expression) : Unit = {
    if(currentContext() contains name) {
      setLocal(name, e)
    }
    else {
      setGlobal(name, e)
    }
  }
  def setGlobal(name: String, e: Expression): Unit = {
    global += (name -> e) 
  }

  def setLocal(name: String, e: Expression): Unit = {
    currentContext() += (name -> e) 
  }

  def currentContext(): Map[String, Expression]= {
    if(heap.isEmpty || heap.top == null) {
      heap.push(Map[String, Expression]())
    }
    return heap.top
  }

  def lookup(name: String): Expression = {
    if(currentContext() contains name) {
      return currentContext()(name)
    }
    else if (global contains name) {
      return global(name)
    }
    throw new RuntimeException("variable " + name + " not declared")
  }

  def lookupFunction(name: String): FunctionDeclaration  = {
    return fnDecls(name)
  }

  def isEmpty(): Boolean = fnDecls.isEmpty && global.isEmpty && heap.isEmpty

  def notifyInvoke(): Unit = {
    heap.push(Map[String, Expression]())
  }

  def notifyReturn(): Unit = {
    heap.pop
  }
}
