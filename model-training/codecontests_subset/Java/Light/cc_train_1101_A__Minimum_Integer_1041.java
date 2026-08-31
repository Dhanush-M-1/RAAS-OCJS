


import java.util.Scanner;

public class MinimumInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
        long l = sc.nextLong();
        long r = sc.nextLong();
        long d = sc.nextLong();
        if(d<l || r<d)
                System.out.println(d);
        else{
            long ans = r/d;
            System.out.println(d*(ans+1));  
        }
        }
    }
    
}
