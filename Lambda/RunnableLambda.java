package Lambda;

import java.util.Comparator;

/**
 * @author rbhavsar
 * Created on 5/21/20.
 */
public class RunnableLambda {
  public static void main(String[] args) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("Inside Runnable1..");
      }
    };

    new Thread(runnable).start();

    //Implement runnable interface using lambda
    Runnable runnableLambda = () -> {
      System.out.println("Inside Runnable2..");
    };

    new Thread(runnableLambda).start();


    new Thread(() -> System.out.println("Inside Runnable3")).start();


    Comparator<Integer> comparator = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2); // o1=o2 -> 0 , o1>o2 -> 1 , o1<o2 - -1
      }
    };

    System.out.println(comparator.compare(3,2));


    Comparator<Integer> comparatorlambda = (Integer a, Integer b ) -> {
      return a.compareTo(b);
    };

    Comparator<Integer> comparatorlambda1 = (Integer a, Integer b ) -> a.compareTo(b);

    System.out.println(comparatorlambda.compare(3,2));
    System.out.println(comparatorlambda1.compare(3,2));

  }
}
