import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for(int i = 0; i < n; i++) {
			x[i]=sc.nextInt();
			y[i]=sc.nextInt();
		}
		int[] cx = new int[m];
		int[] cy = new int[m];
		for(int i = 0; i < m; i++) {
			cx[i]=sc.nextInt();
			cy[i]=sc.nextInt();
		}//入力終わり
		//一人ずつ取り出し
		for(int i = 0; i < n; i++) {
			int minM = Integer.MAX_VALUE;
			int p = 1;
			for(int j = 0; j < m; j++) {
				if(Math.abs(x[i]-cx[j])+Math.abs(y[i]-cy[j]) < minM) {
					minM = Math.abs(x[i]-cx[j])+Math.abs(y[i]-cy[j]);
					p = j+1;
				}
			}
			System.out.println(p);
		}
	}
}
