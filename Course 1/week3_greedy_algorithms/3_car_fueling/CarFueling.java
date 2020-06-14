import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, ArrayList<Integer> stops) {

        int refils = 0;
        int currentpos = 0;
        int nextpos=0;

        stops.add(dist);
        stops.add(0,0);
        while(stops.get(currentpos)+tank<dist) {
            currentpos = nextpos;
            while(nextpos < stops.size() - 1 && stops.get(nextpos + 1)  <= stops.get(currentpos) + tank)
                nextpos++;

            if(stops.get(currentpos) + tank < dist)
                refils++;
            if(nextpos == currentpos)
                return -1;
        }

        return refils;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        //int[] stops = new int[n];
        ArrayList<Integer> stops = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stops.add(scanner.nextInt());
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
