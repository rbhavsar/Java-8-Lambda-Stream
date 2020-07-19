package Lambda.learnJava.streams;

import java.util.List;

import Lambda.learnJava.data.Student;
import Lambda.learnJava.data.StudentDataBase;

import static java.util.stream.Collectors.toList;

public class StreamsFilterExample {

    public static List<Student> filterStudents(){

        return StudentDataBase.getAllStudents().stream() //Stream<Student>
                .filter((student -> student.getGender().equals("female"))) //Stream<Student>
                //filters and sends only the students whose gender is female
                .filter(student -> student.getGpa()>=3.9)
                .collect(toList());

    }

    public static void main(String[] args) {

        //System.out.println("filterStudents : " + filterStudents());
        //filterStudents().forEach(System.out::println);






    }
}
