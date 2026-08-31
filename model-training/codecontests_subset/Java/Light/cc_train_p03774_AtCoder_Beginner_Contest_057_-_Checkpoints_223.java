import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		int n = stdIn.nextInt(); //n人の学生
		int m = stdIn.nextInt(); //m個のチェックポイント
		
		int[] x = new int[n]; //x座標
		int[] y = new int[n]; //y座標
		
		for(int i = 0; i < n; i++) {
			x[i] = stdIn.nextInt();
			y[i] = stdIn.nextInt();
		}
		
		int[] c = new int[m];
		int[] d = new int[m];
		
		for(int i = 0; i < m; i++) {
			c[i] = stdIn.nextInt();
			d[i] = stdIn.nextInt();
		}
		
		
		for(int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE; 
			int checkpoint = 0;
			
			for(int j = 0; j < m; j++) {
				
				int dis = Math.abs(x[i]-c[j])+Math.abs(y[i]-d[j]);
				
				if(dis < min) {
					min = dis;
					checkpoint = j+1;
				}
				
			}
			System.out.println(checkpoint);
			
		}
		
	}

}
