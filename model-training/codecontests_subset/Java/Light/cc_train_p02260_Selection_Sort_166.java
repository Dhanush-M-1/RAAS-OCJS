
//選択ソート
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		int n = stdIn.nextInt();
		int[] a = new int [n];
		int count = 0;
		
		for(int i = 0; i < a.length; i++) {
			a[i] = stdIn.nextInt();
		}
		
		for(int i = 0; i < a.length; i++) {
			int minj = i;
			for(int j = i; j < a.length; j++) {
				if(a[j] < a[minj]) {
					minj = j;
				}
			}
			if(i != minj) {
			int t = a[i];
			a[i] = a[minj];
			a[minj] = t;
			count++;
			}
		}
		
		for(int i = 0; i < a.length - 1; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(a[a.length - 1]);
		System.out.println(count);
	}

}

