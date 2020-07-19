package Lambda.learnJava.parallelstream;

import java.util.List;

import Lambda.learnJava.data.Student;
import Lambda.learnJava.data.StudentDataBase;

import static java.util.stream.Collectors.toList;

public class SumClient {

    public static void main(String[] args) {

//        Sum sum = new Sum();
//
//        IntStream.rangeClosed(1,1000)
//                //1,2,3..1000
//                .parallel()
//                .forEach(sum::performSum); //500500
//        //448461
//        //427396
//        //424733
//        System.out.println(sum.getTotal());



        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDataBase.getAllStudents()
            .stream() //Stream<Student>
            .map(Student::getActivities) //Stream<List<String> - stateless
            .flatMap(List::stream) //Stream<String> - stateless
            .distinct() // stateful
            .sorted() //stateful
            .collect(toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Duration to execute the pipeline : "+ (endTime-startTime));



        startTime = System.currentTimeMillis();
        studentActivities = StudentDataBase.getAllStudents()
            .stream() //Stream<Student>
            .parallel()
            .map(Student::getActivities) //Stream<List<String> - stateless
            .flatMap(List::stream) //Stream<String> - stateless
            .distinct() // stateful
            .sorted() //stateful
            .collect(toList());
        endTime = System.currentTimeMillis();
        System.out.println("Duration to execute the pipeline in parallel : "+ (endTime-startTime));

    }
}
