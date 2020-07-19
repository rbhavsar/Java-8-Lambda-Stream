package Lambda.learnJava.optional;

import java.util.Optional;

public class OptionalOfEmptyNullableExample {

    public static void ofNullable(){

        Optional<String> stringOptional =Optional.ofNullable("Helllo");
        System.out.println(stringOptional); //Optional[Helllo]
        System.out.println(stringOptional.get());//Helllo

        stringOptional =Optional.ofNullable(null);
        System.out.println(stringOptional); // Optional.empty
       // System.out.println(stringOptional.get()); //NoSuchElementException: No value present and program breaks here

        stringOptional =Optional.of("Hello");

        System.out.println(stringOptional); //Optional[Hello]
        System.out.println(stringOptional.get()); //Hello

        //stringOptional =Optional.of(null); //java.lang.NullPointerException and break the program here
        //System.out.println(stringOptional); //can't execute because of above
       // System.out.println(stringOptional.get());//can't execute because of above
        //return stringOptional;
    }


    public static Optional<String> of(){

        Optional<String> stringOptional =Optional.of("Hello");
        return stringOptional;
    }

    public static Optional<String> empty(){

        return Optional.empty();
    }

    public static void main(String[] args) {

        ofNullable();
        //System.out.println("OfNUllable : " + ofNullable());
//        System.out.println("of : " + of());
//        System.out.println("empty : " + empty());
    }
}
