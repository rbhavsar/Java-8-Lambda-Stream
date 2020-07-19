package Lambda.learnJava.streams;

import java.util.Optional;

import Lambda.learnJava.data.Student;
import Lambda.learnJava.data.StudentDataBase;

public class StreamsFindAnyFirstExample {

    public static Optional<Student> findAnyStudent(){

        return StudentDataBase.getAllStudents().stream()
                //adam
                //jenny
                //emily
                .filter(student -> student.getGpa()>=3.9)
        .findAny();
    }

    public static Optional<Student> findFirstStudent(){

        return StudentDataBase.getAllStudents().stream()
                //adam
                //jenny
                //emily
                .filter(student -> student.getGpa()>=3.9)
                .findFirst();
    }

    public static void main(String[] args) {


        Optional<Student> studentOptionalFindAny = findAnyStudent();
        if(studentOptionalFindAny.isPresent()){
            System.out.println("Found The student : "+ studentOptionalFindAny.get());
        }else{
            System.out.println("Student Not Found !");
        }

        Optional<Student> studentOptionalFindFirst = findFirstStudent();
        if(studentOptionalFindFirst.isPresent()){
            System.out.println("Found The student : "+ studentOptionalFindFirst.get());
        }else{
            System.out.println("Student Not Found !");
        }
    }
}

/*
Found The student : Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics], noteBooks=10, bike=Optional.empty}
Found The student : Student{name='Emily', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics], noteBooks=10, bike=Optional.empty}
when we run stream in parallel mode then any() result may change
 */
