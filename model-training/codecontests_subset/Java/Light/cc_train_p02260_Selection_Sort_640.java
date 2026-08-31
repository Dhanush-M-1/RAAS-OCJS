import java.util.*;

public class Main {
	public static void main(String[] args) {
		ALDS1_2_B();
	}
        
	public static void ALDS1_2_B() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int countAns = 0;
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			int minj = i;
			for(int j = i; j < n; j++) {
				if(a[j] < a[minj]) {
					minj = j;
				}
			}
			if(minj != i) {
				int temp = a[i];
				a[i] = a[minj];
				a[minj] = temp;
				countAns++;
			}
		}

		for(int i = 0; i < n; i++) {
			System.out.print(a[i]);
			if(i != n - 1)
				System.out.print(" ");
		}
		System.out.println();
		System.out.println(countAns);
	}
}
