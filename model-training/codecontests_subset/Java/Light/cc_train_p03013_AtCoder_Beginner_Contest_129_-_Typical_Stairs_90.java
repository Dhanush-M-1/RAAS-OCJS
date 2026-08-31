import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] b = new boolean[n+1];
        long[] a = new long[n+1];
        long mod = 1_000_000_007;

        for(int i=0; i<m; i++) {
            b[sc.nextInt()] = true;
        }

        a[0] = 1;
        if(!b[1]) a[1] = 1;


        for(int i=2; i<=n; i++) {
            if(b[i]) continue;
            a[i] = a[i-2] + a[i-1];
            a[i] %= mod;
        }

        System.out.println(a[n]);

    }

}
