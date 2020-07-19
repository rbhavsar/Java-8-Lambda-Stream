package Lambda.learnJava.parallelstream;

import java.util.concurrent.locks.ReentrantLock;

public class Sum {

    private volatile boolean update = false;
    final ReentrantLock lock = this.lock;
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void performSum(int input){

            
            total += input;


    }
}
