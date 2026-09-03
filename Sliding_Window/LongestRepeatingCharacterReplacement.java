package sliding_window;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int maxlen = Integer.MIN_VALUE;

        int low = 0;
        int map[] = new int[26];
        int n = s.length();
        int max_count = 0;

        for(int high=0; high<n; high++){
            char ch = s.charAt(high);
            map[ch-'A']++;
            max_count = Math.max(map[ch-'A'], max_count);
            int len = high-low+1;
            int diff = len - max_count;

            while(diff > k){
                char c = s.charAt(low);
                map[c-'A']--;
                low++;
                len = high-low+1;
                max_count = Math.max(max_count, map[c-'A']);
                diff = len - max_count;
            }

            len = high-low+1;
            maxlen = Math.max(maxlen, len);
        }

        return maxlen==Integer.MIN_VALUE? 0 : maxlen;
    }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
}
