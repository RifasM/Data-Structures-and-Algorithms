import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }

  private static BigInteger cal_fib(int n){
    if(n <= 1)
      return BigInteger.valueOf(n);

    BigInteger[] arr = new BigInteger[n];
    arr[0] = BigInteger.ZERO;
    arr[1] = BigInteger.ONE;

    for(int i = 2; i<n ; i++)
      arr[i] = arr[i - 1].add(arr[i - 2]);

    return arr[n-1];
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(cal_fib(n));
  }
}
