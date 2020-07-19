package Lambda.learnJava.methodreference;

import java.util.function.Consumer;

import Lambda.learnJava.data.Student;
import Lambda.learnJava.data.StudentDataBase;

public class ConsumerMethodReferenceExample {

    /**
     * classname::methodName
     */
    static Consumer<Student> c1= (student -> {
        System.out.println(student);
    });

    static Consumer<Student> c2= Student::printListOfActivities;


    public static void main(String[] args) {

        StudentDataBase.getAllStudents().forEach(c1);
        System.out.println("========================================================================================================================================================");
        StudentDataBase.getAllStudents().forEach(c2);
    }
}
