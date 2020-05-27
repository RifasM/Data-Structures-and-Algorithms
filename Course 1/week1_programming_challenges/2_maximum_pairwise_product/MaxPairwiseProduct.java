import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static int getMaxPairwiseProduct(int[] numbers) {
        int max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                    numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }

    static long getMaxPairwiseProductFaster(int[] numbers){
        Arrays.sort(numbers);
        int len = numbers.length;
        if(len == 2)
            return numbers[0] * numbers[1];
        return numbers[len-1] * numbers[len-2];
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
            long slow = getMaxPairwiseProduct(numbers);
            long fast = getMaxPairwiseProductFaster(numbers);
            System.out.println("\n" + slow + " " + fast);
            if (slow == fast)
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
