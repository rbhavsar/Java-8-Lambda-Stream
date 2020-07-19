package Lambda.learnJava.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import Lambda.learnJava.data.Student;
import Lambda.learnJava.data.StudentDataBase;

public class StreamsExample {

    public static void main(String[] args) {

        //student name and there activities in a map
        Predicate<Student> studentPredicate = (student -> student.getGradeLevel()>=3);
        Predicate<Student> studentgpaPredicate = (student -> student.getGpa()>=3.9);


        Map<String,List<String>> studentMap = StudentDataBase.getAllStudents().stream()
//                .peek((student -> {
//                    System.out.println(student);
//                }))
                .filter(studentPredicate) //Stream<Students>
//                .peek((student -> {
//                    System.out.println("after 1 st filter " + student);
//                }))
                .filter(studentgpaPredicate)//Stream<Students>
//                .peek((student -> {
//                    System.out.println("after 2 nd filter " + student);
//                }))
                .collect(Collectors.toMap(Student::getName,Student::getActivities)); //<Map>

      Map<String, String> m0 = new HashMap<>();
      m0.put("x", "123");


      Map<String, String> m1 = new HashMap<>();
      m1.put("z", "222");

      List<Map<String, String>> l = new ArrayList<>(Arrays.asList(m0, m1));
      List<TestMap> list = new ArrayList<TestMap>();
      for (Map<String, String> stringStringMap : l) {
        TestMap testMap = new TestMap(stringStringMap);
        list.add(testMap);
      }





    }
}
