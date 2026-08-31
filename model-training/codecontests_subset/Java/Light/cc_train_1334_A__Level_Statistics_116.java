import java.util.Scanner;
import java.util.Arrays;

public class A{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int z=0; z<t; z++) {
			int n = sc.nextInt();
			int[] p = new int[n];
			int[] c = new int[n];
			for(int y=0; y<n; y++) {
				p[y] = sc.nextInt();
				c[y] = sc.nextInt();
			}
			boolean result = true;
			for(int i=0; i<n; i++) {
				if(i>0) {
					int te = c[i] - c[i-1];
					if(te<0 || te>p[i]-p[i-1]) {
						result = false;
						break;
						
					}
				}else {
					if(p[i]<c[i]) {
						result = false;
						break;
					}
				}
			}
			System.out.println(result?"YES":"NO");
		}
		
		sc.close();
	}
}