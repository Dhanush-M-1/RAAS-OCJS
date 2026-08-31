import java.util.*;

class Main{

    public static void main(String[] args){

	Scanner sc = new Scanner(System.in);

	int N = sc.nextInt();

	int[] A = new int[N+1];

	for(int i=0; i<N; i++){

	A[i] = sc.nextInt();

  }

	A[N] = N+2;

	int[] B = new int[N];

	for(int i=0; i<N; i++){

	B[i] = sc.nextInt();

  }

	int[] C = new int[N-1];

	for(int i=0; i<N-1; i++){

	C[i] = sc.nextInt();

  }
	
	int ans = 0;

	for(int i=0; i<N; i++){

	ans += B[A[i]-1];	

	if((A[i+1]-A[i])==1){

	ans += C[A[i]-1];

   }

  }
	
	System.out.println(ans);

 }
}