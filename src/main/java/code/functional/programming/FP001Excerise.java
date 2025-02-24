package code.functional.programming;

import java.util.Arrays;
import java.util.Comparator;

public class FP001Excerise {

    public static void main(String[] args) {
        System.out.println("--------------");
        String[] list = {"Spring","Spring Boot","API","SMicroservices","AWS","SPCF","Spring Security","AZURE","Docker","Kubernetes"};
        int [] numArray = {2,8,3,5,6,7,8,4,10};
        System.out.println("-------Print All Courses--------");
        Arrays.stream(list).forEach(System.out::println);
        //Arrays.stream(numArray).collectors(Collection.asList());
        System.out.println("---Printing All Element Starts With 'S'----");
        Arrays.stream(list).filter(s -> s.startsWith("S")).forEach(System.out::println);
        System.out.println("---Printing All Element contains With 'Spring'----");
        Arrays.stream(list).filter(s -> s.contains("Spring")).forEach(System.out::println);

        System.out.println("---Printing All Element contains at-least 4 words----");
        Arrays.stream(list).filter(s -> s.length()>=4).forEach(System.out::println);

        System.out.println("---Printing Cubes of Odd Numbers----");
        Arrays.stream(numArray)
                .filter(num -> num%2 ==1 )
                .map(num -> num*num*num)
                .forEach(System.out::println);

        System.out.println("---Printing No of Characters in Each Course----");
        Arrays.stream(list).map( course -> course+":="+course.length()).forEach(System.out::println);

        System.out.println("---Find Squares of Every number & sum of Squares ---");
        int sumOfSquers = Arrays.stream(numArray)
                .map(n -> {
                    System.out.println("n :"+n+", n_square:"+n*n);
                    return n*n;
                })
                .reduce(0, Integer::sum);

        System.out.println(sumOfSquers);

        sumOfSquers = Arrays.stream(numArray)
                .reduce(0, (x,y)->x+y*y);
        System.out.println(sumOfSquers);

        System.out.println("----distinct-----");
        Arrays.stream(numArray)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("---natural-order sorting----");
        Arrays.stream(list).sorted(Comparator.naturalOrder()).forEach(System.out::println);
        System.out.println("--------------");
        Arrays.stream(list).sorted(Comparator.comparing(s -> s.length())).forEach(System.out::println);


    }
}
