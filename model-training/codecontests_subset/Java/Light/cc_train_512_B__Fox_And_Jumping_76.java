import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liqiu on 2/4/15.
 */
public class D {
    static long gcd(long a, long b ){
        if( b == 0 ) return a;
        return gcd(b, a % b );
    }
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int n =  cin.nextInt();
        long[] c = new long[n];
        long[] l = new long[n];
        for(int i = 0; i < n; ++i) l[i] = cin.nextLong();
        for(int i = 0; i < n; ++i) c[i] = cin.nextLong();
        HashMap<Long, Long> dp = new HashMap<Long, Long>();
        for(int i = 0; i < n; ++i){
            HashMap<Long, Long> tmp = new HashMap<Long, Long>();
            tmp.putAll(dp);
            for(Map.Entry<Long, Long> entry: tmp.entrySet() ){
                long a = entry.getKey();
                long sum = entry.getValue();
                long factor = gcd(a, l[i] );

                long res = dp.containsKey( factor ) ? Math.min(dp.get(factor), sum + c[i] ): sum + c[i];
                dp.put(factor, res );
            }
            if( !dp.containsKey(l[i] ) ) dp.put(l[i], c[i]);
            else dp.put( l[i], Math.min(dp.get(l[i]), c[i]) );
        }
        if( dp.containsKey(1L)) System.out.println(dp.get(1L) );
        else System.out.println( -1 );
    }
}
