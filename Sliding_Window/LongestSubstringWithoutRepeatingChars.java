package sliding_window;

public class LongestSubstringWithoutRepeatingChars {
    public static int lengthOfLongestSubstring(String s) {
        int maxlen = 0;

        int low = 0;
        int map[] = new int[128];
        int n = s.length();
        char str[] = s.toCharArray();

        for(int high=0; high<n; high++){
            map[str[high]]++;

            while(map[str[high]] > 1){
                map[str[low]]--;
                low++;
            }

            int len = high-low+1;
            maxlen = Math.max(maxlen, len);
        }

        return maxlen;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
