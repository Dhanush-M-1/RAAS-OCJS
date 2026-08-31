import java.util.*;
public class q938b {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		final int end = 1000000;
		final int mid = 500000;
		int a[] = new int[10000001];
		int max = 1;
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if(a[i] > mid) {
				a[i] = end-a[i];
				if(a[i] > max) {
					max = a[i];
				}
			}
			else if(a[i] > max) {
				max = a[i]-1;
			}
		}
		System.out.println(max);
		sc.close();
	}
	
}
