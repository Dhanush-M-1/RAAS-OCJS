import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int n = sc.nextInt();
			int[] A = new int[n];
			for(int i=0;i<n;i++){
				A[i] = sc.nextInt();
			}
			int q = sc.nextInt();

            int buf;
			for(int i=0;i<q;i++) {
				int b = sc.nextInt();
				int e = sc.nextInt();
				int t = sc.nextInt();
				for(int k=0;k<(e-b);k++) {
					buf = A[b+k];
					A[b+k] = A[t+k];
					A[t+k] = buf;
				}
			}
			System.out.print(A[0]);
			for(int i=1;i<A.length;i++) {
				System.out.print(" " + A[i]);
			}
			System.out.println();
		}
	}
}
