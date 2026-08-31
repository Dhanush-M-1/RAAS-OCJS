import java.util.Scanner;
public class Main
{
  public static void main(String[]args)
  {
    Scanner sc=new Scanner(System.in);
    int sum=0;
    for(int i=0;i<5;i++)
    {
      sum=sum+sc.nextInt();
    }
    if(sum%5==0 && sum !=0)
    {
      System.out.println(sum/5);
    }
    else
    {
      System.out.println(-1);
    }
  }
}