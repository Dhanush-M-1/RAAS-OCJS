import java.util.*;

public class Main{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    String S = sc.next();
    int s = S.length();
    String ans = "NO";
    a:for(int i = 0; i <= s; i++){
      for(int j = i; j <= s; j++){
        String S1 = S.substring(0, i);
        String S2 = S.substring(j, s);
        if((S1+S2).equals("keyence")){
          ans = "YES";
          break a;
        }
      }
    }
    System.out.println(ans);
  }
}