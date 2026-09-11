package greedy_algo;

import java.util.ArrayList;
import java.util.List;

public class FractionalKnapsack {
    static class Item{
        int value;
        int weight;
        double ratio;

        Item(int value, int weight){
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }
    public static double fractionalKnapsack(int[] val, int[] wt, int capacity){
        int n = val.length;
        List<Item> items = new ArrayList<>();
        for(int i=0; i<n; i++){
            items.add(new Item(val[i], wt[i]));
        }

        items.sort((a, b) -> Double.compare(b.ratio, a.ratio));

        double res = 0.0;

        for(Item item : items){
            if(item.weight <= capacity){
                capacity -= item.weight;
                res += item.value;
            }else{
                res += item.ratio * capacity;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int val[] = {60, 100, 120}; 
        int wt[] = {10, 20, 30};
        int capacity = 50;

        System.out.println(fractionalKnapsack(val, wt, capacity));
    }
}
