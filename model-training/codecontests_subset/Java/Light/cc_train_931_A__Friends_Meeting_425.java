import java.util.*;
import java.io.*;
import java.math.*;
public class codeforces
{
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int min=1000000009;
        for(int i=1;i<=2000;i++)
        {
           min=Math.min(min,Math.abs((Math.abs(i-a))*(Math.abs(i-a)+1)/2+Math.abs(Math.abs(i-b)*(Math.abs(i-b)+1)/2)));
        }
        System.out.println(min);
    }
}