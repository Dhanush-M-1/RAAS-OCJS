import java.util.*;
public class Main {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[]=new int[N+1];
		int B[]=new int[N+1];
		int C[]=new int[N];
		int ans=0;
		for(int i=1;i<=N;i++){
			A[i]=sc.nextInt();
		}
		for(int i=1;i<=N;i++){
			B[i]=sc.nextInt();
		}
		for(int i=1;i<=N-1;i++){
			C[i]=sc.nextInt();
		}
		for(int i=1;i<=N;i++){
			ans=ans+B[A[i]];
		}
		for(int i=1;i<=N-1;i++){
		if (A[i]+1==A[i+1]) {
				ans=ans+C[A[i]];
			}
		}
		System.out.println(ans);
    }
}