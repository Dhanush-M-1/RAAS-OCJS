import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int open[]= new int[n];
		int p[][] = new int[n][11];
		
		for(int i=0;i<n;i++){
			
			int a = 0;
			for(int j=0;j<10;j++){
				int in = sc.nextInt();
				a <<=1; a|=in;
			}
			open[i] = a;
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<11;j++){
				p[i][j] = sc.nextInt();
			}
		}
		
		int ans = (int)-1e9;
		for(int i=1;i<(1<<10);i++){
			int tmp = 0;
			for(int j=0;j<n;j++){
				tmp += p[j][sameBit(i, open[j])];
			}
			ans = Math.max(ans, tmp);
		}
		System.out.println(ans);
	}
	static int sameBit(int a, int b){
		int c = a&b;
		int cnt =0;
		while(c>0){
			cnt += c&1;
			c>>=1;
		}
		
		return cnt;
	}
}
