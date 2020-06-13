import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        if(stops.length <= 0 || (stops[stops.length-1] + tank < dist))
            return -1;

        int current = 0;
        int nextPos;
        ArrayList<Integer> locations = new ArrayList<>();
        for(int i = 0 ; i<stops.length-1 ; i++){
            nextPos = current + tank;
            if(stops[i+1] - stops[i] > tank)
                return -1;
            if(nextPos > stops[i] && nextPos >= stops[i+1] && i!=stops.length-2)
                continue;
            if(nextPos >= stops[i]) {
                locations.add(stops[i]);
                current += stops[i];
            }
        }
        if(locations.get(locations.size()-1) + tank >= dist)
            return locations.size();
        else
            return -1;
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
