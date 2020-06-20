import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int x) {
        Arrays.sort(a);
        int left = 0, right = a.length;
        while(left < right){
            int mid = (left + right)/2;
            if(a[mid] == x)
                return mid;
            else if(a[mid] > x)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    static void stressTest(){
        Random random = new Random();
        boolean OK = true;
        int bounds = 10;

        while(OK) {
            int n = random.nextInt(bounds);
            int m = random.nextInt(bounds);
            String linear = "";
            String binary = "";
            System.out.println("Value of n: "+n);
            System.out.println("Value of m: "+m);
            int[] a1 = new int[n];

            for(int i = 0; i < n; i++)
                a1[i] = random.nextInt(bounds);

            Arrays.sort(a1);
            System.out.print("Array: ");
            for(int a : a1)
                System.out.print(a + " ");

            System.out.print("\nKeys: ");
            for(int i = 0; i < m; i++) {
                int rand = random.nextInt(bounds);
                linear += linearSearch(a1, rand) + " ";
                binary += binarySearch(a1, rand) + " ";
                System.out.print(rand+" ");
            }
            System.out.println("\n\tLinear: "+linear);
            System.out.println("\tBinary: "+binary);

            if(linear.equals(binary))
                System.out.println("--OK--");
            else
                OK = false;
        }
    }

    public static void main(String[] args) {
        //stressTest();
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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
