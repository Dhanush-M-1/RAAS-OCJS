import java.util.Scanner;

public class Main{
    public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int A[] = new int[N];
	int B[] = new int[N];
	int C[] = new int[N];
	int ans = 0;

	for(int i = 0; i < N; i++){
	    A[i] = sc.nextInt();
	}
	for(int i = 0; i < N; i++){
	    B[i] = sc.nextInt();
	}
	for(int i = 0; i < N - 1; i++){
	    C[i] = sc.nextInt();
	}

	int num = 0;	
	for(int i = 0; i < N; i++){
	    num = (A[i] - 1);
	    ans = ans + B[num];
	    if((i + 1) != N && A[i + 1] - A[i] == 1){
		ans = ans + C[num];
	    }
	}

	System.out.println(ans);
    }
}
