
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int pre = -10;
		int point = 0;
		for(int i =0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		for(int i =0;i<n;i++) {
			b[i] = sc.nextInt();
		}
		for(int i =0;i<n-1;i++) {
			c[i] = sc.nextInt();
		}
		
		for(int a0 : a) {
			a0 -= 1;
			point += b[a0];
			if(a0-1 == pre) {
				point += c[pre];
			}
			pre = a0;
		}
		System.out.println(point);
	}	

}
