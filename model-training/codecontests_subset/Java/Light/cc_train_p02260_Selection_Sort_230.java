
import java.util.Scanner;

public class Main {
	static int cnt=0;
	public static void main(String[] args) {
		int i;
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(i = 0; i < n; i++) {
        	a[i] = sc.nextInt();
        }
        a = sellect(a, n);
        outPut(a, n);
        System.out.println(cnt);
	}
	
	public static int[] sellect(int[] a, int n) {
		int tmp;
		for(int i = 0; i < n-1; i++){
			boolean flag = false;
			int minj = i;
			for(int j = i+1; j < n; j++) {
				if(a[j] < a[minj]) {
					minj = j;
					flag = true;
				}
			}
			if(flag) cnt++;
			tmp = a[i];
			a[i] = a[minj];
			a[minj] = tmp;
		}
		return a;
	}
	public static void outPut(int[] a, int n) {
		for(int i = 0; i < n-1; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(a[n-1]);
	}
}
