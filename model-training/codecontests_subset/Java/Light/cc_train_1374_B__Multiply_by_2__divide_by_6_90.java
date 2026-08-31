import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    while(t-->0)
    {
      int n = s.nextInt();
      int a=0,b=0;
      while(n%2==0)
      {
        n=n/2;
        a++;
      }
      while(n%3==0)
      {
        n=n/3;
        b++;
      }
      if(n!=1)
      {
        System.out.println("-1");
        continue;
      }
      if(a>b)
      {
        System.out.println("-1");
        continue;
      }
      if(a==b)
      {
        System.out.println(a);
        continue;
      }
      if(a<b)
      {
        int k = 2*b-a;
        System.out.println(k);
        continue;
      }
    }
  }
}