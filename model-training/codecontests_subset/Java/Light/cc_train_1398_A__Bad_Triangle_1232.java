import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    for(int z=0;z<t;z++)
    {
      int n=sc.nextInt();
      long a[]=new long[n];
      for(int i=0;i<n;i++)
      a[i]=sc.nextLong();
      if(a[n-1]>=a[0]+a[1])
      {
        System.out.print("1 2 ");
        System.out.println(n);
      }
      else
      System.out.println(-1);
    }
  }
}