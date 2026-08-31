
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}


	public void run() {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		long a[] = new long[n];
		long sum = 0;
		for(int i=0; i<n; i++) {
			a[i]=sc.nextLong();
			a[i]--;
			sum += a[i];
		}
		System.out.println(sum);
		sc.close();
	}


}
