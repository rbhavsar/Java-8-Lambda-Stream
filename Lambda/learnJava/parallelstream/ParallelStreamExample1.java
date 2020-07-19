package Lambda.learnJava.parallelstream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import Lambda.learnJava.data.Student;
import Lambda.learnJava.data.StudentDataBase;

import static java.util.stream.Collectors.toList;

public class ParallelStreamExample1 {

    public static List<String> sequentialPrintStudentActivities(){

        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream() //Stream<Student>
                .map(Student::getActivities) //Stream<List<String> - stateless
                .flatMap(List::stream) //Stream<String> - stateless
                .distinct() // stateful
                .sorted() //stateful
                .collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Duration to execute the pipeline in sequential : "+ (endTime-startTime));
        return studentActivities;
    }

    public static List<String> parallelPrintStudentActivities(){

        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream() //Stream<Student>
                .parallel()
                .map(Student::getActivities) //Stream<List<String> - stateless
                .flatMap(List::stream) //Stream<String> - stateless
                .distinct() // stateful
                .sorted() //stateful
                .collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Duration to execute the pipeline in parallel : "+ (endTime-startTime));
        return studentActivities;
    }

    public static List<String> normalCase(){

        Map<Student,List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
         for (Student student : StudentDataBase.getAllStudents()) {
            map.put(student,student.getActivities());
            List<String> strings = map.get(student);
            list.addAll(strings);
        }



        return list;
    }

    public static int forUp() {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < 10000; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Duration to execute forUp : "+ (endTime-startTime));
        return sum;
    }

    public static int stream() {
        long startTime = System.currentTimeMillis();
        int x =  IntStream.range(0, 10000).parallel()
            .sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Duration to execute stream : "+ (endTime-startTime));
        return x;
    }

    public static void main(String[] args) {

//        sequentialPrintStudentActivities();
//        parallelPrintStudentActivities();
//        normalCase();

//        long startTime = System.currentTimeMillis();
//        List<String> stringStream = StudentDataBase.getAllStudents().stream()
//            .map(Student::getName)
//            .collect(toList());
//        long endTime = System.currentTimeMillis();
//        System.out.println("Duration to execute the pipeline in parallel : "+ (endTime-startTime));
//
//
//        startTime = System.currentTimeMillis();
//         stringStream = StudentDataBase.getAllStudents().parallelStream()
//            .map(Student::getName)
//            .collect(toList());
//        endTime = System.currentTimeMillis();
//        System.out.println("Duration to execute the pipeline in parallel : "+ (endTime-startTime));
//
//        startTime = System.currentTimeMillis();
//        List<String> list = new ArrayList<>();
//        for (Student student : StudentDataBase.getAllStudents()) {
//            list.add(student.getName());
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println("Duration to execute the pipeline in parallel : "+ (endTime-startTime));
        forUp();
        stream();



    }
}
