import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] f = new String[n];
		Arrays.fill(f, "");
		int[][]p = new int[n][11];
		for(int i = 0; i < n; i++) for(int j = 0; j < 10; j++) f[i] += sc.next();
		for(int i = 0; i< n; i++) for(int j = 0; j < 11; j++) p[i][j] = sc.nextInt();
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < 1024; i++){
			int[] count = new int[n];
			Arrays.fill(count, 0);
			for(int j = 0; j < f.length; j++){
				int num = Integer.parseInt(f[j], 2);
				String s = String.format("%11s", Integer.toBinaryString(num & i));
				s = s.replaceAll(" ", "0");
				for(int k = 0; k < 11; k++) if(s.charAt(k) == '1') count[j]++;
			}

			int v = 0;
			for(int j = 0; j < n; j++){
				int c = count[j];
				v += p[j][c];
			}
			if(max < v) max = v;
		}
		System.out.println(max);
	}
}