import java.util.Scanner;

public class Round666D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextLong();
		}
		if(n==1) {
		System.out.println(1 + " " + 1);
		System.out.println(0);
		System.out.println(1 + " " + 1);
		System.out.println(0);
		System.out.println(1 + " " + 1);
		System.out.println(-arr[0]);
		}
		else {
			System.out.println(1 + " " + 1);
			System.out.println(-arr[0]);
			arr[0] = 0;
			System.out.println(1 + " " + n);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(-arr[i]*n +" ");
			}
			System.out.println();
			System.out.println(2 + " " + n);
			for (int i = 1; i < arr.length; i++) {
				System.out.print(arr[i]*(n-1) + " ");
			}
		}

	}

}