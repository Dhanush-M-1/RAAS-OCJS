import java.util.*;
public class Meeting
{

public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);

int a=sc.nextInt();
int b=sc.nextInt();
int l=Math.abs(a-b);
int n=l/2;

if(l%2==0)
{
System.out.println(n*(n+1));
}else
System.out.println(n*(n+1)+(n+1));

}
}