import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int count = 0;
        if(stops.length <= 0 || (stops[stops.length-1] + tank < dist))
            return -1;
        for(int i = 0 ; i<stops.length-1; i++){
            if(stops[i+1] - stops[i] > tank)
                return -1;
        }
        int cur = 0;
        int pos = cur + tank;
        while(dist>=0){
            if(cur > dist)
                break;
            else if(Arrays.binarySearch(stops, pos) > 0) {
                cur = pos;
                count++;
                dist -= cur;
            }
            else{
                for(int i = cur+tank-1; i > cur; i--)
                    if(Arrays.binarySearch(stops, i) > 0){
                        cur = i;
                        count++;
                        dist -= i;
                        break;
                    }
            }
            pos = cur + tank;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int[] stops = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
