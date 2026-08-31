
import java.math.BigInteger;
import java.util.*;

public class E1195D {

    static long MOD = 998244353L;
    static long calc(long a, int d) {  // fail at 1,000,000,000
        BigInteger answer = new BigInteger("0");
        
        long upper = 1;
        for (int i= 1; i <=d; i++)
            upper *= 10;
        
        long upper_d = a /upper;            // digits above "d"
        answer = answer.add(BigInteger.valueOf( 2L * upper_d * upper * upper));// will be moved up and add twice
        
        long lower_d = a % upper;           // 1 to "d" 
        long power_100 = 1;
        for (int i = 1; i <= d; i++ ) {
            long t2 = lower_d % 10;         // each digit
            lower_d /= 10;
            answer = answer.add(BigInteger.valueOf(10L *t2 + 1L * t2 ).multiply(BigInteger.valueOf(power_100)));
            power_100 *= 100;
        }
        return (answer.mod(BigInteger.valueOf(MOD)).longValue());
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [] n_c = new long [n]; // number of digits of this number
        long[] n_d = new long[11];  //num in digits
        long[][] numbers = new long[11][n];

        for (int i = 0; i < n; i++) {
            numbers[0][i] = sc.nextInt();
            long temp = numbers[0][i];            
            // find number of digits
            for (int j = 1; j <= 10; j++) {

                if (temp < 10) {
                    n_d[j]++;
                    n_c[i] = j;
                    break;
                } else {
                    temp /= 10;
                }
            }
            
            // prepare all the numbers
            for (int j= 1; j<= n_c[i]; j++) {
                numbers[j][i] = calc(numbers[0][i], j);
            }

        }
        
        long answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j= 1; j< n_c[i]; j++) {
                answer += n_d[j] * numbers[j][i];
                answer %= MOD;
            }
            for (long j= n_c[i]; j<=10; j++) {
                answer += n_d[(int) j] * numbers[(int) n_c[i]][i];
                answer %= MOD;
            }
        }        
        System.out.println(answer % MOD);        
    }
}
