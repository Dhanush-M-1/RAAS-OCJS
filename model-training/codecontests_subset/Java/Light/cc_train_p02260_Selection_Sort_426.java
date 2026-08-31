import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		for(int i=0;i<N;i++){
			A[i] = sc.nextInt();
		}
		selectionSort(A,N);
	}
	public static void selectionSort(int[] A,int N){
		int count=0;
		for(int i=0;i<N;i++){
			int minj=i;
			for(int j=i;j<N;j++){
				if(A[j]<A[minj])minj=j;
			}
			if(i!=minj){
				int c = A[i];
				A[i] = A[minj];
				A[minj] = c;
				count++;
			}
		}

		for(int i=0;i<N;i++){
			System.out.print(A[i]);
			if(i!=N-1)System.out.print(" ");
		}
		System.out.printf("\n%d\n",count);
	}
}
