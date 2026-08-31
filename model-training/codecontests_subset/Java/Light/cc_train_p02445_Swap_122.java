import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner src = new Scanner(System.in);

		int n = src.nextInt();

		//配列array
		int[] array = new int[n];
		
		for (int i=0; i<n; i++)
			array[i] = src.nextInt();

		int q = src.nextInt();

		for(int i=0; i<q; i++) {

			int b = src.nextInt();
			int e = src.nextInt();
			int t = src.nextInt();

			for(int k=0; k<(e - b); k++) {
				
				int tmp = array[b+k];
				array[b+k] = array[t+k];
				array[t+k] = tmp;
	
//					System.out.print(array[k] + "debug");
			}
		}
		for(int i=0; i<n-1; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(array[n-1]);
	}
}
