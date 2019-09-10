package br.unb.cic.epl.base;

public class Literal implements Exp {

    private int value;

    public Literal(int value) {
        this.value = value;
    }

    public String print() {
        return "" + value;
    }

}
