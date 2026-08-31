import java.util.Scanner;

public class Main{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int m = scan.nextInt();

		int[] a = new int[n];
		int[] b = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = scan.nextInt();
			b[i] = scan.nextInt();
		}

		int[] c = new int[m];
		int[] d = new int[m];
		for(int i = 0; i < m; i++){
			c[i] = scan.nextInt();
			d[i] = scan.nextInt();
		}

		int[] min = new int[n];
		for(int i = 0; i < n; i++){
			min[i] = Math.abs(a[i]-c[0]) + Math.abs(b[i]-d[0]);
			int point = 1;
			for(int j = 1; j < m; j++){
				int dis = Math.abs(a[i]-c[j]) + Math.abs(b[i]-d[j]);
				if(min[i] > dis){
					min[i] = dis;
					point = j+1;
				}
			}
			System.out.println(point);
		}
	}
}
