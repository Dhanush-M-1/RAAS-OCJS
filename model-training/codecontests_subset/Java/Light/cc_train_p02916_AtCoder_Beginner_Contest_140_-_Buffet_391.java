import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner stdIn=new Scanner(System.in);
		int N=stdIn.nextInt();
		int A[]=new int[N];
		int B[]=new int[N];
		int C[]=new int[N];
		int z=0,ans=0;
		while(z<N){
			A[z]=stdIn.nextInt()-1;
			z++;
		}z=0;
		while(z<N){
			int b=0;
			b=stdIn.nextInt();
			B[z]=b;
			z++;
		}z=0;
		while(z<N-1){
			int c=stdIn.nextInt();
			C[z]=c;
			z++;
		}z=1;
		ans+=B[0];
		while(z<N){
			ans+=B[z];
			if(A[z-1]+1==A[z])
				ans+=C[A[z-1]];
			z++;
		}
		System.out.println(ans);
	}
}