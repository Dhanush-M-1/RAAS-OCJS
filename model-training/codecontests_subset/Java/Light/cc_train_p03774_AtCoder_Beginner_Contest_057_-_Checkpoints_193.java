import java.util.*;	
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m= sc.nextInt();
		int[] x = new int[n];int[] y = new int[n];
		int[] mx = new int[m];int[] my = new int[m];
		for(int i = 0;i < n;i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		for(int i = 0;i < m;i++) {
			mx[i] = sc.nextInt();
			my[i] = sc.nextInt();
		}
		int max, a, ans;
		for(int i = 0;i < n;i++) {
			max = Math.abs(x[i]-mx[0])+Math.abs(y[i]-my[0]);
			ans = 1;
			for(int k = 1;k < m;k++) {
				a = Math.abs(x[i]-mx[k])+Math.abs(y[i]-my[k]);
				if(max > a) {
					max = a;
					ans = k+1;
				}
			}
			System.out.println(ans);
		}
	}

}
