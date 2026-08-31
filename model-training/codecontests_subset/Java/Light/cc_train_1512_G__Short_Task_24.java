import java.util.Scanner;

public class ShortTask {
    public static int[] sum = new int[10000002];
    public static int[] result = new int[10000002];
    public static void sieve(){
        for ( int i = 1 ; i <= 10000000 ; i++ ){
            for ( int j = i ; j <= 10000000 ; j += i ){
                sum[j] += i;
                if ( sum[i] <= 10000000 ){
                    if ( result[sum[i]] == 0 ){
                        result[sum[i]] = i;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        sieve();
        while ( t != 0 ){
            int x = scanner.nextInt();
            if ( result[x] == 0 ) System.out.println(-1);
            else System.out.println(result[x]);
            t--;
        }
    }
}
