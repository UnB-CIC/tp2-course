package br.unb.cic.oberon


case class FormalParameter(pmtName: String, pmtType: Type)

case class VarDeclaration(varName: String, varType: Type)

case class FunctionDeclaration(name: String, formalArgs: List[FormalParameter], block: Statement)

