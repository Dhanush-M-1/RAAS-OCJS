import java.util.Scanner;
public class Main371B
{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    int a=sc.nextInt();
    int b=sc.nextInt();
    int c=gcd(a,b);
    int d=(a/c);
    int e=(b/c);
    int ans=0;
    while(d%2==0)
    {
      d/=2;
      ans++;
    }
    while(d%3==0)
    {
      d/=3;
      ans++;
    }
    while(d%5==0)
    {
      d/=5;
      ans++;
    }
    if(d!=1)
      System.out.println(-1);
    else
    {
      while(e!=1)
      {
        if(e%2==0)
        {
          e/=2;
          ans++;
        }
        else if(e%3==0)
        {
          e/=3;
          ans++;
        }
        else if(e%5==0)
        {
          e/=5;
          ans++;
        }
        else
          break;
      }
      if(e!=1)
        System.out.println(-1);
      else
        System.out.println(ans);
    }
  }
  public static int gcd(int a,int b)
  {
    if(a==0) return b;
    else return gcd(b%a,a);
  }
  
}
    
    