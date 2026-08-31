import java.util.*;
public class C{
    public static void main(String [] args){
        final Scanner s = new Scanner(System.in);
        final int n = s.nextInt();
        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; ++i){
            final long a = s.nextLong();
            sum += a;
            max = Math.max(max, a);
        }
        final long res = Math.max(max, (sum + n - 2)/(n - 1));
        System.out.println(res);
        s.close();
    }
}
