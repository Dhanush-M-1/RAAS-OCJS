
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int f[][] = new int[n][10];
		int p[][] = new int[n][11];

		for(int i=0; i<n; i++) {
			for(int j=0; j<10; j++) {
				f[i][j]=sc.nextInt();
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<=10; j++) {
				p[i][j]=sc.nextInt();
			}
		}

		long ans = -Long.MAX_VALUE;
		for(int i=1; i<(1<<10); i++) {
			int cnt[] = new int[n];
			for(int j=0; j<10; j++) {
				if(((i>>j)&1)==1) {
					for(int k=0; k<n; k++) {
						if(f[k][j]==1) {
							cnt[k]++;
						}
					}
				}
			}
			long sum = 0;
			for(int j=0; j<n; j++) {
				sum += p[j][cnt[j]];
			}
			ans = Math.max(ans, sum);
		}
		System.out.println(ans);
		sc.close();
	}
}
