
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		int[] b = new int[n];
		for(int i = 0; i < n; i++){
			b[i] = sc.nextInt();
		}
		int[] c = new int[n - 1];
		for(int i = 0; i < n - 1; i++){
			c[i] = sc.nextInt();
		}
		int sum = 0;
		int before = -10;
		for(int i = 0; i < n; i++){
			int num = a[i] - 1;
			sum += b[num];
			if(before == num - 1){
				sum += c[num - 1];
			}
			before = num;
		}
		System.out.println(sum);
	}
}
