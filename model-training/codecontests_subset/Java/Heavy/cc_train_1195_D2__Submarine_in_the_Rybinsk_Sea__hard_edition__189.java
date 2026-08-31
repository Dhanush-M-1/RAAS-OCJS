import java.util.*;
import java.math.*;
public class Solution{
    public void solve(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int [] counts = new int[11];
        int [] alen = new int[n];
        int [][] digits = new int[n][];
        for(int i = 0; i < n; i++){
            int len = getLength(arr[i]);
            counts[len]++;
            alen[i] = len;
            int temp = arr[i];
            int pos = 1;
            digits[i] = new int[len+1];
            while(temp > 0){
                int rem = temp % 10;
                temp /= 10;
                digits[i][pos++] = rem;
            }
        }

        long ans = 0;
        int mod = 998244353;

        for(int i = 0; i < n; i++){
            int num = arr[i];
            int numLen = alen[i];
            for(int j = 1; j < 11; j++){
                int count = counts[j];
                if(count == 0) continue;
                long val = 0;
                int tempLen = numLen;
                int k = j;
                k = Math.min(k, tempLen);
                long cur = 0;
                int diff = tempLen - j;
                if(diff > 0){
                    int pow = numLen - diff;
                    cur = (num / (int)Math.pow(10, pow));
                    tempLen = Math.min(tempLen, j);
                }
                while(tempLen > 0){
                    cur *= 100;
                    cur %= mod;
                    cur += digits[i][tempLen--];
                }
                val += cur;
                cur = 0;
                tempLen = numLen;
                k = j;
                diff = tempLen - k;
                if(diff > 0){
                    int pow = numLen - diff;
                    cur = (num / (int)Math.pow(10, pow));
                    tempLen = Math.min(tempLen, k);
                }
                k = Math.min(k, tempLen);
                while(k-- > 0){
                    cur *= 10;
                    cur %= mod;
                    cur += digits[i][tempLen--];
                    cur *= 10;
                    cur %= mod;
                }
                val += cur;
                val %= mod;
                val = (val * count) % mod;
                ans = (ans + val) % mod;
            }
        }
        System.out.println(ans);
    }
    public int getLength(int i){
        int len = 0;
        while(i > 0){
            len++;
            i /= 10;
        }
        return len;
    }
    public static void main(String [] args){
        new Solution().solve();
    }
}