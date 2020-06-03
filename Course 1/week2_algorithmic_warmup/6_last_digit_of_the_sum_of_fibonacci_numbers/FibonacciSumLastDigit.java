import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    public static long getFibonacciSumOptimised(long n) {
        if (n <= 1)
            return n;

        long index = (n + 2) % 60;
        long first = 0, second =1 , current = 1;

        for (int i = 2; i <= index ; i++) {
            current = first % 10 + second % 10;
            first= second % 10;
            second = current % 10;
        }

        if(current == 0)
            return 9;

        return (current-1) % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumOptimised(n);
        System.out.println(s);
    }
}

