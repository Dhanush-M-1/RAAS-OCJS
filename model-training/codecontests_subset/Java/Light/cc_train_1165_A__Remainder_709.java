import java.io.*;
import java.util.*;
import java.lang.*;
import java.lang.Math;

public class Main
{
    public static void main(String[] args)
    {
    Scanner sc = new Scanner(System.in);
    int ans = 0;
    int k = sc.nextInt();
    int x = sc.nextInt();
    int y = sc.nextInt();
    String num = sc.next();
    int i = 0;
//     int m = (int)Math.pow(10,x);
//     int n = (int)Math.pow(10,y);
//     String o = Integer.toString(m);
//     String p = Integer.toString(n);
//   int i =0;
//     int sum = m+n;
//     String su = Integer.toString(sum);
    StringBuilder su = new StringBuilder("");
    for(i=0;i<x+1;i++)
    {
        if(i==x-y || i==0)
        su.append('1');
        else
        su.append('0');
    }
  //  System.out.println(su);
    for(i=1;i<x+1;i++)
    {
    //    System.out.println(su.charAt(i));
    //    System.out.print(num.charAt(k-x+i-1));
    if(su.charAt(i) != num.charAt(k-x+i-1))
    {
        
        ans = ans+1;    
    }
    }
    System.out.println(ans);
    }
}