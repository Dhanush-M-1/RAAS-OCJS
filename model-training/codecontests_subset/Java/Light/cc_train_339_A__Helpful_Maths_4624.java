import java.util.*;
import java.io.*;

public class Solution {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

 
    
    String[] s = in.next().split("\\+");
    Arrays.sort(s);

    for (int i = 0; i < s.length; i++)
    {
      System.out.print(s[i]);
      if (i < s.length-1) System.out.print("+");
    }

    

    /*int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int m = in.nextInt();
      System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
    }*/
  }
}
