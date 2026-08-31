import java.io.*;
import java.util.*;
public class good_String{
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        long n;
        n = scan.nextLong();
        if(n%6 == 0)
            n -= 1;
        long val = 1;
        if(n==1)
            val = 1;
        else if(n == 2)
            val = 2;
        else if(n == 3)
            val = 6;
        else {
            if (n % 2 == 0)
                val = n * (n - 1) * (n - 3);
            else
                val = n * (n - 1) * (n - 2);
        }
        System.out.println(val);
    }
}