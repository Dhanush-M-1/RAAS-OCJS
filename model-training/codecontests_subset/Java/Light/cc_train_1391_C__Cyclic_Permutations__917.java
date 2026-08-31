import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long mod = (long) (Math.pow(10,9)+7);
        long n = sc.nextLong();
        long val1 = 1; long pow = 1;
        for(long i=2L;i<=n;i++){
            val1 = (val1*i)%mod;
        }
        for(long i=1L;i<n;i++){
            pow = (pow*2)%mod;
        }
        long tmpAns = val1-pow;
        System.out.println(tmpAns > 0 ? tmpAns : mod + tmpAns);
    }
}
