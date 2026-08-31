import java.util.*;
import java.math.RoundingMode;
import java.math.BigDecimal;
 
 
 
public class Main{
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[m];
		int[] d = new int[m];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		for(int i = 0; i < m; i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			int min = 400000001; 
			int ans = 0;
			for(int j = 0; j < m; j++) {
				int dis = Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j]);
				//System.out.println(dis);
				if(min > dis) {
					min = dis;
					ans = j+1;
				}
			}
			System.out.println(ans);
		}
	}
}