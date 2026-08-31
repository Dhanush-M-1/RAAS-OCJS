import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Main
{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int z=s.nextInt();
        while(z-->0)
        {
        int a=s.nextInt(),b=s.nextInt(),n=s.nextInt(),ans=0;
        if(n%3==1)
        ans=b;
        else if(n%3==2)
        ans=a^b;
        else
        ans=a;
        System.out.println(ans);
        }
    }
}