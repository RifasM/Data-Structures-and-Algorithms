import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int count = 0;
        if(stops.length <= 0 || (stops[stops.length-1] + tank < dist))
            return -1;
/*
        for(int i = 0 ; i<stops.length-1; i++)
            if(stops[i+1] - stops[i] > tank)
                return -1;*/

        int current = 0;
        int nextPos = 0;
        ArrayList<Integer> locations = new ArrayList<Integer>();
        for(int stop : stops){
            if(stop < current + tank)
                continue;
            else if(current + tank == stop) {
                locations.add(stop);
                current = stop;
            }
            else{
                for(int i = stop; i > current; i--)
                    if(Arrays.binarySearch(stops, i) > 0){
                        current = i;
                        count++;
                        dist -= i;
                        break;
                    }
            }
        }

        if(locations.get(locations.size()-1) + tank >= dist)
            return locations.size();
        else
            return -1;
/*
        int cur = 0;
        int pos = cur + tank;
        while(dist>=0){
            if(Arrays.binarySearch(stops, pos) > 0) {
                cur = pos;
                count++;
                dist -= cur;
            }
            else{
                for(int i = pos; i > cur; i--)
                    if(Arrays.binarySearch(stops, i) > 0){
                        cur = i;
                        count++;
                        dist -= i;
                        break;
                    }
            }
            pos = cur + tank;
        }*/
        //return count;
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
