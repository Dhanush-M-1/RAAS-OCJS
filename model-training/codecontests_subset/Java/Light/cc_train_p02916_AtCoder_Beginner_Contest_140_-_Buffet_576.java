import java.io.PrintWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int N = Integer.parseInt(stdin.next());
		int A[] = new int[N+10];
		int B[] = new int[N+10];
		int C[] = new int[N];
		int sum = 0;
		
		for(int i=1;i<=N;i++) {
			A[i] = Integer.parseInt(stdin.next());
		}
		for(int i=1;i<=N;i++) {
			B[i] = Integer.parseInt(stdin.next());
		}
		for(int i=1;i<=N-1;i++) {
			C[i] = Integer.parseInt(stdin.next());
		}
		
		for(int i=1;i<=N;i++) {
			sum+=B[A[i]];
			if(A[i] + 1 == A[i+1]) {
				sum+=C[A[i]];
			}
		}
		out.println(sum);
		out.flush();
	}
	
}