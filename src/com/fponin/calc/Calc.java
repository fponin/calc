package com.fponin.calc;


public class Calc {

    private String num1;
    private String num2;
    private String operator;

    public Calc(String[] form) {
        this.num1 = form[0];
        this.num2 = form[2];
        this.operator = form[1];
    }

    public void calculated() {
        int letter1 = 0;
        int letter2 = 0;
        if (isNumber(this.num1) && isNumber(this.num2)) {
            letter1 = Integer.parseInt(this.num1);
            letter2 = Integer.parseInt(this.num2);

            if (isSpan(letter1) && isSpan(letter2)) {
                System.out.println(ArithmeticsAction(operator, letter1, letter2));
            } else {
                System.out.println("Введите числа в диапазоне от 1 до 10");
            }
        } else {
            letter1 = NumeralConverter.convertRomanToDecimal(this.num1);
            letter2 = NumeralConverter.convertRomanToDecimal(this.num2);

            if (isSpan(letter1) && isSpan(letter2)) {
                System.out.println(NumeralConverter.convertDecimalToRoman(ArithmeticsAction(operator, letter1, letter2)));
            } else {
                System.out.println("Введите числа в диапазоне от 1 до 10");
            }
        }
    }

    private int ArithmeticsAction(String operator, int letter1, int letter2) {
        switch (operator) {
            case "+":
                return letter1 + letter2;
            case "-":
                return letter1 - letter2;
            case "*":
                return letter1 * letter2;
            case "/":
                return letter1 / letter2;
            default:
                throw new NumberFormatException("ОШИБКА: неверный формат");
        }
    }

    private static boolean isNumber(String s) {
        try {
            int i = Integer.parseInt(s);

        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isSpan(int i) {
        return i >= 1 && i <= 10;
    }
}