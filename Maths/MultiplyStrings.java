package Maths;

public class MultiplyStrings{
  public static String multiplyString(String num1, String num2){
    if(num1.equals("0") || num2.equals("0")) return "0";
    
    int m = num1.length();
    int n = num2.length();

    int res[] = new int[m+n];

    for(int i=m-1; i>=0; i--){
      for(int j=n-1; j>=0; j--){
        int prod = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
        int sum = prod + res[i+j+1];

        res[i+j+1] = sum%10;
        res[i+j] += sum/10;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int num : res){
      sb.append(num);
    }

    //handle 0's at the beginning
    while(sb.length()>0 && sb.charAt(0)=='0'){
      sb.deleteCharAt(0);
    }
    return sb.toString();
  }
  public static void main(String[] args) {
    String num1 = "124";
    String num2 = "256";
    System.out.println(multiplyString(num1, num2));
  }
}