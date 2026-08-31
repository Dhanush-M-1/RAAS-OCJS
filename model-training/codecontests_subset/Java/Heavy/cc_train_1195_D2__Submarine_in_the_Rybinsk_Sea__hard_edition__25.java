import java.io.*;
import java.util.*;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        long n = Integer.parseInt(reader.readLine());
        int[] array = new int[(int)n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; ++i){
            array[i] = Integer.parseInt(st.nextToken());
        }
        int MOD = 998244353;
        long[] degr = new long[20];
        degr[0] = 1;
        for(int i = 1; i <= 19; ++i){
            degr[i] = degr[i-1] * 10;
            degr[i]%=MOD;
        }
        long[] lens = new long[11];
        long[] lens2 = new long[(int)n];
        for(int i = 0; i < n; ++i){
            int len = 0;
            int cop = array[i];
            while (cop > 0){
                ++len;
                cop/=10;
            }
            lens[len]++;
            lens2[i] = len;
        }
        long sum = 0;
        for(int i = 0; i < n; ++i){
            int len = 1;
            long num = array[i];
            while (num > 0){
                long counter = 0;
                for(int j = len; j < 11; ++j){
                    counter += lens[j];
                }
                sum = (sum + ((((num % 10) * degr[len * 2 - 1])) % MOD) * counter) % MOD;
                sum = (sum + ((((num % 10) * degr[len * 2 - 2])) % MOD) * counter) % MOD;
                for(int j = 1; j < len; ++j){
                    sum = (sum + (((degr[j + len - 1] * (num % 10)) % MOD) * lens[j] * 2) % MOD)%MOD;
                }
                num/=10;
                ++len;
            }
        }
        System.out.println(sum);
    }
}