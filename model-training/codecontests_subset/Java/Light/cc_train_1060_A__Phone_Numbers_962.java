import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
 
import static java.lang.Math.*;

public class DB
{
       public static void main(String args[])
       {
              Scanner sc=new Scanner(System.in);
              long n=sc.nextLong();
              String s=sc.next();
              long ans=0;
              for(int i=0;i<s.length();i++)
              {
                     char ch=s.charAt(i);
                     if(ch=='8')
                            ans++;
              }
              ans=Math.min(ans,(n/11));
              System.out.print(ans);
       }
}
