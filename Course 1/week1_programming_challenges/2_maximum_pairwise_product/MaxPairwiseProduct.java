import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static BigInteger getMaxPairwiseProduct(int[] numbers) {
        int max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                    numbers[first] * numbers[second]);
            }
        }

        return BigInteger.valueOf(max_product);
    }

    static BigInteger getMaxPairwiseProductFaster(int[] numbers){
        Arrays.sort(numbers);
        int len = numbers.length;
        if(len == 2)
            return BigInteger.valueOf(numbers[0]).multiply(BigInteger.valueOf(numbers[1]));
        return BigInteger.valueOf(numbers[len - 2]).multiply(BigInteger.valueOf(numbers[len - 1]));
    }

    static void stressTest(){
        Random rand = new Random();
        boolean OK = true;
        while(OK) {
            int n = rand.nextInt(1000);
            if(n == 0 || n == 1)
                continue;
            System.out.println(n);
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++)
                numbers[i] = rand.nextInt(10000);
            for(long number : numbers)
                System.out.print(number + " ");
            BigInteger slow = getMaxPairwiseProduct(numbers);
            BigInteger fast = getMaxPairwiseProductFaster(numbers);
            System.out.println("\n" + slow + " " + fast);
            if (slow.equals(fast))
                System.out.println("-- PASS --\n");
            else
                OK = false;
        }
    }

    public static void main(String[] args) {
        //stressTest();
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFaster(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
