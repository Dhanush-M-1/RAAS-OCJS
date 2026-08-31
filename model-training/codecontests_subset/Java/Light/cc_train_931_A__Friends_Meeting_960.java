import java.util.Scanner;
public class main
{
public static void main(String[]args)
{
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int m=sc.nextInt();
int x=(n+m)/2;
int f=Math.abs(x-n);
int s=Math.abs(x-m);
int sum1=(f*(f+1))/2;
int sum2=(s*(s+1))/2;
int res=sum1+sum2;
System.out.println(res);
}
}