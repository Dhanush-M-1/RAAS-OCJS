import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    while(n-->0)
    {
      int a = s.nextInt();
      int b = s.nextInt();
      int c = s.nextInt();
      if(c<a)
      System.out.println(c);
      else
      {
        a=b/c;
        System.out.println(c*(a+1));
      }
    }
  }
}