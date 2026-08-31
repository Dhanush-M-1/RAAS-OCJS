import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		int n = stdIn.nextInt();
		int[] a = new int[n];
		int i;
		
		for (i = 0; i < n; i++)
			a[i] = stdIn.nextInt();
		
		int count = SelectionSort(a, n);
		
		System.out.print(a[0]);
		for (i = 1; i < n; i++)
			System.out.print(" " + a[i]);
		System.out.println();
		System.out.println(count);
	}
	
	public static int SelectionSort(int[] a, int n) {
		int i, j, minat, t, count = 0;
		for (i = 0; i < n; i++) {
			minat = i;
			for (j = i + 1; j < n; j++)
				if (a[j] < a[minat])
					minat = j;
			if (i != minat) {
				t = a[i];
				a[i] = a[minat];
				a[minat] = t;
				count++;
			}
		}
		return count;
	}
}