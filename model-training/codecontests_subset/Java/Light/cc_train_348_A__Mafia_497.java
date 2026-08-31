import java.util.Arrays;
import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextLong();
        }
        
        
        //do binary search
        long s = 0;
        long end = 10000000000l;
        
        long rounds= -1;
        while(end>=s){
            long mid = (s+end)/2;
            boolean c = check(mid,a);
            if(c){
                rounds = mid;
                end = mid -1;
            }else{
                s = mid + 1;
            }
        }
        System.out.println(rounds);

    }
    public static boolean check (long rounds, long [] a){
        
        long sum =0;
        for (int i = 0; i < a.length; i++) {
            if(a[i]>rounds){
                return false;
            }else{
                sum+=(rounds-a[i]);
            }
        }
        if(sum<rounds){
            return false;
        }
        return true;
    }
}
