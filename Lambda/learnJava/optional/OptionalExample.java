package Lambda.learnJava.optional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

import Lambda.learnJava.data.Student;
import Lambda.learnJava.data.StudentDataBase;


public class OptionalExample {

    public static String getStudentName(){

        //Student student = StudentDataBase.studentSupplier.get();
        Student student = null;
        if(student!=null){
            return student.getName();
        }

        return null;
    }

    public static Optional<String> getStudentNameOptional(){

        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        Optional<Optional<Object>> student1 =  Optional.ofNullable(Optional.empty());
        if(student1.isPresent()){
            System.out.println("present");
        }else {
            System.out.println("not present");
        }
        //Optional<Student> studentOptional = Optional.ofNullable(null); // Optional.empty()
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();//Student
            return studentOptional.map(Student::getName); //Optional<String>
        }

        return Optional.empty(); // Represents an optional object with no value
    }

    public static void main(String[] args) {


        Set<String> inputSpaceIds = new HashSet<>();
        inputSpaceIds.add("1");
        inputSpaceIds.add("2");

        String query = inputSpaceIds.toString().replace("[","'").replace("]","'")
            .replace(", ","','");
        System.out.println(query);
        
//        StringBuilder stringBuilder = new StringBuilder();
//        int counter = 0;
//        for (String inputSpaceId : inputSpaceIds) {
//            stringBuilder.append("'").append(inputSpaceId).append("'");
//            counter++;
//            if(counter<inputSpaceIds.size())
//                stringBuilder.append(",");
//        }
//        System.out.println(stringBuilder);



//        String spaceIds = StringUtils.join(inputSpaceIds, ',');
//
//        String query = "select * from spaces where spaceId IN ("+spaceIds+")";

        Set<String> availableSpaces = new HashSet<>();
        availableSpaces.add("1");
        //availableSpaces.add("2");




        Optional<Student> student;
        student = Optional.ofNullable(null);
        if(student.isPresent())
            System.out.println("exception");

        /*String name = getStudentName();
        if(name!=null)
            System.out.println("Length of the student Name : " + name.length());
        else
            System.out.println("Name not found");*/

        Optional<String> stringOptional = getStudentNameOptional();

        if(stringOptional.isPresent()){
            System.out.println("Length of the student Name : " +
                    stringOptional.get().length()); //String which is Student Name
        }else{
            System.out.println("Name not found");
        }


        Supplier supplier = new Supplier() {
            @Override
            public Object get() {
                return StudentDataBase.studentSupplier.get();
            }
        };




    }
}
