import java.util.Scanner;
public class Main {
	private static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		SelectionSort(a);
		
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if(i != a.length-1) {
				System.out.print(" ");
			}
		}
		System.out.println("\n" + count);
	}
	
	public static int[] SelectionSort(int[] a) {
		for(int i = 0; i < a.length; i++) {
			int minj = i;
			for(int j = i+1; j < a.length; j++) {
				if(a[j] < a[minj]) {
					minj = j;
				}
			}
			if(minj != i) {
				int tmp = a[i];
				a[i] = a[minj];
				a[minj] = tmp;
				count++;
			}
		}
		return a;
	}

}

