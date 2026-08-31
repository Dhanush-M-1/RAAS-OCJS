

import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.next());
		
		int []p = new int [n];
		
		for(int i = 0 ; i < n ;i++) {
			p[i] = Integer.parseInt(sc.next());
		}
		
		int cnt = 0;
		
		for(int i = 0 ; i < n-1 ;i++) {
			
			if(i+1 == n-1) {
				if(p[i] == i+1 || p[i+1] == i+2) {
					cnt++;
					int temp = p[i];
					p[i] = p[i+1];
					p[i+1] = temp;
				} 
			}
			else if(p[i] != i+1) {
				continue;
			}
			
			else {
				cnt++;
				int temp = p[i];
				p[i] = p[i+1];
				p[i+1] = temp;
			}
		}
		System.out.println(cnt);

	}

}
