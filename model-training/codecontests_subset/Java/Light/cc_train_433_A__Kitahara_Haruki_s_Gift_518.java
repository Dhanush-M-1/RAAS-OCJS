import java.util.Scanner;

import java.util.ArrayList;



public class Main {

	public static void main(String[] args) {

		Scanner pew = new Scanner(System.in);
			
		int n = pew.nextInt();
		
		int s1 = 0;
		int s2 = 0;
		
		for(int i = 0 ; i<n; i++){
			int k = pew.nextInt();
			
			if (k == 100) s1++;
			else s2++;
			
		}
		System.out.println((s1%2==0 && s2%2 == 0)||(s1%2 ==0 && (s1>1) && s2%2 == 1) ? "YES" : "NO");
		
	}
}