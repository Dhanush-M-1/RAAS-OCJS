import java.math.BigInteger;
import java.util.Scanner;


public class Main {

    /**
     * @param args
     */
    static int []a = new int[100005]; 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=0; i<n; ++i)
            a[i] = in.nextInt();
        BigInteger lb = BigInteger.ZERO, rb = new BigInteger("9000000000000000000");
        while(lb.add(BigInteger.ONE).compareTo(rb) < 0)
        {
            BigInteger mid = lb.add(rb).divide(BigInteger.valueOf(2));
            boolean ok = true;
            BigInteger t = BigInteger.ZERO;
            for(int i=0; i<n; ++i)
            {
                if(mid.compareTo(BigInteger.valueOf(a[i])) < 0)
                {
                    ok = false;
                    break;
                }
                t = t.add(mid.subtract(BigInteger.valueOf(a[i])));
            }
            if(ok && t.compareTo(mid) >= 0)
                rb = mid;
            else
                lb = mid;
        }
        System.out.println(rb);
    }

}
