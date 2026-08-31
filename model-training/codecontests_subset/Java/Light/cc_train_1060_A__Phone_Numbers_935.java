import java.util.Scanner;
public class main
{
public static void main(String[]args)
{
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
String s=sc.next();
if(n<11)
System.out.println("0");
else
{
int eight=0;
for(int i=0;i<n;i++)
{
if(s.charAt(i)=='8')
eight++;
}
int len=n/11;
if(len==eight)
{
System.out.println(len);
}
else if(len<eight)
{
System.out.println(len);
}
else
{
System.out.println(eight);
}
}
}}