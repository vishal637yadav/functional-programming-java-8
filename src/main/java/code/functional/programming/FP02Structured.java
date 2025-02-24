package code.functional.programming;

import java.util.List;

public class FP02Structured {

    public static void main(String[] args) {
        List<Integer> numberList = List.of(2,3,4,5,6,7,8,9);

        int sum = findSumOfNumberList(numberList);
        System.out.println(sum);


    }

    private static int findSumOfNumberList(List<Integer> numberList) {
        int sum= 0;
        for(int n : numberList){
            sum += n;
        }
        return sum;
    }


}
