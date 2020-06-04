import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }

    private static long getFibonacciSumSquaresOptimised(long n) {
        if (n <= 1)
            return n;

        long current = calc_fib(n % 60);
        long next = calc_fib((n + 1) % 60);

        return ((current % 10) * (next % 10) % 10);
    }

    private static long calc_fib(long n) {
        if (n == 1 || n == 0) {
            return n;
        }

        long fib1 = 0;
        long fib2 = 1;
        long fib3 = 0;
        for (long i = 2; i <= n; i++) {
            fib3 = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib3;
        }
        return fib3;
    }

    public static void stressTest(){
        boolean OK = true;
        while (OK){
            long r1 = ThreadLocalRandom.current().nextLong(100);
            System.out.println("Random number 1: "+r1);

            long naive = getFibonacciSumSquaresNaive(r1);
            long optimised = getFibonacciSumSquaresOptimised(r1);
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
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresOptimised(n);
        System.out.println(s);
    }
}

