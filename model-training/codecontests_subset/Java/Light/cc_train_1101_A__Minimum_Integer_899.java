import java.util.*;
public class A
{
public static void main(String ar[])
{
Scanner s=new Scanner(System.in);
int t=s.nextInt();
for(int i=0;i<t;i++)
{
int l=s.nextInt();
int r=s.nextInt();
int d=s.nextInt();
if(d<l)
System.out.println(d);
else
{
int a=r/d;
a=(a+1)*d;
System.out.println(a);
}
}
System.out.println();
}
}