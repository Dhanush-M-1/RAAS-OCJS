import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner t=new Scanner(System.in);
        long a=0,b=0,c=0,n;
       n=t.nextLong();
       for(int i=0;i<n;i++)
           a+=t.nextLong();
       for(int i=0;i<n-1;i++)
           b+=t.nextLong();
       for(int i=0;i<n-2;i++)
           c+=t.nextLong();
       System.out.println(a-b);
       System.out.println(b-c);
    }
}