import java.util.Scanner;
public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int i, j, k;
		int n = sc.nextInt();
		int a[] = new int[n];
		
		for(i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		
		selectionsort(n, a);
	}
	public static void selectionsort(int n, int a[]){
		int count = 0;
		for (int i = 0; i <= n - 1; i++){
			int minj = i;
			for(int j = i; j <= n - 1; j++){
				if(a[j] < a[minj]){
					minj = j;
				}
			}
			if(a[i] != a[minj]) count++;
			int temp = a[i];
			a[i] = a[minj];
			a[minj] = temp;
		}
		for(int i = 0; i < n; i++){
			System.out.print(( i == 0 ? "" : " ") + a[i]);
		}
		
		System.out.printf("\n%d\n", count);
	}
}
