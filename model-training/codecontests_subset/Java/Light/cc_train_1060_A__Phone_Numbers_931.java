import java.util.*;
public class Main
{
public static void main(String args[])
{
Scanner ob=new Scanner(System.in);
int n=ob.nextInt(),k=0;
String a=ob.next();
for(int i=0;i<n;i++)
if(a.charAt(i)=='8')
k++;
System.out.println(Math.min(k,(int)(n/11)));
}}