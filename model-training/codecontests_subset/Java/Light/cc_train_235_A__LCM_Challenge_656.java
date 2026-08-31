import java.io.*;
import java.util.*;
import java.lang.*;

public class Rextester{
    static int gcd(int a,int b){
        if(a%b==0){
            return b;
        }
        return gcd(b,a%b);
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        long ans = 0;
        if(n==1){
            System.out.println("1");
            return;
        }
        else if(n==2){
            System.out.println("2");
            return;
        }
        if(n%2==0){
            ans = (long)(n-1)*(n-2);
            ans = ans*(n-3);
            long ans2 = (long)n*(n-1);
            ans2 = ans2*(n-3);
            if(gcd(n,n-3)==1){
                System.out.println(Math.max(ans,ans2));
            }
            else{
                System.out.println(ans);
            }
        }
        else{
            ans = (long)n*(n-1);
            ans = ans*(n-2);
            System.out.println(ans);
        }
    }
}