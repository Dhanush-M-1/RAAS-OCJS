
import java.util.Scanner;


public class Main {
    private static final int mod = (int)1e9+7;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try{

        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        
        int n = Integer.parseInt(input1);
        
        String str1[] = input2.split(" ");
        int xs[] = new int[n];
        
        for(int i=0; i<str1.length; i++){
            xs[i] = Integer.parseInt(str1[i].trim());
        }
        
        int[] pow2 = new int[n+1];
        pow2[0] = 1;
        for(int i = 1; i < pow2.length; i++) pow2[i] = (int)(pow2[i-1] * 2L % mod);
        
        int[] dp = new int[1<<20];
        for(int x : xs) {
            dp[x]++;
        }
        
        
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 1 << 20; j++) {
                if((j>>>i&1) == 0) {
                    dp[j] += dp[j|1<<i];
                }
            }
        }
        
        long ans = 0;
        for(int i = 0; i < 1 << 20; i++) {
            ans += (1L-Integer.bitCount(i)%2*2) * pow2[dp[i]]%mod;
        }
        
        System.out.println((ans % mod + mod) % mod);
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
