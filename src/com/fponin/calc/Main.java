package com.fponin.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вводите выражение для вычисления:");
        String[] form = reader.readLine().trim().toUpperCase().split(" ");

        if (form.length != 3) {
            throw new NumberFormatException("ОШИБКА: неверный формат");
        }

        Calc calculate = new Calc(form);
        calculate.calculated();
    }
}

