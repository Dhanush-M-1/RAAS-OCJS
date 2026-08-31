import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N==1) {
			System.out.println(1);
			return ;
		}
		int M = sc.nextInt();
		Set<Integer> set = new HashSet<Integer>();
		for (int i=0;i<M;i++) {
			set.add(sc.nextInt());
		}
		long A[]= new long[N];
		A[0]=1;
		if (set.contains(1)==false) {
			A[1]=1;
		}
		for(int i=2;i<N;i++) {
			if (set.contains(i)==false) {
				A[i]=(A[i-1]+A[i-2])%1000000007;
			}
		}
		System.out.println((A[N-1]+A[N-2])%1000000007);
	}
}