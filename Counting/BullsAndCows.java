package Counting;

public class BullsAndCows {
  public static String getHint(String secret, String guess){
    if(secret.length() != guess.length()) return "";

    int bulls = 0, cows = 0;
    int freq[] = new int[10];

    int i = 0;
    while(i < guess.length()){
      char s = secret.charAt(i);
      char g = guess.charAt(i);

      if(s == g) bulls++;
      else{
        if(freq[s-'0'] < 0) cows++;

        if(freq[g-'0'] > 0) cows++;

        freq[s-'0']++;
        freq[g-'0']--;
      }
      i++;
    }

    return Integer.toString(bulls)+"A"+Integer.toString(cows)+"B";
  }
  public static String getHint2(String secret, String guess){
    if(secret.length() != guess.length()) return "";
    int bulls = 0, cows = 0;

    int f1[] = new int[10];
    int f2[] = new int[10];

    for(int i=0; i<secret.length(); i++){
      char s = secret.charAt(i);
      char g = guess.charAt(i);

      if(s == g) bulls++;
      else{
        f1[s - '0']++;
        f2[g - '0']++;
      }
    }

    for(int i=0; i<10; i++){
      cows += Math.min(f1[i], f2[i]);
    }

    return Integer.toString(bulls)+"A"+Integer.toString(cows)+"B";
  }
  public static void main(String[] args) {
    String secret = "1801";
    String guess = "0810";
    System.out.println(getHint(secret, guess));
    System.out.println(getHint2(secret, guess));
  }
}
