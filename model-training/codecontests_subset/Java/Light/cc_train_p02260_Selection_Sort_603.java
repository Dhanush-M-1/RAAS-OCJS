import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		int i, j, min, w, cnt=0;
		for(i=0; i<N; i++){
			A[i] = sc.nextInt();
		}
		for(i=0; i<N-1; i++){
			min = i;
			for(j=i+1; j<N; j++){
				if(A[min]>A[j]) min = j;
			}
			if(min!=i){
				w      = A[i];
				A[i]   = A[min];
				A[min] = w;
				cnt++;
			}
		}
		for(i=0; i<N; i++){
			if(i!=0) System.out.print(" ");
			System.out.print(A[i]);
		}
		System.out.println();
		System.out.println(cnt);
	}
}