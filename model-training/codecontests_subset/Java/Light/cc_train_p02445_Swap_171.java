import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			int n = sc.nextInt();
			long [] array = new long [n];
			for (int i=0; i<n; i++) {
				 array[i] = sc.nextLong();
			}
			int times = sc.nextInt();
			for (int i=0; i<times; i++) {
				int b = sc.nextInt();
				int e = sc.nextInt();
				int t = sc.nextInt();
				for (int k=0; k< e - b; k++) {
					long temp = array[b+k];
					array[b+k] = array[t+k];
					array[t+k] = temp;
				}
			}
			for (int i=0; i<n - 1; i++) System.out.print(array[i] + " ");
			System.out.println(array[n - 1]);
		}
	}
}

