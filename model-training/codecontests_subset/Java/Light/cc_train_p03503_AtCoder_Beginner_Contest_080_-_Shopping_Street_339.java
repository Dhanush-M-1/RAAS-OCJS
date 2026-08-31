
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}



	public void run() {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int f[][] = new int[n][10];
		for(int i=0; i<n; i++) {
			for(int j=0; j<10; j++) {
				f[i][j]=sc.nextInt();
			}
		}
		int p[][] = new int[n][11];
		for(int i=0; i<n; i++) {
			for(int j=0; j<11; j++) {
				p[i][j]=sc.nextInt();
			}
		}
		int ans = Integer.MIN_VALUE;
		for(int i=1; i<(1<<10); i++) {
			int sum=0;
			for(int j=0; j<n; j++) {
				int c=0;
				for(int k=0; k<10; k++) {
					if(f[j][k]==1 && ((i>>k)&1)==1) {
						c++;
					}
				}
				sum+=p[j][c];
			}
			ans = Math.max(ans, sum);
		}
		System.out.println(ans);
		sc.close();
	}

}
