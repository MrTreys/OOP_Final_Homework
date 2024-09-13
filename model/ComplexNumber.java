package model;

public class ComplexNumber extends Number {
    private int b;

    public ComplexNumber(int baseNumber, int secondaryNum) {
        super(baseNumber);
        this.b = secondaryNum;
    }

    public int getSecondaryNumber() {
        return b;
    }

    public void setSecondaryNumber(int secondaryNum) {
        this.b = secondaryNum;
    }

    @Override
    public String toString() {
        String result = "";
        if (super.a != 0) {
            result += a + " ";
        }

        if (this.b > 1 && super.a != 0) result += "+ " + this.b;
        else if (this.b > 1 && super.a == 0) result += this.b;
        else if (this.b == -1 && super.a != 0) result += "- ";
        else if (this.b == -1 && super.a == 0) result += "-";
        else if (this.b == 1 && super.a != 0) result += "+ ";
        else if (this.b < 0 && super.a == 0) result += "-" + -this.b;
        else if (this.b < 0 && super.a != 0) result += "- " + -this.b;
        else if (this.b < 0 && super.a == 0) result += "-" + -this.b;

        if (b != 0) result += "i";
        
        if (super.a == 0 && this.b == 0) result += "0";

        return result;
    }
}
