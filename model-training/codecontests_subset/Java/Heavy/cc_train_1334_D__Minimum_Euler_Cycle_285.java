
import java.util.Scanner;

public class Minimum_eularC_ycle {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			long n = s.nextLong();
			long l = s.nextLong();
			long r = s.nextLong();
			long k = 1;
			long sum = 0;
			while (true && k < n) {
				sum += 2 * (n - k);
				k++;
				if (sum >= l) {
					k--;
					sum-=2 * (n - k);
					break;
				}

			}

			
			while (sum < r && k <= n) {
				long sub = 1 + k;
				for (int i = 1; i <= 2 * (n - k) && sum < r ; i++) {
					sum++;

					if (sum >= l) {
						if (i % 2 == 1) {
							System.out.print(k + " ");
						} else {
							System.out.print(sub + " ");
						}
						
					}
					if(i%2==0)
						sub++;

				}
				k++;
			}
			if(sum+1==r)
				System.out.print(1+" ");
			System.out.println();
		}
	}
}
