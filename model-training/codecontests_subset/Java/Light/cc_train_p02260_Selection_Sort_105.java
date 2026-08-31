import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int count = 0;
		int[] A = new int[n];

		for(int i=0;i<n;i++) {
			A[i]=scan.nextInt();
		}

		for(int i = 0; i<n;i++) {
			int min = i;
			for(int j=i;j<n;j++) {
				if(A[j]<A[min]) {
					min = j;
				}
			}
			if(min!=i) {
				int temp = A[i];
				A[i] = A[min];
				A[min] = temp;
				count++;
			}

		}
		for(int i = 0; i < n; i++) {
			if(i==0) {
				System.out.print(A[i]);
			}
			else {
				System.out.print(" " + A[i]);
			}
		}
		System.out.println();
		System.out.println(count);
		scan.close();
	}
}
