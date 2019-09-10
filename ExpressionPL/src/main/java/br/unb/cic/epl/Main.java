package br.unb.cic.epl;


import br.unb.cic.epl.base.Exp;
import br.unb.cic.epl.base.Literal;
import br.unb.cic.epl.features.add.Add;


// para executar
// target/classes java -cp ../Expression-PL-1.0-SNAPSHOT-jar-with-dependencies.jar:. br.unb.cic.epl.Main
public class Main {

    public static void main(String args[]) {

	Exp i10 = new Literal(10);
	Exp i20 = new Literal(20);

	Exp add = new Add(i10, i20);
	
	System.out.println(i10.print());

	System.out.println(add.eval());	
    }

}
