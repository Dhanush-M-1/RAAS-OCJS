
import java.util.Scanner;
public class NewYearCandles
{
   public static void main(String args[])
   {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int k=sc.nextInt();
       int time=0;
       while(n>=k)
       {
           time+=(n/k)*k;
           n=(n/k)+(n%k);
        }
        System.out.print(time+n);
    }
}