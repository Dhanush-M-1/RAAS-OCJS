import java.util.*;
import static java.lang.Math.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		// 入力
		int n = sc.nextInt();
		int[][][] f = new int[n][5][2];
		for(int i = 0; i < n ; i++){
		    for(int j = 0; j < 5 ; j++){
		        f[i][j][0] = sc.nextInt();
		        f[i][j][1] = sc.nextInt();
		    }
		}
		long[][] p = new long[n][11];
		for(int i = 0; i < n ; i++){
		    for(int j = 0; j < 11 ; j++){
		        p[i][j] = sc.nextLong();
		    }
		}
		
		// 計算
		long result = Long.MIN_VALUE;
		for(int i = 1; i < 1<<10 ; i++){
		    int[] cnt = new int[n];
		    for(int j = 0; j < 10; j++){
		        int youbi = j/2;
		        int ampm = j%2;
		        if((i>>j & 1) == 1){
		            for(int k = 0; k < n; k++){
		                if(f[k][youbi][ampm] == 1) cnt[k]++;
		            }
		        }
		    }
		    long temp = 0;
		    for(int l = 0; l < n; l++){
		        temp += p[l][cnt[l]];
		    }
		    result = max(result, temp);
		}
		
		// 出力
		System.out.println(result);
	}
}
