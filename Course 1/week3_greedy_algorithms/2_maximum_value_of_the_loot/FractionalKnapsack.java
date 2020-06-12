import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        double[] cost = new double[values.length];
        for(int i = 0; i < values.length ; i++)
            cost[i] = (double) weights[i] / values[i];
        for(int i = 0 ;i < cost.length-1 ; i++){
            if(cost[i] < cost[i+1]){
                double t = cost[i];
                cost[i] = cost[i+1];
                cost[i+1] = t;
                int y = values[i];
                values[i] = values[i+1];
                values[i+1] = y;
                y = weights[i];
                weights[i] = weights[i+1];
                weights[i+1] = y;
            }
        }
        int i = 0;
        while (capacity >= 0 && i < cost.length){
            if((capacity - weights[i]) >= 0){
                capacity -= weights[i];
                value += values[i];
            }
            else {
                double fraction = (double) capacity / (double) weights[i];
                value += fraction*values[i];
                capacity -= fraction*weights[i];
            }
            i++;
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
