import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int a[] = new int [n];
		for (int i=0; i<n ; i++) {
			a[i] = scan.nextInt();
		}
		
		int t[] = new int [k];
		int j = k, l = 0;
		while(j != 0) {
			if(k%j == 0) {
				t[l] = j;
				l++;
			}
			j--;
		}
		int r [] = new int [l];
		for(int i = 0 ; i<l ; i++)
			r[i] = t[i];
		
		int hour = 0, temp = 0;
		for (int i = 0; i < r.length && temp == 0; i++) {
			for (int m = a.length-1; m >= 0; m--) {
				if(r[i] == a[m]) {
					hour = k/a[m];
					temp = 1;
					break;
				}
			}
		}
		System.out.println(hour);
	}
	
}