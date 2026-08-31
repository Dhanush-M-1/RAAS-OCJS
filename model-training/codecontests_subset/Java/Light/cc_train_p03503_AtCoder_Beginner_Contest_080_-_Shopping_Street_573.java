import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int F[][] = new int[N][10];
        int P[][] = new int[N][11];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 10; j++ ){
                F[i][j] = sc.nextInt();
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 11; j++ ){
                P[i][j] = sc.nextInt();
            }
        }
        
        int max = Integer.MIN_VALUE;
        for( int i = 1; i < (1 << 10); i++ ) {
            int count[] = new int[N];
            for( int j = 0; j < N; j++ ) {
                for(int k = 0; k < 10; k++ ) {
                    int bit = (i>>k) & 1;
                    if( bit == 1 && F[j][k] == 1 ) {
                        count[j]++;
                    }
                }
            }
            
            int sum = 0;
            for( int j = 0; j < N; j++ ) {
                sum += P[j][count[j]];
            }
            max = Math.max( max, sum );
        }
        
        System.out.println(max);
    }
}
