import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class knapsack{
    Double cost;
    int value, weight, index;

    public knapsack(int index, int value, int weight){
        this.index = index;
        this.value = value;
        this.weight = weight;
        this.cost = (double)value / (double)weight;
    }
}

class knapsackCompare implements Comparator<knapsack>{

    @Override
    public int compare(knapsack o1, knapsack o2) {
        return o2.cost.compareTo(o1.cost);
    }
}

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        knapsack[] sack = new knapsack[values.length];
        for(int i = 0 ; i < values.length ; i++)
            sack[i] = new knapsack(i, values[i], weights[i]);
        knapsackCompare compare = new knapsackCompare();
        Arrays.sort(sack, compare);
        for(knapsack a : sack){
            int wt = a.weight;
            int vl = a.value;
            if(capacity - wt >= 0){
                capacity -= wt;
                value += vl;
            }
            else {
                double fraction = (double) capacity / (double) wt;
                value += fraction*vl;
                break;
            }
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
