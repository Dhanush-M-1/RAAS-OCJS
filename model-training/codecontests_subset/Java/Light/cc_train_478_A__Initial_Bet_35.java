import java.io.*;
import java.util.*;
import java.math.*;
public class cf
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        n+=in.nextInt();
        n+=in.nextInt();
        n+=in.nextInt();
        n+=in.nextInt();
        if(n%5==0&&n!=0)
            System.out.println(n/5);
        else
            System.out.println(-1);    
           
    }
}