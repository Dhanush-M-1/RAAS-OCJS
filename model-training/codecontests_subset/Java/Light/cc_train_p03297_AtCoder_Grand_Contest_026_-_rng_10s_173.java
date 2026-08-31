import java.util.*;
import java.io.*;

public class Main {
    public static long gcd(long x, long y){
        if(x<y) return gcd(y,x);
        if(y==0)return x;
        return gcd(y,x%y);
    }
    public static long buy(long current, long pace, long limit){
        long day = (current-limit)/pace;
        long ans = current-pace*day;
        if(ans>limit)ans-=pace;
        return ans;
    }
    public static long store(long current, long pace, long limit){
        long day = (limit-current)/pace;
        long ans = current+pace*day;
        if(ans<limit) ans+=pace;
        return ans;
    }
    public static boolean solve(long A, long B, long C, long D){
        long g = gcd(B,D);
        return solve_dis(A/g, B/g, C/g - (A%B>C ? 1 : 0), D/g);
    }
    public static boolean solve_dis(long A, long B, long C, long D){
        if(A<B) {
        	//System.out.println("sold out on first day.");
        	return false;
        }
        if(B>D) {
        	//System.out.println("snuke drink too much.");
        	return false;
        }
        
        
        if(B>C+1){
        	//System.out.println("unfortunately sold out.");
        	return false;
        }
        //System.out.println("snuke will buy apple juice forever.");
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t<T;t++) 
            System.out.println(solve(sc.nextLong(),sc.nextLong(),sc.nextLong(),sc.nextLong()) ? "Yes" : "No");
    }
}