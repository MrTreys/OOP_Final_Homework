package calculator;

import model.ComplexNumber;

public interface ComplexCalculable {
    ComplexCalculable sum (ComplexNumber arg);
    ComplexCalculable subtraction(ComplexNumber arg);
    ComplexCalculable multi(ComplexNumber arg);
    ComplexCalculable division(ComplexNumber arg);
    ComplexNumber result();
}
