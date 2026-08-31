

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n + 1];
		a[n] = -100;
		int[] b = new int[n];
		int[] c = new int[n];
		
		int An = 0;
	
		
		for(int i = 0; i < n; i ++ ) {
			a[i] = sc.nextInt();
	    }

		for(int i = 0; i < n; i ++ ) {
			b[i] = sc.nextInt();
	    }

		for(int i = 0; i < n - 1; i ++ ) {
			c[i] = sc.nextInt();
	    }
		
		for(int i = 0; i < n; i ++ ) {
			An = An + b[i];
			
			if(a[i+1] == a[i]+1)
				An = An + c[a[i] - 1];

		}
		
		System.out.println(An);



	}

}
