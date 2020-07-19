package Lambda.learnJava.functionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    static Predicate<Integer> p = (i) -> { return i%2==0;};

    static Predicate<Integer> p1 = (i) -> i%2==0;

    static Predicate<Integer> p2 = (i) -> i%5==0;
    static Predicate<Integer> p3 = (Integer i) -> i%5==0;


    public static void predicateAnd(){

        System.out.println("Predicate And result is : " + p1.and(p2).test(10)); //predicate chaining
        System.out.println("Predicate And result is : " + p1.and(p2).test(9)); //predicate chaining

    }

    public static void predicateOr(){

        System.out.println("Predicate OR result is : " + p1.or(p2).test(10)); //predicate chaining
        System.out.println("Predicate OR result is : " + p1.or(p2).test(8)); //predicate chaining

    }

    public static void predicateNegate(){

        System.out.println("Predicate Negate result is : " + p1.or(p2).negate().test(8)); //predicate chaining

    }

    public static void main(String[] args) {


        System.out.println(p.test(4));


        System.out.println(p1.test(4));

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==0;
            }
        };

        predicate.test(4);

        predicateAnd();
        predicateOr();
        predicateNegate();

        Character var = '7';
        switch(var) {
            case '7':
                System.out.println("Lucky no. 7");
                break;
            default:
                System.out.println("DEFAULT");
        }


        short[] array = new short[]{100,100};




        List<Character> list = new ArrayList<>();
                 list.add(0, 'V');
                 list.add('T');
                 list.add(1, 'E');
                 list.add(3, 'O');
                 if(list.contains('O')) {
                     list.remove(0);
                         list.remove(new Character('0'));
                     }
                 for(char ch : list) {
                         System.out.print(ch);
          }








    }
}
