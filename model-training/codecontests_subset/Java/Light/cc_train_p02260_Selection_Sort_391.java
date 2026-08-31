import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		int[] ints = new int[n];
		for (int i=0; i<n; i++) {
			ints[i] = sc.nextInt();
		}

		int count = 0;
		for (int i=0; i<n; i++) {
			int minj = i;
			boolean flag = false;
			for (int j=i; j<n; j++) {
				if (ints[j] < ints[minj]) {
					minj = j;
					flag = true;
				}
			}
			if (flag==true) {
				int temp = ints[i];
				ints[i] = ints[minj];
				ints[minj] = temp;
				count++;
			}
		}

		for (int i=0; i<n; i++) {
			System.out.print(ints[i]);
			if (i!=n-1) {System.out.print(" ");}
		}
		System.out.println();
		System.out.println(count);
	}
}			
