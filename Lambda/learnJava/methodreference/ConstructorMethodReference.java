package Lambda.learnJava.methodreference;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

import Lambda.learnJava.data.Student;

/**
 * @author rbhavsar
 * Created on 5/25/20.
 */
public class ConstructorMethodReference {

  static Supplier<Student> supplier = Student::new; // no arg constructor should be available in Student class

  static Function<String,Student> function = Student::new; // constructor Student(String s) {this.name =s } as function interface has two argument , 1st is input and 2nd is output

  public static void main(String[] args) {
    System.out.println(supplier.get());
    System.out.println(function.apply("Ravi"));

    int[] array = {1,2,3};
    Arrays.stream(array).
        filter(x -> x>1). //
        forEach(System.out::print);

    /*
    Output :
    2 3
     */
  }
}
