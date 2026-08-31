//package pkg195a;

import java.io.IOException;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int a,b,n,z=1;
        a=sc.nextInt();
        b=sc.nextInt();
        n=sc.nextInt();
        while(true)
        {
            if(z*b+n*b>=n*a) break;
            z++;
        }
        System.out.print(z);
    }
}
