package Lambda.learnJava.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import Lambda.learnJava.data.Bike;
import Lambda.learnJava.data.Student;
import Lambda.learnJava.data.StudentDataBase;


public class OptionalMapFlatMapExample {

    //https://javarevisited.blogspot.com/2016/03/difference-between-map-and-flatmap-in-java8.html
    //filter
    public static void optionalFilter(){

        Optional<Student> studentOptional =
            Optional.ofNullable(StudentDataBase.studentSupplier.get()); //Optional<Student>

        studentOptional.
                filter(student -> student.getGpa()>=4.0) //
                    .ifPresent(student -> System.out.println(student));
    }

    //map
    public static  void optionalMap(){
        Optional<Student> studentOptional =
                Optional.ofNullable(StudentDataBase.studentSupplier.get()); //Optional<Student>

        if(studentOptional.isPresent()){
            Optional<String> stringOptional = studentOptional
                    .filter(student -> student.getGpa()>=3.5)
                    .map(Student::getName);
            System.out.println(stringOptional.get());
        }

    }

    //flatmap

    public static void optionalFlatMap(){

        Optional<Student> studentOptional =
                Optional.ofNullable(StudentDataBase.studentSupplier.get()); //Optional<Student>

        Optional<String> name = studentOptional
                .filter(student -> student.getGpa()>=3.5)
                .flatMap(Student::getBike)
                .map(Bike::getName);

        name.ifPresent(s -> System.out.println("name : " + s));

    }


    public static void main(String[] args) {

        optionalFilter();
        optionalMap();
        optionalFlatMap();

        List<String> list = Arrays.asList("Ravi","Kinisha","KK");
        list.sort(String.CASE_INSENSITIVE_ORDER);
    }
}
