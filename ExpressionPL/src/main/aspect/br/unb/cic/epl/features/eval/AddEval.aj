package br.unb.cic.epl.features.eval;


privileged aspect AddEval {

   public int br.unb.cic.epl.features.add.Add.eval() {
     return left.eval() + right.eval();  	 
   }

}