import java.util.Scanner;

class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int a[] = new int[n];
		for(int i = 0; i < n; i++) a[i] = sc.nextInt();
		
		int chtimes = 0;
		for(int i = 0; i < n; i++) {
			int minj = i;
			for(int j = i; j < n; j++) {
				if(a[j] < a[minj]) {
					minj = j;
				}
			}
			if(i != minj) {
				int tmp = a[i];
				a[i] = a[minj];
				a[minj] = tmp;
				chtimes++;
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(i != 0) System.out.print(" ");
			System.out.print(a[i]);
		}
		System.out.println("\n" + chtimes);
	}
}
