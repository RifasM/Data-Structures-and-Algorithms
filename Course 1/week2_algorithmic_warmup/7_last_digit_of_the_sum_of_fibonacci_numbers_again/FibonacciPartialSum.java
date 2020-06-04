import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    private static long getFibonacciPartialSumOptimised(long from, long to) {
        long sum = 0;

        from = from % 60;
        to = to % 60;
        if (to < from)
            to += 60;

        long current = 0;
        long next = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }

    public static void stressTest(){
        boolean OK = true;
        while (OK){
            long r1 = ThreadLocalRandom.current().nextLong(100);
            long r2 =  ThreadLocalRandom.current().nextLong(1000);
            System.out.println("Random number 1: "+r1);
            System.out.println("Random number 2: "+r2);

            long naive = getFibonacciPartialSumNaive(r1, r2);
            long optimised = getFibonacciPartialSumOptimised(r1, r2);
            System.out.println("\tNaive: "+naive);
            System.out.println("\tOptimised: "+optimised);

            if( naive == optimised)
                System.out.println("-- PASS --\n");
            else
                OK = false;
        }
    }

    public static void main(String[] args) {
        //stressTest();
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumOptimised(from, to));
    }
}

