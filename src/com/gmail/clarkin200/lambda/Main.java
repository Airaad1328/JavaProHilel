package com.gmail.clarkin200.lambda;


import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    static MathOperation operation = new MathOperation() {
        @Override
        public int operator(int a, int b) {
            return a + b;
        }
    };

    static StringManipulator toUpperCase = (input) -> input.toUpperCase();

    static Function<String, Integer> countUpperCase = StringListProcessor::countUpperCase;

    public static void main(String[] args) {


        printMathOperation();

        printStringManipulation();

        printCountUpperCase();

        System.out.println();
        Supplier<Integer> randNumberSupplier = () -> (Integer) RandomNumberGenerator.generateRandomNumber(30,50);
        Integer rand = randNumberSupplier.get();
        System.out.println("Random number from supplier: " + rand);


    }

    public static void printMathOperation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 'a' value : ");
        int a = scanner.nextInt();
        System.out.println("Enter 'b' value : ");
        int b = scanner.nextInt();

        int result = operation.operator(a, b);
        System.out.println("Result a + b = " + result);
        System.out.println();
    }

    public static void printStringManipulation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter string to uppercase : ");
        String valueLowCase = scanner.nextLine();

        String result = toUpperCase.manipulate(valueLowCase);

        System.out.println(valueLowCase + " toUpperCase = " + result);
        System.out.println();
    }

    public static void printCountUpperCase() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter string value to count uppercase: ");
        String input = scanner.nextLine();

        int result = countUpperCase.apply(input);
        System.out.println("Uppercase symbols : " + result);


    }


}
