import java.util.Scanner;

class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			int n = sc.nextInt();
			if (n == 0) return;
			String a[] = new String[n];
			int count = 0;
			for (int i = 0; i < n; i++) {
				a[i] = sc.next();
			}
			loop: for (int i = 0; i < n; i++) {
				int sum = 0, k = i;
				while(sum < 5) {
					sum += a[k++].length();
					//System.out.println(sum);
					if (sum > 5) continue loop;
					if (sum == 5) break;
				}
				sum = 0;
				while(sum < 7) {
					sum += a[k++].length();
					//System.out.println(sum);
					if (sum > 7) continue loop;
					if (sum == 7) break;
				}
				sum = 0;
				while(sum < 5) {
					sum += a[k++].length();
					//System.out.println(sum);
					if (sum > 5) continue loop;
					if (sum == 5) break;
				}
				sum = 0;
				while(sum < 7) {
					sum += a[k++].length();
					//System.out.println(sum);
					if (sum > 7) continue loop;
					if (sum == 7) break;
				}
				sum = 0;
				while(sum < 7) {
					sum += a[k++].length();
					//System.out.println(sum);
					if (sum > 7) continue loop;
					if (sum == 7) break;
				}
				System.out.println(i+1);
				break;
			}
		}
	}
}
