/*
Find the first duplicate in a array of given elements,
elements of the array are within the size of the array.
*/

import java.util.Scanner;

public class firstDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(calcFirstDuplicate(arr, n));
    }

    private static int calcFirstDuplicate(int[] arr, int n) {
        /*
          Traverse the array once
          Convert the value of index of arr[i] to negative of that value
          So when we arrive at another instance (duplicate) and check the element at that index, it will be -ve
          Thus, that is the first duplicate
         */
        for (int i = 0; i < n; i++) {
            if (arr[Math.abs(arr[i]) - 1] < 0)
                return Math.abs(arr[i]);
            else
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
        }
        return -1;
    }
}