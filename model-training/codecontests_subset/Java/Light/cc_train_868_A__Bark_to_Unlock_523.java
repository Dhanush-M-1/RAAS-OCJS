import java.util.*;
public class Unlock
{
public static void main(String args[])
{
Scanner e=new Scanner(System.in);
String s=e.nextLine();
int n=e.nextInt();
e.nextLine();
//char c1=s.charAt(0);
//char c2=s.
int f1=0,f2=0;
String a[]=new String[n];
for(int i=0;i<n;i++)
a[i]=e.nextLine();
for(int i=0;i<n;i++)
{
if(a[i].charAt(0)==s.charAt(0) && a[i].charAt(1)==s.charAt(1))
{
f1=1;
f2=1;
}
if(a[i].charAt(0)==s.charAt(1))
f1=1;
if(a[i].charAt(1)==s.charAt(0))
f2=1;
}
if(f1==1 && f2==1)
System.out.println("YES");
else
System.out.println("NO");
}
}