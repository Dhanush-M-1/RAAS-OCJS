import java.util.*;
import java.lang.*;
public class Main {
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    int n = s.nextInt();
    String a = s.next();
    int p=0;
    for(int i=0;i<n;i++)
    {
      if(a.charAt(i)=='8')
      p++;
    }
    n=n/11;
    System.out.println(Math.min(n,p));
  }
}