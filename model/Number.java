package model;

public abstract class Number {
    protected int a;

    public Number(int number) {
        this.a = number;
    }

    public int getMainNumber() {
        return a;
    }

    public void setMainNumber(int number) {
        this.a = number;
    }
}
