package Lambda.learnJava.data;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class StudentDataBase {

    public static Supplier<Lambda.learnJava.data.Student> studentSupplier = () -> {
        Bike bike = new Bike();
        bike.setName("ABC");
        bike.setModel("XYZ");
       Lambda.learnJava.data.Student student = new Lambda.learnJava.data.Student("Adam",2,3.6, "male",Arrays.asList("swimming", "basketball","volleyball"));
       student.setBike(Optional.ofNullable(bike));
       return student;
    };

    /**
     * Total of 6 students in the database.
     * @return
     */
    public static List<Lambda.learnJava.data.Student> getAllStudents(){

        /**
         * 2nd grade students
         */
        Lambda.learnJava.data.Student student1 = new Lambda.learnJava.data.Student("Adam",2,3.6, "male",Arrays.asList("swimming", "basketball","volleyball"),11);
        Lambda.learnJava.data.Student student2 = new Lambda.learnJava.data.Student("Jenny",2,3.8,"female", Arrays.asList("swimming", "gymnastics","soccer"),12);
        /**
         * 3rd grade students
         */
        Lambda.learnJava.data.Student student3 = new Lambda.learnJava.data.Student("Emily",3,4.0,"female", Arrays.asList("swimming", "gymnastics","aerobics"),10);
        Lambda.learnJava.data.Student student4 = new Lambda.learnJava.data.Student("Dave",3,3.9,"male", Arrays.asList("swimming", "gymnastics","soccer"),9);
        /**
         * 4th grade students
         */
        Lambda.learnJava.data.Student student5 = new Lambda.learnJava.data.Student("Sophia",4,3.5,"female", Arrays.asList("swimming", "dancing","football"),15);
        Lambda.learnJava.data.Student student6 = new Lambda.learnJava.data.Student("James",4,3.9,"male", Arrays.asList("swimming", "basketball","baseball","football"),14);

        List<Lambda.learnJava.data.Student> students = Arrays.asList(student1,student2,student3,student4,student5,student6);
        return students;
    }

}
