import java.io.*;
import java.util.*;
import java.lang.*;
public class xyz
{
public static void main(String args[])throws IOException
{
Scanner s = new Scanner(System.in);
int t=s.nextInt();
int i;
for(i=0;i<t;i++)
{
int a=s.nextInt();
int b=s.nextInt();
int n=s.nextInt();
n=n%3;
n+=1;
if(n==1)
{
System.out.println(a);
}
else if(n==2)
{
System.out.println(b);
}
else
{
System.out.println(a^b);
}
}
s.close();
}
}