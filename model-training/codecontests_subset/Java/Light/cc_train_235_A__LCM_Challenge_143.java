import java.io.*;
import java.util.*;
import static java.lang.Math.*;
public class Main {
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        } else {
            return gcd(b,a%b);
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        if(n == 1){
            pw.println("1");
        } else {
            if(n == 2){
                pw.println("2");
            } else {
                if( n == 3){
                    pw.println("6");
                } else {
                    if(n%2 == 1){
                        pw.println((long)n*(n-1)*(n-2));
                    } else {
                       if(gcd(n,n-3) == 1){
                           pw.println((long)n*(n-1)*(n-3));
                       } else {
                           pw.println((long)(n-3)*(n-1)*(n-2));
                       }
                    }
                }
            }
        }

        pw.close();
    }
}