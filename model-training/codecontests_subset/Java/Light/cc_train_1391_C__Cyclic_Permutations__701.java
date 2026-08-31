import java.util.Scanner;

public class Main{
    

    static long mod = (int)1e9 + 7;
    public static Scanner scn = new Scanner(System.in);

    public static void solve(){
    
       int n = scn.nextInt();
        long ans = 1;

        for(int i=1; i<=n; i++){
            ans = (ans*i)%mod;
        }

        long twoPow = 1;

        for(int i = 1; i<n; i++){
            twoPow=(twoPow*2)%mod;
        }

        System.out.println((ans-twoPow+mod)%mod);
       
    }

    public static void main(String[] args){
        // int t = scn.nextInt();
        // while(t-->0)
        solve();
    }

     
}