import java.math.*;
import java.util.*;
import java.io.*;

public class Solve {


    public static long f(long n){
        if(n==1) return 1;
        return n*f(n-1);
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for(int i=0;i<t;i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int res = 0;

            int mi = Math.min(b,c/2);
            res += mi*3;
            b -= mi;
            res += Math.min(a,b/2)*3;


            System.out.println(res);
        }
    }

    
}
