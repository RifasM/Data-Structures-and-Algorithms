import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int ten = m / 10;
        m = m % 10;
        int five = m / 5;
        m = m % 5;
        return m + five + ten;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

