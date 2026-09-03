package sliding_window;

import java.util.HashMap;

public class FruitIntoBasket {
    public static int totalFruit(int[] fruits) {
        int maxlength = 0;
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int low=0, high=0;

        while(high < n){
            map.put(fruits[high], map.getOrDefault(fruits[high], 0) + 1);
            if(map.size() > 2){
                while(map.size() > 2){
                    map.put(fruits[low], map.get(fruits[low]) - 1);
                    if(map.get(fruits[low]) == 0){
                        map.remove(fruits[low]);
                    }
                    low++;
                }
            }
            maxlength = Math.max(maxlength, high-low+1);
            high++;
        }

        return maxlength;
    }
    public static void main(String[] args) {
        int fruits[] = {1,2,1};
        System.out.println(totalFruit(fruits));
    }
}
