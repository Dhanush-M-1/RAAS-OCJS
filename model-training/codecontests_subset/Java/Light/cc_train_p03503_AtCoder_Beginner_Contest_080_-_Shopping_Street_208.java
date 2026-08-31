import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] f = new String[n];
		Arrays.fill(f, "");
		int[][] p = new int[n][11];
		for(int i=0;i<n;i++) {
			for(int j=0;j<10;j++) {
				f[i] += sc.nextInt();
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<11;j++) {
				p[i][j] = sc.nextInt();
			}
		}
		
		
		int max = Integer.MIN_VALUE;
		for(int i=1;i<1024;i++) {
			String s = Integer.toString(i, 2);
			while(s.length()<10) {
				s = "0" + s;
			}
			
			int profit = 0;
			for(int j=0;j<n;j++) {
				int c = 0;
				for(int k=0;k<10;k++) {
					if(s.charAt(k)=='1' && f[j].charAt(k)=='1')
						c++;
				}
				profit+=p[j][c];
			}
			
			if(profit>max) {
				max = profit;
			}
		}
		
		System.out.println(max);
	}
}
