import java.util.*;

class digit implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
    }
}

public class LargestNumber {
    private static String largestNumber(String[] a) {
        Arrays.sort(a, new digit());
        StringBuilder result = new StringBuilder();
        for (int i = a.length-1; i >= 0; i--)
            result.append(a[i]);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

