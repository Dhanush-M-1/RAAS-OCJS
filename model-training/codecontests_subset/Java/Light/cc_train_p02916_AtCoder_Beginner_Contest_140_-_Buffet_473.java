import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		//    	File file = new File("src/in.txt");
		//    	Scanner sc = new Scanner(file);

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] A = new int[N+1];
		int ans = 0;
		int[] C = new int[N];
		for(int i=1;i<=N;i++) {
			A[i]=sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			ans += sc.nextInt();
		}
		for(int i=1;i<=N-1;i++) {
			C[i]=sc.nextInt();
		}
		sc.close();
		for(int i=2;i<=N;i++) {
			if(A[i]-A[i-1]==1) {
				ans += C[A[i-1]];
			}
		}
		System.out.println(ans);


	}
}