import java.util.Scanner;
public class Main
{
    public static void main(String args[])throws Exception
    {
       Scanner sc=new Scanner(System.in);
       int a=sc.nextInt();
       int b=sc.nextInt();
       int c=sc.nextInt();
       int d=sc.nextInt();
       int e=sc.nextInt();
       int t=(int)Math.ceil(((a+b+c+d+e)/(5.0)));
       int x=(a+b+c+d+e)/5;
       if(t==x && t!=0)
           System.out.print(t);
       else
           System.out.print(-1);
    }
}