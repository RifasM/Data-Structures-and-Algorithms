import java.util.*;

class digit implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o1.substring(o1.length()-1).compareTo(o2.substring(o2.length()-1));
    }
}

public class LargestNumber {
    private static String largestNumber(String[] a) {
        Arrays.sort(a, new digit());
        String result = "";
        for (int i = a.length-1; i >= 0; i--)
            result += a[i];
        return result;
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

