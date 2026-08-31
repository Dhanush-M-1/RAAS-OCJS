import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		Scanner scan = new Scanner (System.in);
		int n = scan.nextInt();
		int data[] = new int[n];
		int min, count = 0, a;
		
		for (int i = 0; i < n; i++) {
			data[i] = scan.nextInt();
		}
		scan.close();
		
		for (int i = 0; i < n - 1; i++) {
			min = i;
			for ( int j = i + 1; j < n; j++) {
				if (data[min] > data[j]) min = j;
			}
			if ( i != min) {
				a = data[i];
				data[i] = data[min];
				data[min] = a;
				count++;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				System.out.println(data[i]);
				System.out.println(count);
			} else {
				System.out.print(data[i] + " ");
			}
		}
	}
}

