package code.functional.programming;

import java.util.List;

public class FP01Structured {

    public static void main(String[] args) {
        List<Integer> list = List.of(21,32,54,9,32,14,9);
        printAllNumbersInTheList(list);
        System.out.println("---print event numbers----");
        printEvenNumbers(list);
    }

    private static void printEvenNumbers(List<Integer> list) {
        for(Integer n : list){
            if(n%2 == 0){
                System.out.println(n);
            }
        }
    }

    private static void printAllNumbersInTheList(List<Integer> numbers) {
        for(Integer n : numbers){
            System.out.println(n);
        }
    }

}
