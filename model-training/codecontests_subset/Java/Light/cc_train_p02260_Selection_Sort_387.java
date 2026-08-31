import java.util.Scanner;

class Main {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] a = new int[n];
	
		for(int i = 0; i < n; i++){
			a[i] = scan.nextInt();
		}
	
		boolean flag = true;
		int swap;
		int count = 0;
		int min;

		for(int i = 0; i < n; i++){
			min = i;
			for(int j = i; j < n; j++){
				if(a[j] < a[min]){
					min = j;
				}
			}
			if(a[i] != a[min]){
				swap = a[i];
				a[i] = a[min];
				a[min] = swap;
				count++;
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(a[i]);

			if(i != n-1) System.out.print(" ");
		}
		System.out.println();
		System.out.println(count);
	}
}