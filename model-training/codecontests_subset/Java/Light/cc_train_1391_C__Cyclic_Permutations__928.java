import java.io.*;
import java.util.HashSet;

public class Space2 {

    static int mod = 1000000007;

    public static long factorial(int n){
        long ans = 1;
        for(int i = 2; i<=n; i++){
            ans = (ans*i)%mod;
        }
        return ans;
    }

    public static long power(int n){
        if(n == 0) return 1;
        if(n == 1) return 2;
        if((n&1) == 1){
            return (2*power(n-1))%mod;
        }
        else return (power(n/2)*power(n/2))%mod;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long f = factorial(n);
        long pow = power(n-1);
        long ans = f-pow;
        System.out.println((ans+mod)%mod);
    }
}
