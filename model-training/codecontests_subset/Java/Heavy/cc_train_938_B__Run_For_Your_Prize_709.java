import java.util.*;
import java.io.*;
public class Main 
{
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(System.out,true);
    int n=sc.nextInt();
    int a[]=new int[n+2];
    int i,j,k;
    for(i=1;i<=n;i++)
    a[i]=sc.nextInt();
    a[0]=1;
    a[n+1]=1000000;
    int time1 = 0,time2=0;
    int ans = 10000000;
    for(i=0;i<=n;i++)
    {
      time1 = a[i]-1;
      time2 = 1000000-a[i+1];
      if(ans>max(time1,time2))
      ans = max(time1,time2);
    }
    pw.println(ans);
    sc.close();
  }
  public static int max(int a,int b)
  {
    if(a>b)
    return a;
    else
    return b;
  }
}
