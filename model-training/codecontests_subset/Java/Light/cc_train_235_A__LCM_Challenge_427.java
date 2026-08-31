/**
 *
 * @author Mr_Argus
 */
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[])throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(in.readLine());
        long n = Integer.parseInt(token.nextToken());
        if(n<3){
            System.out.println(n);
        }
        else{
        long a1 = lcm(n*(n-1),n-2);
        long a2 = lcm(n*(n-2),n-1);
        long a3 = lcm((n-1)*(n-2),n);
        long min = 0;
        long max = Long.MIN_VALUE;
        String ans = "";
        int finish = 0;
        if(n>=10)finish = (int)n-10;
        for(int i=(int)n;i>=finish;i--){
            for(int j=i-1;j>=finish;j--){
                for(int k=j-1;k>=finish;k--){
                    a1 = lcm(((long)i)*((long)j),(long)k);
                    a2 = lcm(((long)i)*((long)k),(long)j);
                    a3 = lcm(((long)j)*((long)k),(long)i);
                    min = (Long)Math.min(Math.min(a1, a2), a3);
                    if(max<min){
                        max = min;
                    }
                }
            }
        }
        System.out.println(max);
        }
    }
    public static long gcd (long a, long b) {
	if (b == 0)
            return a;
	else
            return gcd (b, a % b);
    }
    public static long lcm (long a, long b) {
	return a / gcd (a, b) * b;
    }
}