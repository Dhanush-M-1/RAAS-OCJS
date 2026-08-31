import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import static java.lang.System.*;
public class A
{
public static void main(String args[])throws Exception
{
     Scanner sc=new Scanner(in);
     String s=sc.nextLine();
     String a="",b="";
     int i;
     for( i=0;i<s.length();i++)
     {
          if(s.charAt(i)==' ')break;
          else
          a=a+s.charAt(i);
     }
     
     b=s.substring(i+1);
     int n=sc.nextInt();
     out.println(a + " " + b);
     s=sc.nextLine();
     int j;
     for(i=0;i<n;i++)
     {
          s=sc.nextLine();
          String c="",d="";
          for( j=0;j<s.length();j++)
     {
          if(s.charAt(j)==' ')break;
          else
          c=c+s.charAt(j);
     }
     
     d=s.substring(j+1);
     if(a.compareTo(c)==0)
     {
     a=d;     
     }
     else if(b.compareTo(c)==0)
     {
         b=d; 
     }
     
     out.println(a + " " + b);
     
     }
     
     
}
     }