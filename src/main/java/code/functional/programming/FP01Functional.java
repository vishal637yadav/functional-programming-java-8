package code.functional.programming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {
        List<Integer> numList = List.of(21,32,54,9,32,14,9);
        printAllNumbersInTheListFunctional(numList);
        System.out.println("----printEvenNumbers----");
        printEvenNumbers(numList);
        printSquareOfEvenNumber(numList);


    }

    private static void printSquareOfEvenNumber(List<Integer> numList) {
        numList.stream()
                .filter(n -> n%2==0)
                .map(n -> n*n)                  //Map Function
                .forEach(System.out::println);

    }

    private static void printEvenNumbers(List<Integer> numList) {
        System.out.println("-----using lamda-expression-----");
        numList.stream().filter(n -> n/2==0).forEach(System.out::println);
        System.out.println("-----using method-reference-----");
        numList.stream().filter(n -> n/2==0).forEach(System.out::println);

    }

    public static void print(int n){
        System.out.println(n);
    }

    public static boolean isEven(int n){
        return n%2 ==0;
    }

    public static boolean isOdd(int n){
        return n%2 ==1;
    }

    private static void printAllNumbersInTheListFunctional(List<Integer> numbers) {
        //printing using functional approach

        //Using Static-Method Reference
        numbers.stream().forEach(FP01Functional::print);

        System.out.println("-------------------------");
        //Using Method-Reference
        numbers.stream().forEach(System.out::println);

        System.out.println("-------------------------");
        //Using Lambda Expression
        numbers.stream().forEach( n -> System.out.println(n));

        System.out.println("------FP01Functional::isEven------------");
        numbers.stream().filter(FP01Functional::isEven).forEach(System.out::println);
        System.out.println("------FP01Functional::isOdd------------");
        numbers.stream().filter(FP01Functional::isOdd).forEach(FP01Functional::print);
        System.out.println("------Odd Using Lambda Expression-------");
        numbers.stream().filter(n -> n%2 ==1).forEach(FP01Functional::print);


    }
}
