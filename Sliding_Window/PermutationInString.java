package sliding_window;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        int have[] = new int[26];
        int needed[] = new int[26];

        for(char ch : s1.toCharArray()){
            needed[ch-'a']++;
        }

        int low = 0;
        for(int high=0; high<s2.length(); high++){
            have[s2.charAt(high)-'a']++;
            while(high-low+1 == s1.length()){
                if(match(have, needed))
                    return true;
                have[s2.charAt(low)-'a']--;
                low++;
            }
        }
        return false;
    }
    private static boolean match(int[] have, int[] needed){
        for(int i=0; i<26; i++){
            if(have[i] != needed[i])
                return false;
        }

        return true;
    } 
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
        String st1 = "ab", st2 = "eidboaoo";
        System.out.println(checkInclusion(st1, st2));
    }
}
