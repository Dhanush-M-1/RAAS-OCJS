import java.util.*;
import java.lang.*;
public class TwoG
{
public static void main(String args[])
{
Scanner e=new Scanner(System.in);
int n=e.nextInt();
e.nextLine();
String s=e.nextLine();
s+=" ";
String s1="",r="";
int t=0,f=0;
for(int i=0;i<s.length()-2;i++)
{
t=0;
s1=s.substring(i,i+2);
//System.out.println(s1);
for(int j=i;j<s.length()-1;j++)
{
if(s1.equals(s.substring(j,j+2))==true)
t++;
}
if(f<=t)
{
f=t;
r=s1;
//System.out.println(s1);
}
}
System.out.println(r);
}
}