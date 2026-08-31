import java.io.*;
import java.util.*;
import java.lang.*;
public class Help
{

public static void main(String args[])
{

Scanner sc=new Scanner(System.in);
String b=sc.next();
int n=(b.length()/2)+1;
int a[]=new int[n];
int j=0;
for(int i=0;i<b.length();)
{
a[j++]=b.charAt(i)-'0';
i=i+2;
}
Arrays.sort(a);
System.out.print(a[0]);
for(int i=1;i<n;i++)
{
System.out.print("+"+a[i]);
}
}
}