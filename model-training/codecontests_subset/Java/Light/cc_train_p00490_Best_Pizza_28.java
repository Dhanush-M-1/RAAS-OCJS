import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int D = in.nextInt();
		int D2 = in.nextInt();
		int A = in.nextInt();
		int[]B = new int [N+1];
		for(int i = 0;i < N;i++){
			B[i] = in.nextInt();
		}
		int max = A / D;
		int cng;
		for(int i = 0;i < N;i++){
			D += D2;
			B[N] = 0;
			for(int j = 0;j < N;j++){
				if(B[N] < B[j]){
					if(B[N] == B[j]){
						B[j] = 0;
					}
					cng = B[j];
					B[j] = B[N];
					B[N] = cng;
				}
			}
			A += B[N];
			if(max < A / D){
				max = A / D;
			}
		}
		System.out.println(max);
	}
}