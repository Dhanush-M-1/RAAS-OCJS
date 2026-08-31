import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumSum function below.

    static long max(long[] a, int b)
    {
            long x=0;
            for(int i=0;i<=b;i++){
                if(a[i]>=0)
                  x+=a[i];
            }
            return x;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       int t=scanner.nextInt();
        for(int i=0;i<t;i++){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            int c=scanner.nextInt();
            int sum=0;
            if(b-c/2>=0){
                sum+=((c/2)*2);
                sum+=(c/2);
                //System.out.println(sum);
                b-=c/2;
            }
            else {
                sum += b;
                sum+=b*2;
                b=0;
            }
            if(b>0){
                if(a-b/2>=0){
                    sum+=((b/2)*2);
                    sum+=(b/2);
                    a-=b/2;
                }
                else {
                    sum+=a;
                    sum+=a*2;
                }
            }
            System.out.println(sum);
       }
    }
 }

