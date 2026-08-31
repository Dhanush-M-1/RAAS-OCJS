import java.io.*;
import java.lang.*;
import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=Math.abs(a-b);
        //int sum=1;
        if(c==1)
        System.out.println(c);
        else
        {
                int h=c/2;
                int d=c-h;
                int k=(h*(h+1)/2)+(d*(d+1)/2);
                System.out.println(k);
            
        }
    }
}