import java.io.*;
import java.util.*;
import java.math.*;

public class Q1 {


    public static long solver(Scanner sc) {
        long t = sc.nextLong();
        return t;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t=0;t<test;t++)
        {
            int n = sc.nextInt();
            int maxa = 0;
            int maxb = 0;
            boolean flag = true;

            for(int i = 0;i< n; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                if(b>a){
                    flag = false;
                }
                if(maxb>maxa){
                    flag = false;
                }
                if((a-maxa)<(b-maxb)){
                    flag = false;
                }
                if(a==maxa && b!=maxb){
                    flag = false;
                }
                if(a<maxa){
                    flag = false;
                }
                if(b<maxb){
                    flag = false;
                }
                maxa = a;
                maxb = b;

            }
            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }
}
