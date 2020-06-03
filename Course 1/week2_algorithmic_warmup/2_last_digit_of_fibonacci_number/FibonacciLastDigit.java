import java.math.BigInteger;
import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }

    public static int getFibonacciLastDigitOptimised(int n) {
        if (n <= 1)
            return n;

        int first = 0 ;
        int second = 1;
        int current = 1;
        for (int i = 1; i < n ; i++) {
            current = (first + second) % 10;
            first = second % 10;
            second = current;
        }
        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitOptimised(n);
        System.out.println(c);
    }
}

