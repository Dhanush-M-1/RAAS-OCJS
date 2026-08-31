import java.util.*;
import java.io.*;
 
public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			int prefEnd = 0;
			int sufEnd = n-1;
			for(int i = 0; i < n; i++) {
				if(a[i] < i) {
					break;
				} else {
					prefEnd = i;
				}
			}
			for(int i = n-1; i >= 0; i--) {
				if(a[i] < (n-1-i)) {
					break;
				} else {
					sufEnd = i;
				}
			}
			System.out.println((sufEnd <= prefEnd) ? "Yes" : "No");
		}
	}
}