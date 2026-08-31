import java.util.Arrays;
import java.util.Scanner;
 
public class R424D {
 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		long p = scan.nextLong();
		long[] pos = new long[n];
		long[] key = new long[k];
		for(int i = 0; i < n; i++){
			pos[i] = scan.nextLong();
		}
		for(int i = 0; i < k; i++){
			key[i] = scan.nextLong();
		}
		Arrays.sort(pos);
		Arrays.sort(key);
		long min = Long.MAX_VALUE;
		long[] d = new long[n];
		int number = k-n+1;
		long max = 0;
		for(int i = 0; i < n; i++){
			d[i] = Math.abs(pos[i]-key[i])+Math.abs(key[i]-p);
			max = Math.max(max, d[i]);
		}
		min = Math.min(min, max);
		for(int i = 1; i < number; i++){
			max = 0;
			for(int j = 0; j < n; j++){
				d[j] = Math.abs(pos[j]-key[i+j])+Math.abs(key[i+j]-p);
				max = Math.max(max, d[j]);
			}
			min = Math.min(min, max);
		}
		System.out.println(min);
	}
}