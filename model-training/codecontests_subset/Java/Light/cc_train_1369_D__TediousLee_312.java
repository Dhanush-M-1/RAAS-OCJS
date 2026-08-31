import java.util.*;

public class Main {

    private static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long[] arr = new long[2000001];
        arr[3] = 4;

        for(int i=4;i<=2000000;i++) {
            arr[i] = (2*arr[i-2]) + arr[i-1];
            arr[i] = (arr[i]+(i % 3 == 0 ? 4 : 0)) % MOD;
        }

        int t = scan.nextInt();

        while (t-- >0 ) {
            int n = scan.nextInt();

            System.out.println(arr[n]);
        }





    }

}

