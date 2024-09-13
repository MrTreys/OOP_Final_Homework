package calculator;

import model.ComplexNumber;

public class ComplexNumberCalculator implements ComplexCalculable {
    private ComplexNumber firstArg;

    public ComplexNumberCalculator(ComplexNumber firstArg) {
        this.firstArg = firstArg;
    }

    @Override
    public ComplexNumber result() {
        return firstArg;
    }

    @Override
    public ComplexCalculable sum(ComplexNumber arg) {
        this.firstArg = new ComplexNumber(firstArg.getMainNumber() + arg.getMainNumber(), firstArg.getSecondaryNumber() + arg.getSecondaryNumber());
        return this;
    }

    @Override
    public ComplexCalculable subtraction(ComplexNumber arg) {
        return sum(new ComplexNumber(-arg.getMainNumber(), -arg.getSecondaryNumber()));
    }

    @Override
    public ComplexCalculable multi(ComplexNumber arg) {
        int aa = this.firstArg.getMainNumber() * arg.getMainNumber();
        int ab = (this.firstArg.getMainNumber() * arg.getSecondaryNumber()) + (this.firstArg.getSecondaryNumber() * arg.getMainNumber());
        int bb = this.firstArg.getSecondaryNumber() * arg.getSecondaryNumber() * -1;
        this.firstArg = new ComplexNumber(aa + bb, ab);
        return this;
    }

    @Override
    public ComplexCalculable division(ComplexNumber arg) {
        ComplexNumberCalculator calculate = new ComplexNumberCalculator(this.firstArg);
        calculate.multi(new ComplexNumber(arg.getMainNumber(), -arg.getSecondaryNumber()));
        int denominator = (int) (Math.pow(arg.getMainNumber(), 2) + Math.pow(arg.getSecondaryNumber(), 2));
        firstArg = new ComplexNumber(calculate.result().getMainNumber()/denominator, calculate.result().getSecondaryNumber()/denominator);
        return this;
    }
}
