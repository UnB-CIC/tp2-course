package br.unb.cic.epl.features.add;

import br.unb.cic.epl.base.Exp;

public class Add implements Exp {

    private Exp left;
    private Exp right;

    public Add(Exp left, Exp right) {
	this.left = left;
	this.right = right;
    }

    public String print() {
	return left.print() + " + " + right.print();
    }

}
