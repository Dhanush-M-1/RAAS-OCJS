import java.util.Scanner;
import java.math.*;


public class solution {
  public static void main (String[] args) {

      Scanner in = new Scanner (System.in);

      int n = in.nextInt();
      String s = in.next();
      String temp = "";
      int maxx = 0, count = 0;
      char a, b;

      for (int i = 0; i < s.length() - 1; i++) {
        for (int j = 0; j < s.length() - 1; j++) {
            if (s.charAt(i) == s.charAt(j)  && s.charAt(i+1) == s.charAt(j+1)) {
               count++;
            }
        }
        if (count > maxx) {
           maxx = count;
           temp = s.charAt(i) + "" + s.charAt(i+1) + "";
         }
         count = 0;
      }

      System.out.println (temp);
    }
}
