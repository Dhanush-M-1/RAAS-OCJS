import java.util.Scanner;
class Main
{
  public static boolean isPrime(int x)
  {
    if(x==2)
    {
      return true;
    }
    if((x<2)||(x%2==0))
    {
      return false;
    }
    int i=3;
    while(i<=Math.sqrt(x))
    {
      if(x%i==0)
      {
        return false;
      }
      i=i+2;
    }
    return true;
  }
  public static void main(String[]av)
  {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] num=new int[n];
    for(int i=0;i<n;i++)
    {
      num[i]=sc.nextInt();
    }
    int count=0;
    for(int i=0;i<n;i++)
    {
      if(isPrime(num[i]))
      {
        count++;
      }
    }
    System.out.println(count);
  }
}

