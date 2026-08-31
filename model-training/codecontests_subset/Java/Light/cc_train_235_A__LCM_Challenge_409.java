import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C146 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i = n;
        long mx = 1;
        while(i >= 1) {
            int j = i;
            while(j >= 1) {
                if(gcd(j, i) == 1) {
                    int k = j;
                    if((long)i * j * k < mx) break;
                    while(k >= 1) {
                        if(gcd(k, j) == 1 && gcd(i, k) == 1) {
                            mx = Math.max(mx, (long)i * j * k);
                            break;
                        }
                        k--;
                    }
                }
                j--;
            }
            i--;
        }
        System.out.println(mx);
    }
    public static long gcd(long a, long b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
}
