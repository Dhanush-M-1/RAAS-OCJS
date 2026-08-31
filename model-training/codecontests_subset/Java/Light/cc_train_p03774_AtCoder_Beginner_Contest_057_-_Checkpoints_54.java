import java.io.PrintWriter;
import java.util.Scanner;

public class Main{
	static final int MOD = 1000000007;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		//入力
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[m];
		int[] d = new int[m];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		for(int i = 0; i < m; i++){
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		sc.close();

		//処理
		int[] ans = new int[n];
		for(int i = 0; i < n; i++){
			int least = 1000000000;
			int temp = -1;
			for(int j = 0; j < m; j++){
				int len = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
				if(len < least){
					temp = j;
					least = len;
				}
			}
			ans[i] = temp;
		}

		//出力	
		for(int i = 0; i < n; i++){
			out.println(ans[i] + 1);
		}
		out.flush();
	}
}