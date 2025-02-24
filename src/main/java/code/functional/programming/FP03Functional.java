package code.functional.programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP03Functional {

    public static void main(String[] args) {
        List<Integer> numberList = List.of(12,3,14,5,14,3,18,9);
        //Predicate (input as boolean condition/expression and return boolean value
        Predicate<Integer> evenNoPredicate = n -> n % 2 == 0;
        Predicate<Integer> oddNumberPredicate = n -> n % 2 != 0;
        Predicate<Integer> multipleOfThreePredicate = n -> n % 3 == 0;

        //takes input and output
        Function<Integer, Integer> squareFunction = x -> x * x;
        Function<Integer, Integer> cubeFunction = x -> x * x * x;
        Function<Integer, String> numberToStringFunction = x -> x +"!";
        //takes input and return nothing(void)
        Consumer<Integer> listConsumer = n -> System.out.println("n-->>"+n);
        //Takes 2 inputs of same type return output of same type
        BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;
        //No Input return something
        Supplier<Integer> randomIntegerSupplier = ()-> {
            Random random = new Random();
            return random.nextInt(1000);
        };

        //BiPredicate
        BiPredicate<Integer,String> biPredicate = (x,y)-> x/y.length()>1;

        UnaryOperator<Integer> integerUnaryOperator = x -> 3*x;
        System.out.println("integerUnaryOperator.apply(12) ::-->>"+integerUnaryOperator.apply(12));
        System.out.println("Supplier randomIntegerSupplier :"+randomIntegerSupplier.get());
        System.out.println("biPredicate1::--"+biPredicate.test(12,"Vishal"));
        System.out.println("biPredicate2::--"+biPredicate.test(7,"Vishal"));

        System.out.println("=======listConsumer==========");
        numberList.forEach(listConsumer);

        numberList.stream().reduce(0, sumBinaryOperator);

        System.out.println("-----Print Even------------");
        filterAndPrint(numberList, evenNoPredicate);
        System.out.println("-----Print Odds------------");

        filterAndPrint(numberList, oddNumberPredicate);
        System.out.println("-----Print 3 multiple------------");
        filterAndPrint(numberList, multipleOfThreePredicate);
        System.out.println("3 Multiple Element in List :"+filterAndReturn(numberList, multipleOfThreePredicate));

        System.out.println("-----mapAndPrintList(x -> x*x)------------");
        printList(numberList);
        mapAndPrintList(numberList, squareFunction);
        System.out.println("mapAndCreateNewList::"+mapAndCreateNewList(numberList, squareFunction));
        System.out.println("cube mapAndCreateNewList::"+mapAndCreateNewList(numberList, cubeFunction));
        System.out.println("numberToStringFunction mapAndCreateNewList::"+mapAndCreateNewList(numberList, numberToStringFunction));


    }

    public static <T> void printMyWay(T t){
        System.out.print(t+",");
    }
    public static <T> void printList(List<T> list){
        System.out.print("printList.printMyWay :: [");
        list.forEach(FP03Functional::printMyWay);
        System.out.println("] ");
    }

    private static <T> void filterAndPrint(List<T> list, Predicate<T> predicate){
        list.stream().filter(predicate).forEach(System.out::println);
    }

    private static <T> List<T> filterAndReturn(List<T> list, Predicate<T> predicate){
        //for returning new list
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    private static <T> void mapAndPrintList(List<T> list, Function<T,T> mappingFunction){
        System.out.println("---------mapAndPrintList-----mappingFunction:"+mappingFunction+"------------");
        list.stream().map(mappingFunction).forEach(System.out::println);
    }

    private static <T,R> List<R> mapAndCreateNewList(List<T> list, Function<T,R> mappingFunction){
        System.out.println("---------mapAndCreateNewList-----mappingFunction:"+mappingFunction+"------------");
        return list.stream().map(mappingFunction).collect(Collectors.toList());
    }

}
