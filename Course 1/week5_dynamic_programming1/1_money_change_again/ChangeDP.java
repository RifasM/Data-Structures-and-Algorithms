import java.util.Arrays;
import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] denominations = {1, 3, 4};
        int[] cache = new int[m+1];
        Arrays.fill(cache, Integer.MAX_VALUE);

        cache[0] = 0;

        for (int i = 1; i <= m; i++)
            for (int value : denominations)
                if (i - value >= 0)
                    cache[i] = Math.min(cache[i], cache[i - value] + 1);


        return cache[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

