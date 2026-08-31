import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String [] argv) {
        Scanner scanner = new Scanner(System.in);
        int n, k;
        n = scanner.nextInt();
        k = scanner.nextInt();
        ArrayList<Long> T10 = new ArrayList<Long>();
        ArrayList<Long> T01 = new ArrayList<Long>();
        ArrayList<Long> T11 = new ArrayList<Long>();
        for(int i = 0; i < n; i++) {
            long t;
            int a, b;
            t = scanner.nextLong();
            a = scanner.nextInt();
            b = scanner.nextInt();
            if(a == 1 && b == 1) {
                T11.add(t);
            } else if(a == 1) {
                T10.add(t);
            } else if(b == 1) {
                T01.add(t);
            }
        }
        T01.sort(Long::compareTo);
        T10.sort(Long::compareTo);
        T11.sort(Long::compareTo);
        if(T01.size() + T11.size() < k || T10.size() + T11.size() < k) {
            System.out.println(-1);
            return;
        }
        long [] preSum01 = new long[T01.size()+1];
        long [] preSum10 = new long[T10.size()+1];
        long [] preSum11 = new long[T11.size()+1];

        preSum01[0] = 0;
        for(int i = 1; i < preSum01.length; i++){
            preSum01[i] = preSum01[i-1] + T01.get(i-1);
        }
        preSum10[0] = 0;
        for(int i = 1; i < preSum10.length; i++) {
            preSum10[i] = preSum10[i-1] + T10.get(i-1);
        }
        preSum11[0] = 0;
        for(int i = 1; i < preSum11.length; i++) {
            preSum11[i] = preSum11[i-1] + T11.get(i-1);
        }
        int boundary = Math.min(T01.size(), T10.size());
        long sum = 2000000000L;
        for(int i = Math.max(0, k - boundary); i <= Math.min(k, T11.size()); i++) {
            long l = preSum11[i] + preSum01[k - i] + preSum10[k - i];
            if(l < sum) {
                sum = l;
            }
        }
        System.out.println(sum);
    }

}
