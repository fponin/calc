package com.fponin.calc;
/**
Конвертер Римских в Арабские и Арабских в Римские
*/

public class NumeralConverter {
    static int DECIMAL[] = {1, 4, 5, 9, 10, 50, 100, 500, 1000};
    static String ROMAN[] = {"I", "IV", "V", "IX", "X", "L", "C", "D", "M"};

    public static int convertRomanToDecimal(String romanNumeral) throws NumberFormatException {
        int integerValue = 0;
        int last = 200;
        for (int i = 0; i < romanNumeral.length(); i++) {
            char ch = romanNumeral.charAt(i);
            int number = letterToNumber(ch);
            if (number == -1) {
                throw new NumberFormatException("ОШИБКА: неверный формат");
            }
            if (number > last) {
                number = number - last - 1;
            }
            integerValue += number;
            last = number;
        }
        return integerValue;
    }

    private static int letterToNumber(char letter) {

        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;

            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            default:
                return -1;
        }
    }

    public static String convertDecimalToRoman(int number) {
        String romanValue = "";

        int n = number;

        while (n > 0) {
            for (int i = 0; i < DECIMAL.length; i++) {
                if (n < DECIMAL[i]) {
                    n -= DECIMAL[i - 1];
                    romanValue += ROMAN[i - 1];
                    break;
                }
            }
        }
        return romanValue;
    }
}

