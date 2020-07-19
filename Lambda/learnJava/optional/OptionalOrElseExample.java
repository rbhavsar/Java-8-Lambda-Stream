package Lambda.learnJava.optional;

import java.util.Optional;

import Lambda.learnJava.data.Student;

public class OptionalOrElseExample {

    //orElse

    public static void optionalOrElse(){

       /* Optional<Student> studentOptional =
                Optional.ofNullable(StudentDataBase.studentSupplier.get());*/
        Optional<Student> studentOptional = Optional.ofNullable(new Student("Ravi")); // Option.empty
        String name = studentOptional.map(Student::getName).orElse("Default");
        System.out.println(name);// Ravi

        studentOptional = Optional.ofNullable(null);
        name = studentOptional.map(Student::getName).orElse("Default");
        System.out.println(name);// Default


        studentOptional =
            Optional.ofNullable(new Student("Ravi"));
        name = studentOptional.map(Student::getName).orElseGet(()->"Default");
        System.out.println(name);// Ravi

        studentOptional =
            Optional.ofNullable(new Student(null));
        name = studentOptional.map(Student::getName).orElseGet(()->"Default");
        System.out.println(name);// Default


        studentOptional =
            Optional.ofNullable(null);

        name = studentOptional.map(Student::getName)
            .orElseThrow(()->new RuntimeException("No Data Available"));


        System.out.println(name);// java.lang.RuntimeException: No Data Available : Program terminate
    }
    //orElseGet
    public static String optionalOrElseGet(){
        Optional<Student> studentOptional =
                Optional.ofNullable(new Student("xyz"));
        String name = studentOptional.map(Student::getName).orElseGet(()->"Default");
        return name;



    }

    //orElseThrow
    public static String optionalOrElseThrow(){

        Optional<Student> studentOptional =
                Optional.ofNullable(null);

        String name = studentOptional.map(Student::getName)
                .orElseThrow(()->new RuntimeException("No Data Available"));

        return name;
    }
    public static void main(String[] args) {

        optionalOrElse();
//        System.out.println("orElse : " + optionalOrElse());
//        System.out.println("orElseGet :  " + optionalOrElseGet());
//        System.out.println("orElseThrow :  " + optionalOrElseThrow());
    }
}
