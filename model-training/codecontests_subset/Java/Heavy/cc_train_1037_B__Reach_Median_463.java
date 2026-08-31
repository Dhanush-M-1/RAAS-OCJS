import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class B3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int s = in.nextInt();
		int[] v = new int[n];
		for(int i = 0; i < n; i++) v[i] = in.nextInt();
		shuffle(v);
		Arrays.sort(v);
		long r = Math.abs(v[n / 2] - s); 
		int i = 0;
		while(i < n / 2) {
			if(v[i] > s) r += v[i] - s;
			i++;
		}
		i = n / 2 + 1;
		while(i < n) {
			if(v[i] >= s) break;
			r += s - v[i];
			i++;
		}
		System.out.println(r);
		in.close();
	}
	
	static void shuffle(int[] a) { // to avoid worst case
		Random r = new Random();
		int j;
		for (int i = a.length - 1; i > 0; i--) {
			j = r.nextInt(i);
			a[i] = a[i] ^ a[j];
			a[j] = a[i] ^ a[j];
			a[i] = a[i] ^ a[j];
		}
	}
}
