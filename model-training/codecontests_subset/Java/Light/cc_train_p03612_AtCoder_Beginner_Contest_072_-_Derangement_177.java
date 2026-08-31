
import java.util.*;
import java.util.stream.*;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++) a[i]=sc.nextInt();

		long cnt = 0;
		for(int i=0; i<n-1; i++) {
			if(a[i] == i+1) {
				swap(a, i, i+1);
				cnt++;
			}
		}
		if(a[n-1] == n) {
			cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}

	public void swap(int a[], int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
}
