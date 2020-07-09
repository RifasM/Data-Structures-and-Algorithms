import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A, int i, int sum1, int sum2, int sum3, int TotalSum) {
        if (sum1 > TotalSum / 3 || sum2 > TotalSum / 3 || sum3 > TotalSum / 3) {
            return 0;
        }

        if (i == A.length -1) {
            if (sum1 + A[i] == sum2 && sum2 == sum3) return 1;
            if (sum1 == sum2 + A[i] && sum1 == sum3) return 1;
            if (sum1 == sum3 + A[i] && sum1 == sum2) return 1;
            return 0;
        }
        else {

            int a1 = partition3(A, i+1, sum1 + A[i], sum2, sum3, TotalSum);
            if (a1 == 1) return 1;

            int a2 = partition3(A, i+1, sum1, sum2 + A[i], sum3, TotalSum);
            if (a2 == 1) return 1;

            int a3 = partition3(A, i+1, sum1, sum2, sum3 + A[i], TotalSum);
            if (a3 == 1) return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        int totalSum = Arrays.stream(A).reduce(0, Integer::sum);
        System.out.println(partition3(A,0,0,0,0, totalSum));
    }
}

