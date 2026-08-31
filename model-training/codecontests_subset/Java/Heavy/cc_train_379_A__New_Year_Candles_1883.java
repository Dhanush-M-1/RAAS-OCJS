import java.lang.*;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.regex.*;



public final class CP16
 {

    public static void println(Object line){System.out.println(line);}
    public static void print(Object line){System.out.print(line);}
   

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int b = sc.nextInt();
        int op=0;int y=0;

        while(x>0)
        {

            op+=x;
            y+=x;
            x = (int)Math.floor(y/b);
            y = y%b;

        }

    
        print(op);

    }

    
}
