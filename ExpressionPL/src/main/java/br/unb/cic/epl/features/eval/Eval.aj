package br.unb.cic.epl.features.eval;

privileged aspect Eval {

  public abstract int br.unb.cic.epl.base.Exp.eval();

  public int br.unb.cic.epl.base.Literal.eval() {
    return value;  	 
  }

  public int br.unb.cic.epl.features.add.Add.eval() {
    return left.eval() + right.eval();  	 
  }

}
