package code.functional.programming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", noOfStudents=" + noOfStudents +
                ", reviewScore="+reviewScore +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }
}

public class FP04CustomClass {

    public static void main(String[] args) {
        List<Course> courseList = List.of(
                new Course("Spring","Framework",98,1500),
                new Course("Spring Boot","Framework",96,2500),
                new Course("Microservices","Framework",94,1200),
                new Course("FullStack","FullStack",96,1800),
                new Course("AWS","Framework",91,2100),
                new Course("Azure","Cloud",88,800),
                new Course("Docker","Cloud",92,950),
                new Course("GCP","Cloud",94,3000),
                new Course("Jenkins","DevOps",85,1800),
                new Course("Kubernetes","Cloud",95,1200)
                );

        System.out.println(courseList);

        Predicate<Course> courseGreaterthan80Predicate = x -> x.getReviewScore() > 80;
        Predicate<Course> courseGreaterthan90Predicate = x -> x.getReviewScore() > 90;
        Predicate<Course> courseGreaterthan95Predicate = x -> x.getReviewScore() > 95;

        boolean matchAll = courseList.stream().allMatch(courseGreaterthan80Predicate);
        System.out.println(matchAll);
        System.out.println("allMatch(courseGreaterthan95Predicate) :"+courseList.stream().allMatch(courseGreaterthan95Predicate));
        System.out.println("allMatch(courseGreaterthan90Predicate) :"+courseList.stream().allMatch(courseGreaterthan90Predicate));
        System.out.println("allMatch(courseGreaterthan80Predicate) :"+courseList.stream().allMatch(courseGreaterthan80Predicate));

        System.out.println("anyMatch(courseGreaterthan95Predicate) :"+courseList.stream().anyMatch(courseGreaterthan95Predicate));
        System.out.println("anyMatch(courseGreaterthan90Predicate) :"+courseList.stream().anyMatch(courseGreaterthan90Predicate));
        System.out.println("anyMatch(courseGreaterthan80Predicate) :"+courseList.stream().anyMatch(courseGreaterthan80Predicate));

        System.out.println("noneMatch(courseGreaterthan95Predicate) :"+courseList.stream().noneMatch(courseGreaterthan95Predicate));
        System.out.println("noneMatch(courseGreaterthan90Predicate) :"+courseList.stream().noneMatch(courseGreaterthan90Predicate));
        System.out.println("noneMatch(courseGreaterthan80Predicate) :"+courseList.stream().noneMatch(courseGreaterthan80Predicate));

        Comparator<Course> compareCourseByNoOfStudentsIncreasing = Comparator.comparingInt(Course::getNoOfStudents);
        Comparator<Course> compareCourseByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
        Comparator<Course> compareCourseByNoOfStudentAndReviewScore = Comparator.comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore);

        System.out.println("------------Sorting Courses :coursesSortedListByNoOfStudent---------------------");
        List<Course> coursesSortedListByNoOfStudent = courseList.stream().sorted(compareCourseByNoOfStudentsIncreasing).collect(Collectors.toList());
        coursesSortedListByNoOfStudent.forEach(System.out::println);

        System.out.println("------------Sorting Courses :coursesSortedListByNoOfStudentDecreasing---------------------");
        List<Course> coursesSortedListByNoOfStudentDecreasing = courseList.stream().sorted(compareCourseByNoOfStudentsDecreasing).collect(Collectors.toList());
        coursesSortedListByNoOfStudentDecreasing.forEach(System.out::println);

        System.out.println("------------Sorting Courses :compareCourseByNoOfStudentAndReviewScore---------------------");
        List<Course> coursesSortedListByNoOfStudent2 = courseList.stream().sorted(compareCourseByNoOfStudentAndReviewScore).toList();
        coursesSortedListByNoOfStudent2.forEach(System.out::println);

        System.out.println("--------LImit------");
        courseList.stream().limit(3).forEach(System.out::println);

        String s = " a the sky    is   blue   " ;
        System.out.println("------bolue------::"+Arrays.toString(s.split(" ")));
        String out =
                Arrays.stream(s.split(" "))
                .map( String::trim)
                .filter(f -> !f.isEmpty()).collect(Collectors.joining("|"));

        System.out.println("out--"+out);
        String out2 = String.join(" ", Arrays.stream(s.split(" "))
                .map(String::trim)
                .filter(f -> !f.isEmpty()).collect(Collectors.toList()).reversed());
        System.out.println("out2 ::"+out2);

        System.out.println("max ::"+courseList.stream().max(Comparator.comparing(c ->c.getNoOfStudents())).get());
    }
}
