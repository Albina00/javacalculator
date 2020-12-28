package com.example.logics;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class Main {

        static Scanner scanner = new Scanner(System.in);

        public static void main (String[]args){
            SimpleCalculator simpleCalculator = new SimpleCalculator();
            StringCalculator stringCalculator = new StringCalculator();
            int version;
            System.out.println("Выбирите версию калькулятора\n" +
                    "1. Простой командный калькулятор\n" +
                    "2. Калькурятор String выражений");
            version = scanner.nextInt();
            while (true) {
                if (version == 1) {
                    int num1 = simpleCalculator.getInt(), num2 = simpleCalculator.getInt();
                    char operation = simpleCalculator.getOperation();
                    double value = simpleCalculator.calc(num1, num2, operation);
                    System.out.println("Результат операции: " + value);
                    value = simpleCalculator.rounding(value);
                    simpleCalculator.setValue(value);
                    simpleCalculator.saveValue();
                    System.out.println("Результат tg в градусах: " + value);
                    System.out.println("Последние резульаты" + simpleCalculator.getArrayList());


                }
                else if (version == 2) {
                    System.out.println("Введите ваше выражение:");
                    Scanner scanner = new Scanner(System.in);
                    String text;
                    text = scanner.nextLine();
                    double value = stringCalculator
                            .RPNtoAnswer(stringCalculator
                                    .ExpressionToRPN(stringCalculator
                                            .transformText(text)));
                   System.out.println("Результат операции: " + value);
                    value = stringCalculator.rounding(value);
                    stringCalculator.setValue(value);
                    stringCalculator.saveValue();

                    System.out.println("Результат tg в градусах: " + value);
                    System.out.println("Последние резульаты" + stringCalculator.getArrayList());


                }
                else {
                    System.out.println("Введите коректную версию калькулятора");
                    version = scanner.nextInt();
                }
            }

    }

}
