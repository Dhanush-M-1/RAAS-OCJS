import java.util.Scanner;

public class rev1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();

		int max = 0;
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		for (int i = 0; i < n; i++) {
			if (k%arr[i]== 0&&max<arr[i]) {
				max=arr[i];
			}
			}
		
		System.out.println(k/max);
	}

}
