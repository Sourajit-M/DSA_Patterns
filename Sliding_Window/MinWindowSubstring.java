package Sliding_Window;

import java.util.HashMap;

public class MinWindowSubstring {
    public static String minWindow(String s, String t) {
        String res = "";
        int have[] = new int[128];
        int needed[] = new int[128];

        for(char ch : t.toCharArray()){
            needed[ch]++;
        }

        int low = 0;
        int start = 0;
        int end = 0;
        int minlen = Integer.MAX_VALUE;

        for(int high=0; high<s.length(); high++){
            have[s.charAt(high)]++;

            while(match(have, needed)){
                int len = high-low+1;
                if(minlen > len){
                    minlen = len;
                    end = high;
                    start = low;
                }
                have[s.charAt(low)]--;
                low++;
            }
        }
        res = s.substring(start, end+1);
        return minlen==Integer.MAX_VALUE? "" : res;
    }
    private static boolean match(int[] have, int[] needed){
        for(int i=0; i<128; i++){
            if(have[i] < needed[i]){
                return false;
            }
        }
        return true;
    }

    public static String minWindowWithHashmap(String s, String t){
        HashMap<Character, Integer> have = new HashMap<>();
        HashMap<Character, Integer> needed = new HashMap<>();
        int minlen = Integer.MAX_VALUE;
        int low = 0;
        int start = 0, end = 0;
        String res = "";

        for(int i=0; i<t.length(); i++){
            needed.put(t.charAt(i), needed.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(int high=0; high<s.length(); high++){
            have.put(s.charAt(high), have.getOrDefault(s.charAt(high), 0) + 1);

            while(match2(have, needed)){
                int len = high - low + 1;
                if(minlen > len){
                    minlen = len;
                    end = high;
                    start = low;
                }
                char ch = s.charAt(low);
                have.put(ch, have.get(ch)-1);
                if(have.get(ch) == 0)
                    have.remove(ch);
                low++;
            }
        }

        res = s.substring(start, end+1);
        return minlen==Integer.MAX_VALUE? "" : res;
    }

    private static boolean match2(HashMap<Character, Integer> have, HashMap<Character, Integer> needed){
        for(char ch : needed.keySet()){
            if(have.getOrDefault(ch, 0) < needed.get(ch)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        // System.out.println(minWindow(s, t));
        System.out.println(minWindowWithHashmap(s, t));
    }
}
