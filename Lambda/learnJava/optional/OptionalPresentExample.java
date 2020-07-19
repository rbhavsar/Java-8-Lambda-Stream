package Lambda.learnJava.optional;

import java.util.Optional;

public class OptionalPresentExample {

    public static void main(String[] args) {

        //isPresent
        Optional<String> optional = Optional.ofNullable("null");
        System.out.println(optional.isPresent()); //true
        if(optional.isPresent()){
            System.out.println(optional.get()); //"null"
        }
        //ifPresent
        optional.ifPresent(s -> System.out.println(s)); //"null"

        optional = Optional.ofNullable(null);
        optional.ifPresent(s -> System.out.println(s)); // nothing will printed
        System.out.println(optional.get()); //java.util.NoSuchElementException: Program will terminate here

    }
}
