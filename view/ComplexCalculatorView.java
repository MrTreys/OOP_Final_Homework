package view;

import java.util.Scanner;

import model.ComplexNumber;
import calculator.ComplexNumberCalculator;

public class ComplexCalculatorView implements CalculatorPreview {

    @Override
    public void run() {
        while (true) {
            ComplexNumber firstArg = toComplexNumber(input("Type original complex number (In 'a + bi' format): "));
            ComplexNumberCalculator calc = new ComplexNumberCalculator(firstArg);
            String command = new String();

            while (true) {
                command = input("Type operation: ");

                if (command.equals("+")) {
                    ComplexNumber secArg = toComplexNumber(input("Type another complex number to increase: "));
                    calc.sum(secArg);
                    continue;
                }

                if (command.equals("-")) {
                    ComplexNumber secArg = toComplexNumber(input("Type another complex number to decrease: "));
                    calc.subtraction(secArg);
                    continue;
                }

                if (command.equals("*")) {
                    ComplexNumber secArg = toComplexNumber(input("Type another complex number to multiply: "));
                    calc.multi(secArg);
                    continue;
                }

                if (command.equals("/") || command.equals(":")) {
                    ComplexNumber secArg = toComplexNumber(input("Type another complex number to divide: "));
                    calc.division(secArg);
                    continue;
                }

                if (command.equals("=")) {
                    System.out.println("Final result: ");
                    System.out.println(calc.result());
                    break;
                }
            }
            command = input("Continue work? (+ / -)");
            if (!command.equals("+")) break;
        }
    }
              
    @SuppressWarnings("resource")
    private String input(String message) {
        Scanner scanner = new Scanner(System.in);
        if (!message.equals(null)) System.out.println(message);
        return scanner.nextLine();
    }

    private ComplexNumber toComplexNumber(String rawNumber) {
        String[] separatedNum = rawNumber.split(" ");
        int a;
        int b;
        if (separatedNum.length > 1) {
            if (separatedNum[0].charAt(0) == '-') a = -Integer.parseInt(separatedNum[0].replaceAll("-", "")); 
            else a = Integer.parseInt(separatedNum[0]);
            if (separatedNum[2].length() > 1) {
                if (separatedNum[1].charAt(0) == '-') b = -Integer.parseInt(separatedNum[2].replaceAll("i", "").replaceAll("-", ""));
                else b = Integer.parseInt(separatedNum[2].replaceAll("i", ""));
            }
            else {
                if (separatedNum[1].charAt(0) == '-') b = -1;
                else b = 1;
            }
        }

        else {
            if (separatedNum[0].contains("i")) {
                a = 0;
                if (separatedNum[0].charAt(0) == '-') b = -Integer.parseInt(separatedNum[0].replaceAll("i", "").replaceAll("-", ""));
                else b = Integer.parseInt(separatedNum[0].replaceAll("i", ""));
            }
            else {
                b = 0;
                if (separatedNum[0].charAt(0) == '-') a = -Integer.parseInt(separatedNum[0].replaceAll("-", "")); 
                else a = Integer.parseInt(separatedNum[0]);
            }
        }

        return new ComplexNumber(a, b);
        
    }
}
