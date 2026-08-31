import java.util.Scanner;

public class BadTriangles {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		  int t = scanner.nextInt();
	        while (t-- > 0) {
	            int n = scanner.nextInt();
	            int[] arr = new int[n];
	            for (int i = 0; i < n; ++i) {
	                arr[i] = scanner.nextInt();
	            }
	            if (arr[0] + arr[1] <= arr[n - 1])
	                System.out.println("1 2 " + n);
	            else
	                System.out.println(-1);
	        }
	    }
	}

