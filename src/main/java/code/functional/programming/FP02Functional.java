package code.functional.programming;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FP02Functional {

    public static void main(String[] args) {
        List<Integer> numberList = List.of(2,3,4,5,6,7,8,9);
        System.out.print("sum :");
        int sum = findSumUsingFunctionalProgramming(numberList);
        System.out.println(sum);

        System.out.print("Using Lambda Expression sum :");
        sum = numberList.stream().reduce(0, (x,y) -> x+y);
        System.out.println(sum);
        System.out.println();
        System.out.print("Using Integer.sum Aggregate Function sum :");
        sum = numberList.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println("Find Maximum Value in the Array");
        int maxValue = numberList.stream().reduce(Integer.MIN_VALUE,(x,y)-> x<y?y:x);
        System.out.println("Max-Value :"+maxValue);
        System.out.println("Find Minimum Value in the Array");
        int minValue = numberList.stream().reduce(Integer.MAX_VALUE,(x,y)-> x>y?y:x);
        System.out.println("Min-Value :"+minValue);

        System.out.println("Test->-:"+getSquarsList(numberList));

    }

    private static int sum(int aggregate,int number){
        System.out.println("aggregate :"+aggregate+", number :"+number);
        return aggregate+number;
    }

    private static int findSumUsingFunctionalProgramming(List<Integer> numberList) {
        return numberList.stream().reduce(0,FP02Functional::sum);
    }

    public static List<Integer> getSquarsList(List<Integer> list){
        return list.stream().map(getSquare()).collect(Collectors.toList());
    }

    private static Function<Integer, Integer> getSquare() {
        return n -> n * n;
    }

}
